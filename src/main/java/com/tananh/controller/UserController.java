package com.tananh.controller;

import com.tananh.modal.User;
import com.tananh.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() throws Exception{
        List<User> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }


}
