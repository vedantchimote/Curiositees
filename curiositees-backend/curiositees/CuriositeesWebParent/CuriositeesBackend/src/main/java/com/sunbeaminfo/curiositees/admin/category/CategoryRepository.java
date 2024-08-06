/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 06-08-2024, Tuesday
 * @Time : 01:07 am
 **/

package com.sunbeaminfo.curiositees.admin.category;

import com.curiositees.common.entity.Category;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 06-08-2024, Tuesday
 **/

public interface CategoryRepository extends CrudRepository<Category, Integer>,
    PagingAndSortingRepository<Category, Integer> {

  @Query("SELECT c FROM Category c WHERE c.parent.id is NULL")
  public List<Category> findRootCategories();
}
