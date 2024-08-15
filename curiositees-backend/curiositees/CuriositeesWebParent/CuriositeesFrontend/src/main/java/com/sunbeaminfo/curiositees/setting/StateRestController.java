/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 * @Time : 07:48 pm
 **/

package com.sunbeaminfo.curiositees.setting;

import com.curiositees.common.entity.Country;
import com.curiositees.common.entity.State;
import com.curiositees.common.entity.StateDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping("/settings/list_states_by_country/{id}")
  public List<StateDTO> listByCountry(@PathVariable("id") Integer countryId) {
    List<State> listStates = repo.findByCountryOrderByNameAsc(new Country(countryId));
    List<StateDTO> result = new ArrayList<>();

    for (State state : listStates) {
      result.add(new StateDTO(state.getId(), state.getName()));
    }

    return result;
  }

}