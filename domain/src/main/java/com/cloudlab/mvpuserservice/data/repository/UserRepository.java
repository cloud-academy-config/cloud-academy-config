package com.cloudlab.mvpuserservice.data.repository;

import com.cloudlab.mvpuserservice.data.entity.UserEntity;

public interface UserRepository {
    UserEntity findByUserId(String userId);
    Iterable<UserEntity> findAll();
    UserEntity save(UserEntity userEntity);
}
