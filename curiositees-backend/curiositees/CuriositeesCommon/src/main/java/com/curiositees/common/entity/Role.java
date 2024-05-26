/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 19-05-2024, Sunday
 * @Time : 06:33 pm
 **/

package com.curiositees.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 19-05-2024, Sunday
 **/

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 50, nullable = false, unique = true)
  private String name;

  @Column(length = 255, nullable = false)
  private String description;

  public Role(String name, String description) {
    this.name = name;
    this.description = description;
  }
  public Role(Integer id) {
    this.id = id;
  }

  public Role(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Role role = (Role) o;
    return Objects.equals(id, role.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

  @Override
  public String toString() {
    return "Role{" +
        "name='" + name + '\'' +
        '}';
  }
}
