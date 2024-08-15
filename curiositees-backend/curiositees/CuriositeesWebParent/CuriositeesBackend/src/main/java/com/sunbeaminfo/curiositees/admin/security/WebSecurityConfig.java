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
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
@EnableWebSecurity
public class WebSecurityConfig {

  @Bean
  public UserDetailsService userDetailsService() {
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
  SecurityFilterChain configureHttp(HttpSecurity http) throws Exception {
    http.authenticationProvider(authenticationProvider());

    http.authorizeHttpRequests(auth -> auth
            .requestMatchers("/users/**").hasAuthority("Admin")
            .requestMatchers("/categories/**").hasAnyAuthority("Admin", "Editor")
//            .requestMatchers("/products/**").hasAnyAuthority("Admin", "Salesperson", "Editor", "Shipper")
            .requestMatchers("/brands/**").hasAnyAuthority("Admin", "Editor")
            .requestMatchers("/questions/**").hasAnyAuthority("Admin", "Assistant")
            .requestMatchers("/reviews/**").hasAnyAuthority("Admin", "Assistant")
            .requestMatchers("/customers/**").hasAnyAuthority("Admin", "Salesperson")
            .requestMatchers("/shipping/**").hasAnyAuthority("Admin", "Salesperson")
            .requestMatchers("/orders/**").hasAnyAuthority("Admin", "Salesperson", "Shipper")
            .requestMatchers("/reports/**").hasAnyAuthority("Admin", "Salesperson")
            .requestMatchers("/articles/**").hasAnyAuthority("Admin")
            .requestMatchers("/menus/**").hasAnyAuthority("Admin", "Editor")
            .requestMatchers("/settings/**").hasAnyAuthority("Admin", "Editor")

            .requestMatchers("/products/new", "/products/delete/**").hasAnyAuthority("Admin", "Editor")

            .requestMatchers("/products/edit/**", "/products/save", "/products/check_unique")
            .hasAnyAuthority("Admin", "Editor", "Salesperson")

            .requestMatchers("/products", "/products/", "/products/detail/**", "/products/page/**")
            .hasAnyAuthority("Admin", "Editor", "Salesperson", "Shipper")

            .requestMatchers("/products/**").hasAnyAuthority("Admin", "Editor")

        //To get the json api for all users by admin
            .requestMatchers("/api/users/all").hasAnyAuthority("Admin")
//            .requestMatchers("/cart/**").hasAnyAuthority("Admin", "Manager", "User")
//            .requestMatchers("/checkout/**").hasAnyAuthority("Admin", "Manager", "User")
//            .requestMatchers("/profile/**").hasAnyAuthority("Admin", "Manager", "User")
//            .requestMatchers("/login").permitAll()
//            .requestMatchers("/register").permitAll()
//            .requestMatchers("/").permitAll()
            .anyRequest().authenticated()
    )
//    http.authorizeHttpRequests(auth -> auth
//            .anyRequest().authenticated()
//        )
        .formLogin(form -> form
            .loginPage("/login")
            .usernameParameter("email")
            .permitAll())

        .logout(logout -> logout.permitAll())

        .rememberMe(rem -> rem
            .key("AbcDefgHijKlmnOpqrs_1234567890")
            .tokenValiditySeconds(7 * 24 * 60 * 60));

    http.headers(headers -> headers.frameOptions(f -> f.sameOrigin()));

    return http.build();
  }

  @Bean
  WebSecurityCustomizer configureWebSecurity() throws Exception {
    return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
  }

}
