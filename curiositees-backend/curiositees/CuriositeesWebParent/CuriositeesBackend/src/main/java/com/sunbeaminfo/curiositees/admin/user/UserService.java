/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 26-05-2024, Sunday
 * @Time : 10:54 am
 **/

package com.sunbeaminfo.curiositees.admin.user;

import com.curiositees.common.entity.Role;
import com.curiositees.common.entity.User;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 26-05-2024, Sunday
 **/

// This annotation marks the class as a service component
@Service
// This annotation is used to indicate that the methods of the class are transactional methods
@Transactional
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public List<User> listAll() {
    return (List<User>) userRepository.findAll();
  }

  public List<Role> listRoles() {
    return (List<Role>) roleRepository.findAll();
  }

  /* This method is used to save a user object to the database and return the saved user object */
  public User save(User user) {
    boolean isUpdatingUser = (user.getId() != null);

    if (isUpdatingUser) {
      User existingUser = userRepository.findById(user.getId()).get();
      if (user.getPassword().isEmpty()) {
        user.setPassword(existingUser.getPassword());
      } else {
        // If the password is not empty, encode the password before saving the user object to the database
        encodePassword(user);
      }
    } else {
      encodePassword(user);
    }
    return userRepository.save(user);
  }

  /*   This method is used to encode the password of a user object
     before saving it to the database using the passwordEncoder bean object
     to encode the password using the BCryptPasswordEncoder algorithm*/
  private void encodePassword(User user) {
    String encodedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodedPassword);
  }

  /*   This method is used to check if the email address is unique or not
     by checking if the email address is already present in the database or not using the email parameter*/
  public boolean isEmailUnique(Integer id, String email) {
    User userByEmail = userRepository.getUserByEmail(email);

    // If the userByEmail object is null, return true
    if (userByEmail == null) {
      return true;
    }

    // If the id parameter is not null, check if the email address is already present in the database
    boolean isCreatingNew = (id == null);

    // If the id parameter is null, check if the email address is already present in the database
    if (isCreatingNew) {
      if (userByEmail != null) {
        return false;
      }
    } else {
      if (userByEmail.getId() != id) {
        return false;
      }
    }
    return true;
  }

  /*   This method is used to check if the username is unique or not
     by checking if the username is already present in the database or not using the username parameter*/
  public User get(Integer id) throws UserNotFoundException {
    try {
      return userRepository.findById(id).get();
    } catch (NoSuchElementException e) {
      throw new UserNotFoundException("User with id " + id + " not found");
    }
  }

  /*   This method is used to delete a user object from the database using the id parameter
     as the query parameter value and throw a UserNotFoundException if the user object is not found */
  public void delete(Integer id) throws UserNotFoundException {
    Long countById = userRepository.countById(id);

    // If the countById value is null or 0, throw a UserNotFoundException
    if (countById == null || countById == 0) {
      throw new UserNotFoundException("Could not find any user with ID " + id);
    }
    userRepository.deleteById(id);
  }

  /*   This method is used to update the enabled status of a user object in the database using the id parameter
     as the query parameter value and the enabled parameter as the new value for the enabled status */
  public void updateUserEnabledStatus(Integer id, boolean enabled) {
    userRepository.updateEnabledStatus(id, enabled);
  }
}
