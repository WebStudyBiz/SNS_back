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
        userRepository.save(user.toEntity());
        return false;
    }

    @Override
    public ArrayList<RegisterDTO> findAllUser() {
        return null;
    }

    @Override
    public RegisterDTO findByOneUser(String userId) {
        return null;
    }

    @Override
    public boolean deleteUser(String userId) {
        return false;
    }

    @Override
    public boolean updateUser(RegisterDTO user) {
        return false;
    }
}
