/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 28-07-2024, Sunday
 * @Time : 11:42 am
 **/

package com.sunbeaminfo.curiositees.admin.security;

import com.curiositees.common.entity.Role;
import com.curiositees.common.entity.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 28-07-2024, Sunday
 **/

public class CuriositeesUserDetails implements UserDetails {

  private User user;

  public CuriositeesUserDetails(User user) {
    this.user = user;
  }
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Set<Role> roles = user.getRoles();

    List<SimpleGrantedAuthority> authories = new ArrayList<>();

    for (Role role : roles) {
      authories.add(new SimpleGrantedAuthority(role.getName()));
    }

    return authories;
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getEmail();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return user.isEnabled();
  }

  public String getFullname() {
    return this.user.getFirstName() + " " + this.user.getLastName();
  }
}
