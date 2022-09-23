package com.cloudlab.mvpuserservice.service;

import com.cloudlab.mvpuserservice.data.dto.UserDto;
import com.cloudlab.mvpuserservice.data.entity.UserEntity;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();
}
