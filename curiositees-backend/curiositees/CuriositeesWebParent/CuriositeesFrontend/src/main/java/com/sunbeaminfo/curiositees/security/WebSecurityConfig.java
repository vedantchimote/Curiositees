/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 28-05-2024, Tuesday
 * @Time : 03:01 pm
 **/

package com.sunbeaminfo.curiositees.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
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

//  @Bean
//  SecurityFilterChain configureHttp(HttpSecurity http) throws Exception {
//    http.authenticationProvider(authenticationProvider());
//
//    http.authorizeHttpRequests(auth -> auth
//            .requestMatchers("/users/**").hasAuthority("Admin")
//            .requestMatchers("/categories/**").hasAnyAuthority("Admin", "Editor")
//            .requestMatchers("/brands/**").hasAnyAuthority("Admin", "Editor")
//            .requestMatchers("/questions/**").hasAnyAuthority("Admin", "Assistant")
//            .requestMatchers("/reviews/**").hasAnyAuthority("Admin", "Assistant")
//            .requestMatchers("/customers/**").hasAnyAuthority("Admin", "Salesperson")
//            .requestMatchers("/shipping/**").hasAnyAuthority("Admin", "Salesperson")
//            .requestMatchers("/orders/**").hasAnyAuthority("Admin", "Salesperson", "Shipper")
//            .requestMatchers("/reports/**").hasAnyAuthority("Admin", "Salesperson")
//            .requestMatchers("/articles/**").hasAnyAuthority("Admin")
//            .requestMatchers("/menus/**").hasAnyAuthority("Admin", "Editor")
//            .requestMatchers("/settings/**").hasAnyAuthority("Admin", "Editor")
//
//            .requestMatchers("/products/new", "/products/delete/**").hasAnyAuthority("Admin", "Editor")
//
//            .requestMatchers("/products/edit/**", "/products/save", "/products/check_unique")
//            .hasAnyAuthority("Admin", "Editor", "Salesperson")
//
//            .requestMatchers("/products", "/products/", "/products/detail/**", "/products/page/**")
//            .hasAnyAuthority("Admin", "Editor", "Salesperson", "Shipper")
//
//            .requestMatchers("/products/**").hasAnyAuthority("Admin", "Editor")
//
//            .requestMatchers("/api/users/all").hasAnyAuthority("Admin")
//
//            .anyRequest().authenticated()
//    )
//        .formLogin(form -> form
//            .loginPage("/login")
//            .usernameParameter("email")
//            .permitAll())
//
//        .logout(logout -> logout.permitAll())
//
//        .rememberMe(rem -> rem
//            .key("AbcDefgHijKlmnOpqrs_1234567890")
//            .tokenValiditySeconds(7 * 24 * 60 * 60));
//
//    return http.build();
//  }

  @Bean
  WebSecurityCustomizer configureWebSecurity() throws Exception {
    return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
  }

}
