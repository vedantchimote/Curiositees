/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 * @Time : 03:42 pm
 **/

package com.sunbeaminfo.curiositees.admin.setting;

import com.curiositees.common.entity.Setting;
import com.curiositees.common.entity.SettingBag;
import java.util.List;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 **/

public class GeneralSettingBag extends SettingBag {

  public GeneralSettingBag(List<Setting> listSettings) {
    super(listSettings);
  }

  public void updateCurrencySymbol(String value) {
    super.update("CURRENCY_SYMBOL", value);
  }

  public void updateSiteLogo(String value) {
    super.update("SITE_LOGO", value);
  }
}