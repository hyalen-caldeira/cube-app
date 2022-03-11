package com.cubeapp.cubeapp.core.service;

import org.springframework.stereotype.Service;
import com.cubeapp.cubeapp.core.dto.UserDto;
import com.cubeapp.cubeapp.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserModel> getAllUsers();
    UserDto findByName(String name);
    void update(UserDto dto);
    UserDto create(UserDto dto);
}
