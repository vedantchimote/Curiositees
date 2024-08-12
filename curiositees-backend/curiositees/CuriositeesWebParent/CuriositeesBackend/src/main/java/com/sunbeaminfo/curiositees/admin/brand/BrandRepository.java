/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 12-08-2024, Monday
 * @Time : 08:24 pm
 **/

package com.sunbeaminfo.curiositees.admin.brand;

import com.curiositees.common.entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 12-08-2024, Monday
 **/

public interface BrandRepository extends PagingAndSortingRepository<Brand, Integer>,
    JpaRepository<Brand, Integer> {

  public Long countById(Integer id);

  public Brand findByName(String name);

  @Query("SELECT b FROM Brand b WHERE b.name LIKE %?1%")
  public Page<Brand> findAll(String keyword, Pageable pageable);
}
