package com.example.snsproject_biz.auth.service;

public interface RegisterService {
    public boolean checkUserIdDuplicate(String userId);
    public boolean checkNicknameDuplicate(String nickname);
}
