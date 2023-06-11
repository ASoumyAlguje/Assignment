package com.build.services.impl;

import com.build.entity.User;
import com.build.exceptions.ResourceNotFoundException;
import com.build.payloads.UserDto;
import com.build.repositories.UserRepo;
import com.build.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);

        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "UserId", userId));

        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());

        User updatedUser = this.userRepo.save(user);
        UserDto userDto1 = this.userToDto(updatedUser);

        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {

        User user = this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));

        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> userList= this.userRepo.findAll();

        List<UserDto> userDtoList = userList.stream().map(user->this.userToDto(user)).collect(Collectors.toList());

        return userDtoList;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));

        this.userRepo.delete(user);
    }

    public User dtoToUser(UserDto userDto)
    {
        User user = new User();

        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());

        return user;
    }

    public UserDto userToDto(User user)
    {
        UserDto userdto = new UserDto();

        userdto.setId(user.getId());
        userdto.setName(user.getName());
        userdto.setPassword(user.getPassword());
        userdto.setEmail(user.getEmail());

        return userdto;
    }
}
