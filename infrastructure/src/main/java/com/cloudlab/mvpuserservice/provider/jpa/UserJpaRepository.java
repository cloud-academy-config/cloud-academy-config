package com.cloudlab.mvpuserservice.provider.jpa;

import com.cloudlab.mvpuserservice.data.entity.UserEntity;
import com.cloudlab.mvpuserservice.data.repository.UserRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends UserRepository, CrudRepository<UserEntity, Long> {
    @Override
    UserEntity findByUserId(String userId);

    @Override
    Iterable<UserEntity> findAll();

    @Override
    UserEntity save(UserEntity userEntity);
}
