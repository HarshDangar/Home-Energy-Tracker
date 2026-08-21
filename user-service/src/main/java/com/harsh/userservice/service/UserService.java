package com.harsh.userservice.service;

import com.harsh.userservice.domain.dtos.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long id);
    void updateUser(Long id, UserDto userDto);
    void deleteUser(Long id);
}
