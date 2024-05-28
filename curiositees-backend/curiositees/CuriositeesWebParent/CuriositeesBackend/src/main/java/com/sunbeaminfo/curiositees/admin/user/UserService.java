/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 26-05-2024, Sunday
 * @Time : 10:54 am
 **/

package com.sunbeaminfo.curiositees.admin.user;

import com.curiositees.common.entity.Role;
import com.curiositees.common.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 26-05-2024, Sunday
 **/

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public List<User> listAll()
  {
    return (List<User>) userRepository.findAll();
  }

  public List<Role> listRoles()
  {
    return (List<Role>) roleRepository.findAll();
  }

  public void save(User user) {
    encodePassword(user);
    userRepository.save(user);
  }

  private void encodePassword(User user) {
    String encodedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodedPassword);
  }

  public boolean isEmailUnique(String email)
    {
      User user = userRepository.getUserByEmail(email);
      return user == null;
    }
}
