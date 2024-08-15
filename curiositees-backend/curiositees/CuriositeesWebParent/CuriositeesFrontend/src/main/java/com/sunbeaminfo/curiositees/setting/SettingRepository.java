/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 * @Time : 04:00 pm
 **/

package com.sunbeaminfo.curiositees.setting;

import com.curiositees.common.entity.Setting;
import com.curiositees.common.entity.SettingCategory;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 **/

public interface SettingRepository extends CrudRepository<Setting, String> {

  public List<Setting> findByCategory(SettingCategory category);

  @Query("SELECT s FROM Setting s WHERE s.category = ?1 OR s.category = ?2")
  public List<Setting> findByTwoCategories(SettingCategory catOne, SettingCategory catTwo);
}