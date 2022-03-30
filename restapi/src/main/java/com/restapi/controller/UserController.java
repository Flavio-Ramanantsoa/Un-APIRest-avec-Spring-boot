package com.restapi.controller;


// mvn org.springframework.boot:spring-boot-maven-plugin:run

import com.restapi.model.User;
import com.restapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;
       
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = this.userService.findAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/id")
    public ResponseEntity<User> getUserById(
        @RequestParam(value = "id") Long id
    ) {
        User user = this.userService.findUserById(id);
        user = (user != null) ? user : new User();
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User newUser) {
        User user = this.userService.addUser(newUser);
        return new ResponseEntity<User >(user, HttpStatus.OK);
    }

    @GetMapping("/find/email")
    public ResponseEntity<User> getUserByEmail(
        @RequestParam(value = "email") String email
    ) {
        User user = this.userService.getUserByEmail(email);
        return new ResponseEntity<User>(user, HttpStatus.OK);

    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUserById(
        @RequestParam(value = "id") Long id
    ) {
        this.userService.deleteUserById(id);
        return new ResponseEntity<String>("L'utilisateur avec l'id: " + id + "a été bien effacé.", HttpStatus.OK);
    }

}
