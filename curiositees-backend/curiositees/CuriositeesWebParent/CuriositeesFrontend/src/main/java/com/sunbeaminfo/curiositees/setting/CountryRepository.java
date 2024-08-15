/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 * @Time : 07:47 pm
 **/

package com.sunbeaminfo.curiositees.setting;

import com.curiositees.common.entity.Country;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 **/

public interface CountryRepository extends CrudRepository<Country, Integer> {
  public List<Country> findAllByOrderByNameAsc();
}