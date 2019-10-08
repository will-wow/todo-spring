package com.carbonfive.todo.user;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserJpaController {
  @Autowired
  private UserRepository userRepository;

  @GetMapping("/jpa/users")
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/jpa/users/{id}")
  public User getUser(@PathVariable int id) {
    Optional<User> user = userRepository.findById(id);

    if (!user.isPresent()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
    }

    return user.get();
  }

  @PostMapping("/jpa/users")
  @ResponseStatus(HttpStatus.CREATED)
  public User createUser(@Valid @RequestBody User user) {
    System.out.println(user);
    userRepository.save(user);
    return user;
  }

  @DeleteMapping("/jpa/users/{id}")
  public void deleteUser(@PathVariable int id) {
    userRepository.deleteById(id);
  }
}