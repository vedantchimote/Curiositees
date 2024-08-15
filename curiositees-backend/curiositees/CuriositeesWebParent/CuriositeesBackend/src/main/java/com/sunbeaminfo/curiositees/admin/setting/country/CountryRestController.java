/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 * @Time : 05:47 pm
 **/

package com.sunbeaminfo.curiositees.admin.setting.country;

import com.curiositees.common.entity.Country;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 **/

@RestController
public class CountryRestController {

  @Autowired
  private CountryRepository repo;

  @GetMapping("/countries/list")
  public List<Country> listAll() {
    return repo.findAllByOrderByNameAsc();
  }

  @PostMapping("/countries/save")
  public String save(@RequestBody Country country) {
    Country savedCountry = repo.save(country);
    return String.valueOf(savedCountry.getId());
  }

  @GetMapping("/countries/delete/{id}")
  public void delete(@PathVariable("id") Integer id) {
    repo.deleteById(id);
  }
}