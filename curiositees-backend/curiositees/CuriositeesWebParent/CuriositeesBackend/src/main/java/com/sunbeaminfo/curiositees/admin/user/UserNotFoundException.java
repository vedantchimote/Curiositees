/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 09-06-2024, Sunday
 * @Time : 05:03 pm
 **/

package com.sunbeaminfo.curiositees.admin.user;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 09-06-2024, Sunday
 **/

// This class is an exception class that is thrown when a user is not found in the database
public class UserNotFoundException extends Exception {

  // This constructor is used to create an instance of the UserNotFoundException class
  // with the specified message
  public UserNotFoundException(String message) {
    super(message);
  }
}
