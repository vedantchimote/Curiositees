/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 * @Time : 03:27 pm
 **/

package com.sunbeaminfo.curiositees.admin.setting;

import com.curiositees.common.entity.Setting;
import com.curiositees.common.entity.SettingCategory;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 **/

public interface SettingRepository extends CrudRepository<Setting, String> {

  public List<Setting> findByCategory(SettingCategory category);

}