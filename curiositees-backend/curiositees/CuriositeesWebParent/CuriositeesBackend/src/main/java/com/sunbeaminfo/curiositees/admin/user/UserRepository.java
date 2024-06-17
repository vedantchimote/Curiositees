/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 25-05-2024, Saturday
 * @Time : 05:18 pm
 **/

package com.sunbeaminfo.curiositees.admin.user;

import com.curiositees.common.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 25-05-2024, Saturday
 **/

// This annotation marks the interface as a repository component
@Repository
// This interface provides methods to perform CRUD operations on the User entity
public interface UserRepository extends CrudRepository<User, Integer> {

  /* This method is used to find a user by email address using the email parameter
   as the query parameter value and return the user object if found in the database
   or null if not found */

  // This annotation is used to specify the query to be executed
  @Query("Select u from User u where u.email = :email")
  public User getUserByEmail(@Param("email") String email);

  /* This method is used to count the number of users with the specified id in the database
     or 0 if not found */
  public Long countById(Integer id);

  /* This method is used to update the enabled status of a user in the database using the id parameter
  // as the query parameter value and the enabled parameter as the new value for the enabled status */

  // This annotation is used to specify the query to be executed
  @Query("Update User u set u.enabled = ?2 where u.id = ?1")
  // This annotation is used to indicate that the query is a modifying query
  @Modifying
  public void updateEnabledStatus(Integer id, boolean enabled);

}
