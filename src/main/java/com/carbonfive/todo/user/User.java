package com.carbonfive.todo.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "A user")
@Entity
public class User {
  @Id
  @GeneratedValue
  private Integer id;

  @Size(min = 2, message = "Same should have at least two characters")
  @ApiModelProperty(notes = "Same should have at least two characters")
  private String name;

  @Past
  @ApiModelProperty(notes = "Should be in the past")
  private Date birthDate;

  @JsonIgnore
  private boolean admin;

  @OneToMany(mappedBy="user")
  private List<Post> posts;

  // Required for Hibernate when there's a constructor
  protected User() {
  }

  public User(Integer id, String name, Date birthdate, Boolean admin) {
    super();
    this.id = id;
    this.name = name;
    this.birthDate = birthdate;
    this.admin = admin || false;
  }

  public boolean isAdmin() {
    return admin;
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public List<Post> getPosts() {
    return posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }
}