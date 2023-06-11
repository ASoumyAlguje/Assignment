package com.build.services;

import java.util.List;
import com.build.entity.User;
import com.build.payloads.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);
}
