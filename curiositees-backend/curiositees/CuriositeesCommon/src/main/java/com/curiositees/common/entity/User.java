/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 25-05-2024, Saturday
 * @Time : 04:37 pm
 **/

package com.curiositees.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 25-05-2024, Saturday
 **/

// This annotation marks the class as an entity class
@Entity
// This annotation is used to provide the table name in the database
@Table(name = "users")
// This annotation is used to generate the getters and setters, toString, equals and hashCode methods
@Data
// This annotation is used to generate the no argument constructor
@NoArgsConstructor
// This annotation is used to generate the getters and setters
@Getter
@Setter
public class User {

  // This annotation is used to generate the primary key
  @Id
  // This annotation is used to generate the primary key value automatically
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  // This annotation is used to provide the column name in the database
  @Column(name = "id")
  private Integer id;

  // This annotation is used to provide the column name in the database and set the length of the column
  @Column(length = 128, nullable = false, unique = true)
  private String email;

  @Column(length = 128, nullable = false)
  private String password;

  @Column(name = "first_name", length = 50, nullable = false)
  private String firstName;

  @Column(name = "last_name", length = 50, nullable = false)
  private String lastName;

  @Column(length = 64)
  private String photos;

  private boolean enabled;

  // This annotation is used to create a many-to-many relationship between the User and Role entities
  @ManyToMany
  // This annotation is used to create a join table between the User and Role entities
  @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  public User(String email, String password, String firstName, String lastName) {
    this.email = email;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public void addRole(Role role) {
    this.roles.add(role);
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", email='" + email + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", roles=" + roles +
        '}';
  }

  // This annotation is used to ignore the method from the database schema generation process
  @Transient
  /*  This method is used to return the path of the user photos based on the user id and photos name */
  public String getPhotosImagePath() {
    // If the id or photos is null, return the default user image path
    if (id == null || photos == null) {
      return "/images/default-user.png";
    }

    //Before changing the run configuration (#Ignore)
    //used postman to test the correct url
    //return "/images/user-photos/" + this.id + "/" + this.photos;

    return "/user-photos/" + this.id + "/" + this.photos;

  }
  @Transient
  public String getFullName() {
    return firstName + " " + lastName;
  }
}