package com.example.datagenerator;

import com.example.model.Privilage;
import com.example.model.Role;
import com.example.model.User;
import com.example.repository.PrivilageRepository;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import jakarta.transaction.Transactional;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
  boolean alreadySetup = false;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PrivilageRepository privilegeRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  @Transactional
  public void onApplicationEvent(ContextRefreshedEvent event) {
    if (alreadySetup) {
      return;
    }

    Privilage readPrivilege
        = createPrivilegeIfNotFound("READ_PRIVILEGE");
    Privilage writePrivilege
        = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

    List<Privilage> adminPrivileges = Arrays.asList(
        readPrivilege, writePrivilege);
    createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
    createRoleIfNotFound("ROLE_USER", Collections.singletonList(readPrivilege));

    Optional<Role> adminRole = roleRepository.findByName("ROLE_ADMIN");
    User user = new User();
    user.setFirstName("Test");
    user.setLastName("Test");
    user.setPassword(passwordEncoder.encode("test"));
    user.setEmail("test@test.com");
    user.setRoles(List.of(adminRole.get()));
    user.setEnabled(true);
    userRepository.save(user);


    alreadySetup = true;

  }

  @Transactional
  Privilage createPrivilegeIfNotFound(String name) {

    Privilage privilege = privilegeRepository.findByName(name);
    if (privilege == null) {
      privilege = new Privilage(name);
      privilegeRepository.save(privilege);
    }
    return privilege;
  }

  @Transactional
  Role createRoleIfNotFound(
      String name, Collection<Privilage> privileges) {

    Optional<Role> optionalRole = roleRepository.findByName(name);
    if (!optionalRole.isPresent()) {
      Role role = new Role(name);
      role.setPrivileges(privileges);
      roleRepository.save(role);
      return role;
    }
    return optionalRole.get();
  }


}
