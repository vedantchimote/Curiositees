/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 12-08-2024, Monday
 * @Time : 08:24 pm
 **/

package com.sunbeaminfo.curiositees.admin.brand;

import com.curiositees.common.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 12-08-2024, Monday
 **/

public interface BrandRepository extends PagingAndSortingRepository<Brand, Integer>,
    JpaRepository<Brand, Integer> {

}
