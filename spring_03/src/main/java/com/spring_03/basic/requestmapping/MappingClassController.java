package com.spring_03.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {
  @GetMapping
  public String users() {
    return "get users";
  }

  @PostMapping
  public String addUser() {
    return "post user";
  }

  @GetMapping("/{userId}")
  public String user(@PathVariable Long userId) {
    return "get userId=" + userId;
  }

  @PatchMapping("/{userId}")
  public String updateUser(@PathVariable Long userId) {
    return "patch userId=" + userId;
  }

  @DeleteMapping("/{userId}")
  public String deleteUser(@PathVariable Long userId) {
    return "delete userId=" + userId;
  }
}
