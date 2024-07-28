/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 28-05-2024, Tuesday
 * @Time : 03:01 pm
 **/

package com.sunbeaminfo.curiositees.admin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 28-05-2024, Tuesday
 **/
// This class is used to configure the security for the application using Spring Security 6
@Configuration
public class WebSecurityConfig {

  @Bean
  UserDetailsService userDetailsService() {
    return new CuriositeesUserDetailsService();
  }

  //update in spring security 6, no need to extend WebSecurityConfigurerAdapter

  // This method is used to create a PasswordEncoder bean for the application using BCryptPasswordEncoder class
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

//  // This method is used to configure the HttpSecurity for the application
//  // using Spring Security 6 and return the SecurityFilterChain object
//  @Bean
//  SecurityFilterChain configureHttpSecurity(HttpSecurity http) throws Exception {
//    http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
//    return http.build();
//
//  }

  @Bean
  DaoAuthenticationProvider authenticationProvider()
  {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService());
    authenticationProvider.setPasswordEncoder(passwordEncoder());

    return authenticationProvider;
  }

  @Bean
  SecurityFilterChain configureHttpSecurity(HttpSecurity http) throws Exception {
    http.authenticationProvider(authenticationProvider());
    http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll()).
        formLogin(form -> form.loginPage("/login").usernameParameter("email").permitAll());
    return http.build();
  }

  @Bean
  WebSecurityCustomizer configureWebSecurity() {
    return (web) -> {
      web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
    };
  }
}
