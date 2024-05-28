/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 27-05-2024, Monday
 * @Time : 11:54 pm
 **/

package com.sunbeaminfo.curiositees.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class PasswordEncoderTest {

  @Test
  public void testEncodePassword() {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String rawPassrod = "password123";
    String encodedPassword = passwordEncoder.encode(rawPassrod);

    System.out.println(encodedPassword);

    final boolean matches = passwordEncoder.matches(rawPassrod, encodedPassword);
    assertThat(matches).isTrue();
  }

}
