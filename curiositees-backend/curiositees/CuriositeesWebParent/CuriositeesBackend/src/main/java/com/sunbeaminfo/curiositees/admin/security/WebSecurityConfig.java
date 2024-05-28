/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 28-05-2024, Tuesday
 * @Time : 03:01 pm
 **/

package com.sunbeaminfo.curiositees.admin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 28-05-2024, Tuesday
 **/

@Configuration
public class WebSecurityConfig {

  //update in spring security 6, no need to extend WebSecurityConfigurerAdapter

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  SecurityFilterChain configureHttpSecurity(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
    return http.build();
  }

}
