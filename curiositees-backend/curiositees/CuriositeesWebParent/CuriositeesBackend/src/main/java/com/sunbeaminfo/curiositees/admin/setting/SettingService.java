/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 * @Time : 03:44 pm
 **/

package com.sunbeaminfo.curiositees.admin.setting;

import com.curiositees.common.entity.Setting;
import com.curiositees.common.entity.SettingCategory;
import java.util.ArrayList;
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

  public List<Setting> listAllSettings() {
    return (List<Setting>) repo.findAll();
  }

  public GeneralSettingBag getGeneralSettings() {
    List<Setting> settings = new ArrayList<>();

    List<Setting> generalSettings = repo.findByCategory(SettingCategory.GENERAL);
    List<Setting> currencySettings = repo.findByCategory(SettingCategory.CURRENCY);

    settings.addAll(generalSettings);
    settings.addAll(currencySettings);

    return new GeneralSettingBag(settings);
  }

  public void saveAll(Iterable<Setting> settings) {
    repo.saveAll(settings);
  }
}