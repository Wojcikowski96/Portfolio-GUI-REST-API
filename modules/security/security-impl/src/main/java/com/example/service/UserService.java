package com.example.service;

import com.example.model.Role;
import com.example.model.User;
import com.example.model.UserRequest;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository usersRepository;
  private final RoleRepository roleRepository;

  private final PasswordEncoder passwordEncoder;
  public ResponseEntity registerUser(UserRequest userDto){
    Optional<User> optionalUser = usersRepository.findByEmail(userDto.getEmail());
    if(optionalUser.isPresent()){
      return ResponseEntity.status(500).body("User with given email already exists");

    }else{
      User user = new User();
      user.setFirstName(userDto.getFirstName());
      user.setLastName(userDto.getLastName());
      user.setPassword(passwordEncoder.encode(userDto.getPassword()));
      user.setEmail(userDto.getEmail());
      user.setEnabled(true);

      Optional<Role> role  = roleRepository.findByName("ROLE_USER");
      if(role.isPresent()){
        Collection<Role> roles = List.of(role.get());
        user.setRoles(roles);
      }
      usersRepository.save(user);

      return ResponseEntity.ok().body( "User registered");
    }

  }
}
