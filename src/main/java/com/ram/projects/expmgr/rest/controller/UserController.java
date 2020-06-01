package com.ram.projects.expmgr.rest.controller;

import com.ram.projects.expmgr.db.entity.ExpMgrUser;
import com.ram.projects.expmgr.domain.user.IUserManager;
import com.ram.projects.expmgr.rest.converter.UserInputConverter;
import com.ram.projects.expmgr.rest.converter.UserOutputConverter;
import com.ram.projects.expmgr.rest.dto.User;
import com.ram.projects.expmgr.rest.process.rest.RestProcessor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

import static com.ram.projects.expmgr.common.Constants.ROOT_END_POINT;

@RestController
@RequestMapping(ROOT_END_POINT + "/user")
public class UserController {
  private final RestProcessor restProcessor;
  private final IUserManager userManager;
  private final UserInputConverter userInputConverter;
  private final UserOutputConverter userOutputConverter;

  public UserController(
      IUserManager userManager,
      RestProcessor restProcessor,
      UserInputConverter userInputConverter,
      UserOutputConverter userOutputConverter) {
    this.userManager = userManager;
    this.restProcessor = restProcessor;
    this.userInputConverter = userInputConverter;
    this.userOutputConverter = userOutputConverter;
  }

  @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
  public CompletableFuture<User> addUser(HttpEntity<User> httpEntity) {
    return restProcessor.process(
        "Add a new User",
        httpEntity,
        userInputConverter,
        userOutputConverter,
        expmgrUser -> userManager.addUser((ExpMgrUser) expmgrUser));
  }

  @PostMapping(path = "/delete", consumes = "application/json", produces = "applicatin/json")
  public CompletableFuture<Long> deleteUser(HttpEntity<User> httpEntity) {
    return restProcessor.process(
        "Delete User",
        httpEntity,
        userInputConverter,
        userOutputConverter,
        expmgrUser -> userManager.deleteUser((ExpMgrUser) expmgrUser));
  }
}
