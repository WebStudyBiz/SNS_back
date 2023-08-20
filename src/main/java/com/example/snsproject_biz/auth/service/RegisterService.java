package com.example.snsproject_biz.auth.service;

import com.example.snsproject_biz.auth.domain.dto.RegisterDTO;

import java.util.ArrayList;

public interface RegisterService {
    public boolean checkUserIdDuplicate(String userId);
    public boolean checkNicknameDuplicate(String nickname);
    public boolean registerUser(RegisterDTO user);
    public ArrayList<RegisterDTO> findAllUser();
    public RegisterDTO findByOneUser(String userId);
    public boolean deleteUser(String userId);
    public boolean updateUser(RegisterDTO user);
}
