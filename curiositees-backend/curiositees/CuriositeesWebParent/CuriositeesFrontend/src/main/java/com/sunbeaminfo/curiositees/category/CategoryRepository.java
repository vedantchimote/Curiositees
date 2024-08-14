/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 13-08-2024, Tuesday
 * @Time : 08:31 pm
 **/

package com.sunbeaminfo.curiositees.category;

import com.curiositees.common.entity.Category;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 13-08-2024, Tuesday
 **/

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

  @Query("SELECT c FROM Category c WHERE c.enabled = true ORDER BY c.name ASC")
  List<Category> findAllEnabled();
}