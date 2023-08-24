package com.example.snsproject_biz.auth.repository;

import com.example.snsproject_biz.auth.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByUserId(String UserId);
    boolean existsByUserNickname(String nickName);
    ArrayList<UserEntity> findByUserId(String UserId);

    long deleteByUserId(String UserId);
}
