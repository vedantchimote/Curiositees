/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 19-05-2024, Sunday
 * @Time : 06:40 pm
 **/

package com.sunbeaminfo.curiositees.admin.user;

import com.curiositees.common.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 19-05-2024, Sunday
 **/

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
