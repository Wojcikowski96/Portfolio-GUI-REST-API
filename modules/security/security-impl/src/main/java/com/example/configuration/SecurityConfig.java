package com.example.configuration;

import com.example.filter.JwtAthFilter;
import com.example.filter.JwtException;
import com.example.service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
public class SecurityConfig {
  @Autowired
  private final JwtAthFilter jwtAuthFilter;
  @Autowired
  private final MyUserDetailsService myService;

  @Autowired
  private JwtException jwtException;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.cors().and()
        .authorizeHttpRequests((requests) -> {
          try {
            requests.requestMatchers("/authenticate", "/blog/entries",
                    "/blog/image", "/portfolio/details/image", "/portfolio/details/document",
                    "/email/send", "/portfolio/entries", "/portfolio/entry/details").permitAll()
                .requestMatchers("/portfolio/entry","/blog/entry","/blog/entry/uploadImage","/portfolio/entry/uploadImage",
                    "/portfolio/entry/uploadDocument" , "/portfolio/entries/delete", "/blog/entries/delete").hasAuthority("ROLE_ADMIN")

                .and().
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authenticationProvider(authenticationProvider()).exceptionHandling()
                .authenticationEntryPoint(jwtException).and()
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
          } catch (Exception e) {
            throw new RuntimeException(e);
          }
        }).
        csrf().disable();

    return http.build();
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    System.out.println("CORS Config success");
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:4200"); // "/create-cars"
      }
    };

  }


  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
      throws Exception {
    return config.getAuthenticationManager();
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    //tutaj wskazujemy customowy serwis user detailsowy, który może mieć inną logikę pozyskiwania userów (może być LDAP lub z bazy)
    authenticationProvider.setUserDetailsService(myService);
    authenticationProvider.setPasswordEncoder(passwordEncoder());
    return authenticationProvider;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {

    return new BCryptPasswordEncoder(15);

  }

  @Bean
  public RoleHierarchy roleHierarchy() {
    RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
    String hierarchy = "ROLE_ADMIN > ROLE_STAFF \n ROLE_STAFF > ROLE_USER";
    roleHierarchy.setHierarchy(hierarchy);
    return roleHierarchy;
  }

  @Bean
  public DefaultWebSecurityExpressionHandler myWebSecurityExpressionHandler() {
    DefaultWebSecurityExpressionHandler expressionHandler =
        new DefaultWebSecurityExpressionHandler();
    expressionHandler.setRoleHierarchy(roleHierarchy());
    return expressionHandler;
  }
}
