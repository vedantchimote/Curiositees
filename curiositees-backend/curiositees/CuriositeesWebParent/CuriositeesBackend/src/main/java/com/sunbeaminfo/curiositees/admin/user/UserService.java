/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 26-05-2024, Sunday
 * @Time : 10:54 am
 **/

package com.sunbeaminfo.curiositees.admin.user;

import com.curiositees.common.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

  public List<User> listAll()
  {
    return (List<User>) userRepository.findAll();
  }
}
