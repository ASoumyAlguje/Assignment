package com.build.services;

import java.util.List;
import com.build.entity.User;
import com.build.payloads.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

    //create
    UserDto createUser(UserDto user);

    //update
    UserDto updateUser(UserDto user, Integer userId);

    //get user by id
    UserDto getUserById(Integer userId);

    //get all user
    List<UserDto> getAllUsers();

    //delete
    void deleteUser(Integer userId);
}
