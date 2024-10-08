/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 * @Time : 03:28 pm
 **/

package com.sunbeaminfo.curiositees.admin.setting;
import static org.assertj.core.api.Assertions.assertThat;
import com.curiositees.common.entity.Setting;
import com.curiositees.common.entity.SettingCategory;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 **/

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class SettingRepositoryTests {

  @Autowired
  SettingRepository repo;

  @Test
  public void testCreateGeneralSettings() {
    Setting siteName = new Setting("SITE_NAME", "Curiositees", SettingCategory.GENERAL);
    Setting siteLogo = new Setting("SITE_LOGO", "../CuriositeesWebParent/site-logo/CuriositeesAdminSmall.png", SettingCategory.GENERAL);
    Setting copyright = new Setting("COPYRIGHT", "Copyright (C) 2024 Curiositees Ltd", SettingCategory.GENERAL);

    repo.saveAll(List.of(siteName, siteLogo, copyright));

    Iterable<Setting> iterable = repo.findAll();

    assertThat(iterable).size().isGreaterThan(0);
  }

  @Test
  public void testCreateCurrencySettings() {
    Setting currencyId = new Setting("CURRENCY_ID", "1", SettingCategory.CURRENCY);
    Setting symbol = new Setting("CURRENCY_SYMBOL", "$", SettingCategory.CURRENCY);
    Setting symbolPosition = new Setting("CURRENCY_SYMBOL_POSITION", "before", SettingCategory.CURRENCY);
    Setting decimalPointType = new Setting("DECIMAL_POINT_TYPE", "POINT", SettingCategory.CURRENCY);
    Setting decimalDigits = new Setting("DECIMAL_DIGITS", "2", SettingCategory.CURRENCY);
    Setting thousandsPointType = new Setting("THOUSANDS_POINT_TYPE", "COMMA", SettingCategory.CURRENCY);

    repo.saveAll(List.of(currencyId, symbol, symbolPosition, decimalPointType,
        decimalDigits, thousandsPointType));
  }


  @Test
  public void testListSettingsByCategory() {
    List<Setting> settings = repo.findByCategory(SettingCategory.GENERAL);

    settings.forEach(System.out::println);
  }
}