/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 28-05-2024, Tuesday
 * @Time : 03:01 pm
 **/

package com.sunbeaminfo.curiositees.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

//  @Bean
//  public UserDetailsService userDetailsService() {
//    return new CuriositeesUserDetailsService();
//  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

//  @Bean
//  DaoAuthenticationProvider authenticationProvider()
//  {
//    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//    authenticationProvider.setUserDetailsService(userDetailsService());
//    authenticationProvider.setPasswordEncoder(passwordEncoder());
//
//    return authenticationProvider;
//  }

  @Bean
  SecurityFilterChain configureHttp(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
    return http.build();
  }

  @Bean
  WebSecurityCustomizer configureWebSecurity() throws Exception {
    return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
  }

}
