/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 * @Time : 05:35 pm
 **/

package com.sunbeaminfo.curiositees.admin.setting.state;

import com.curiositees.common.entity.Country;
import com.curiositees.common.entity.State;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 **/

public interface StateRepository extends CrudRepository<State, Integer> {

  public List<State> findByCountryOrderByNameAsc(Country country);
}