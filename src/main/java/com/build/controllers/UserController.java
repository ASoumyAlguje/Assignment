package com.build.controllers;

import com.build.entity.User;
import com.build.payloads.UserDto;
import com.build.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //POST-> create user

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
    {
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    //PUT -> updating
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId)
    {
        UserDto updatedUser = this.userService.updateUser(userDto, userId);
        return ResponseEntity.ok(updatedUser);
    }

    //DELETE -> user delete

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uid)
    {
       this.userService.deleteUser(uid);
       return new ResponseEntity(Map.of("Message", "User deleted successfully"), HttpStatus.OK);
    }

    //GET -> getting users

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers()
    {
        List<UserDto> li = this.userService.getAllUsers();

        return ResponseEntity.ok(li);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Integer uid)
    {
        UserDto userDto = this.userService.getUserById(uid);

        return ResponseEntity.ok(userDto);
    }
}
