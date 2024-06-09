/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 25-05-2024, Saturday
 * @Time : 05:18 pm
 **/

package com.sunbeaminfo.curiositees.admin.user;

import com.curiositees.common.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 25-05-2024, Saturday
 **/

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

  @Query("Select u from User u where u.email = :email")
  public User getUserByEmail(@Param("email") String email);

  public Long countById(Integer id);

}
