package com.tistory.onethejay.userservice.repository;

import com.tistory.onethejay.userservice.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String username);
    UserEntity findByUserId(String userId);
}
