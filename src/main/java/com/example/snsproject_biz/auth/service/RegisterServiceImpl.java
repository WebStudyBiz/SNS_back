package com.example.snsproject_biz.auth.service;

import com.example.snsproject_biz.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return userRepository.existsByNickName(nickname);
    }
}
