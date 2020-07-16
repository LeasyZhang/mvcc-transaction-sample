package com.transaction.demo.api;

import com.transaction.demo.dto.UserDTO;
import com.transaction.demo.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public ResponseEntity<String> updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUserName(userDTO);
        return ResponseEntity.ok().body("Success");
    }

    @GetMapping("/print/{id}")
    public ResponseEntity<String> printUser(@PathVariable("id") Long id) {
        userService.printUserDelay(id);
        return ResponseEntity.ok().body("Success");
    }
}