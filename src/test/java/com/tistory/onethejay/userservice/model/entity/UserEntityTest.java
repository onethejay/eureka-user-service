package com.tistory.onethejay.userservice.model.entity;

import com.tistory.onethejay.userservice.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserEntityTest {

    @Autowired
    UserRepository userRepository;

    @DisplayName("1. 유저 리파지토리 테스트")
    @Test
    void test_1() {
        userRepository.findAll().forEach(System.out::println);
    }

    @DisplayName("2. 유저 저장 테스트")
    @Test
    @Transactional
    void test_2(){
        UserEntity userEntity = UserEntity.builder()
                .userId("userTest")
                .email("userEmail@email.com")
                .name("이름")
                .encryptedPwd("encrypted")
                .build();
        UserEntity savedEntity = userRepository.save(userEntity);

        assertThat(savedEntity.getUserId()).isEqualTo("userTest");
    }
}