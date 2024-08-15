/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 * @Time : 03:31 pm
 **/

package com.sunbeaminfo.curiositees.admin.setting;
import static org.assertj.core.api.Assertions.assertThat;
import com.curiositees.common.entity.Currency;
import java.util.Arrays;
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
public class CurrencyRepositoryTests {

  @Autowired
  private CurrencyRepository repo;

  @Test
  public void testCreateCurrencies() {
    List<Currency> listCurrencies = Arrays.asList(
        new Currency("United States Dollar", "$", "USD"),
        new Currency("British Pound", "£", "GPB"),
        new Currency("Japanese Yen", "¥", "JPY"),
        new Currency("Euro", "€", "EUR"),
        new Currency("Russian Ruble", "₽", "RUB"),
        new Currency("South Korean Won", "₩", "KRW"),
        new Currency("Chinese Yuan", "¥", "CNY"),
        new Currency("Brazilian Real", "R$", "BRL"),
        new Currency("Australian Dollar", "$", "AUD"),
        new Currency("Canadian Dollar", "$", "CAD"),
        new Currency("Vietnamese đồng ", "₫", "VND"),
        new Currency("Indian Rupee", "₹", "INR")
    );

    repo.saveAll(listCurrencies);

    Iterable<Currency> iterable = repo.findAll();

    assertThat(iterable).size().isEqualTo(12);
  }
}