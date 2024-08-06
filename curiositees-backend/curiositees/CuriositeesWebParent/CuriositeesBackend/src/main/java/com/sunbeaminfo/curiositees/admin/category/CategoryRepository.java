/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 06-08-2024, Tuesday
 * @Time : 01:07 am
 **/

package com.sunbeaminfo.curiositees.admin.category;

import com.curiositees.common.entity.Category;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
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
  public List<Category> findRootCategories(Sort sort);

  @Query("UPDATE Category c SET c.enabled = ?2 WHERE c.id = ?1")
  @Modifying
  public void updateEnabledStatus(Integer id, boolean enabled);

  @Query("SELECT c FROM Category c WHERE c.parent.id is NULL")
  public Page<Category> findRootCategories(Pageable pageable);

  public Long countById(Integer id);

  public Category findByName(String name);

  public Category findByAlias(String alias);
}
