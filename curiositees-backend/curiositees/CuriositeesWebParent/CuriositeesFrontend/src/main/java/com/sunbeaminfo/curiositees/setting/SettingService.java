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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 **/

@Service
public class SettingService {
  @Autowired
  private SettingRepository repo;

  public List<Setting> getGeneralSettings() {
    return repo.findByTwoCategories(SettingCategory.GENERAL, SettingCategory.CURRENCY);
  }

}