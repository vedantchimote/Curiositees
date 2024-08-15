/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 * @Time : 06:13 pm
 **/

package com.sunbeaminfo.curiositees.admin.setting.state;

import com.curiositees.common.entity.Country;
import com.curiositees.common.entity.State;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 **/

@RestController
public class StateRestController {

  @Autowired
  private StateRepository repo;

  @GetMapping("/states/list_by_country/{id}")
  public List<StateDTO> listByCountry(@PathVariable("id") Integer countryId) {
    List<State> listStates = repo.findByCountryOrderByNameAsc(new Country(countryId));
    List<StateDTO> result = new ArrayList<>();

    for (State state : listStates) {
      result.add(new StateDTO(state.getId(), state.getName()));
    }

    return result;
  }

  @PostMapping("/states/save")
  public String save(@RequestBody State state) {
    State savedState = repo.save(state);
    return String.valueOf(savedState.getId());
  }

  @DeleteMapping("/states/delete/{id}")
  public void delete(@PathVariable("id") Integer id) {
    repo.deleteById(id);
  }
}