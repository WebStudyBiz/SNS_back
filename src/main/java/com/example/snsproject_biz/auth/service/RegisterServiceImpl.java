package com.example.snsproject_biz.auth.service;

import com.example.snsproject_biz.auth.domain.dto.RegisterDTO;
import com.example.snsproject_biz.auth.domain.entity.UserEntity;
import com.example.snsproject_biz.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private final UserRepository userRepository;

    public boolean checkUserIdDuplicate(String userId){
        return userRepository.existsByUserId(userId);
    }
    public boolean checkNicknameDuplicate(String nickname){
        return userRepository.existsByUserNickname(nickname);
    }

    @Override
    public boolean registerUser(RegisterDTO user) {
        if(userRepository.save(user.toEntity()) instanceof UserEntity){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public ArrayList<UserEntity> findAllUser() {
        return null;
    }

    @Override
    public ArrayList<UserEntity> findByOneUser(String userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public long deleteUser(String userId) {
        return userRepository.deleteByUserId(userId);
    }

    @Override
    public boolean updateUser(RegisterDTO user) {
        if(userRepository.save(user.toEntity()) instanceof UserEntity){
            return true;
        }else {
            return false;
        }
    }
}
