/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 12-08-2024, Monday
 * @Time : 09:18 pm
 **/

package com.sunbeaminfo.curiositees.admin.product;

import com.curiositees.common.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 12-08-2024, Monday
 **/

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>,
    JpaRepository<Product, Integer> {

  public Product findByName(String name);

  @Query("UPDATE Product p SET p.enabled = ?2 WHERE p.id = ?1")
  @Modifying
  public void updateEnabledStatus(Integer id, boolean enabled);

  public Long countById(Integer id);
}
