package com.example.snsproject_biz.auth.domain.vo;

import lombok.Data;

@Data
public class UserVO {
    private String userId;
    private String password;
    private String email;
    private String nickName;
    private int loginState;
    private String photoId;
    private String followId;
    private String createDate;
    private String modifyDate;
}
