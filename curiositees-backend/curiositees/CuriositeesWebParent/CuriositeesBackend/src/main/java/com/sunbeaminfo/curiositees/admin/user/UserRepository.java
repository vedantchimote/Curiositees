/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 25-05-2024, Saturday
 * @Time : 05:18 pm
 **/

package com.sunbeaminfo.curiositees.admin.user;

import com.curiositees.common.entity.User;
import org.springframework.data.repository.CrudRepository; /**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 25-05-2024, Saturday
 **/

public interface UserRepository extends CrudRepository<User, Integer> {
}
