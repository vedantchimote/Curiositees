/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 * @Time : 03:31 pm
 **/

package com.sunbeaminfo.curiositees.admin.setting;

import com.curiositees.common.entity.Currency;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 **/

public interface CurrencyRepository extends CrudRepository<Currency, Integer> {

  public List<Currency> findAllByOrderByNameAsc();

}
