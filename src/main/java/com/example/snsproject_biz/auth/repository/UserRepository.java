package com.example.snsproject_biz.auth.repository;

import com.example.snsproject_biz.auth.domain.entity.UserEntity;
import com.example.snsproject_biz.auth.domain.vo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByUserId(String UserId);
    boolean existsByUserNickname(String nickName);
    Optional<UserVO> findByUserId(String UserId);
}
