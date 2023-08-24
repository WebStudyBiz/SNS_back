package com.example.snsproject_biz.auth.service;

import com.example.snsproject_biz.auth.domain.dto.RegisterDTO;
import com.example.snsproject_biz.auth.domain.entity.UserEntity;

import java.util.ArrayList;

public interface RegisterService {
    public boolean checkUserIdDuplicate(String userId);
    public boolean checkNicknameDuplicate(String nickname);
    public boolean registerUser(RegisterDTO user);
    public ArrayList<UserEntity> findAllUser();
    public ArrayList<UserEntity> findByOneUser(String userId);
    public long deleteUser(String userId);
    public boolean updateUser(RegisterDTO user);
}
