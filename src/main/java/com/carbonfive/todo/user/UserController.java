package com.carbonfive.todo.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {
  @Autowired
  private UserDaoService service;

  @GetMapping("/users")
  public List<User> getUsers() {
    return service.findAll();
  }

  @GetMapping("/users/{id}")
  public User getUser(@PathVariable int id) {
    User user = service.findOne(id);

    if (user == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
    }

    return user;
  }

  @PostMapping("/users")
  @ResponseStatus(HttpStatus.CREATED)
  public User createUser(@Valid @RequestBody User user) {
    service.save(user);
    return user;
  }
}