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

// This annotation marks the class as an entity class
@Entity
// This annotation is used to provide the table name in the database
@Table(name = "roles")
// This annotation is used to generate the getters and setters, toString, equals and hashCode methods
@Data
// This annotation is used to generate the all argument constructor
@AllArgsConstructor
// This annotation is used to generate the no argument constructor
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

  // This method is used to compare the two objects of the Role class based on the id field
  // If the two objects have the same id, they are equal otherwise not equal
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

  // This method is used to generate the hash code of the object based on the id field
  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

  // This method is used to return the name of the role
  @Override
  public String toString() {
    return this.name;
  }
}
