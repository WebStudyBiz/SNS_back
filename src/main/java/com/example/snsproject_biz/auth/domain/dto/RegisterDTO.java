package com.example.snsproject_biz.auth.domain.dto;

import com.example.snsproject_biz.auth.domain.entity.UserEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import com.example.snsproject_biz.utill.DataCryptoUtill;

@Data
public class RegisterDTO {
    @NotBlank(message = "아이디가 비어있습니다.")
    private String userId;
    @NotBlank(message = "비밀번호가 비어있습니다.")
    private String userPassword;
    @Email
    @NotBlank(message = "이메일이 비어있습니다.")
    private String userEmail;
    @NotBlank(message = "닉네임이 비어있습니다.")
    private String userNickname;
    @Max(value=3)
    private int userLoginstate;
    private int userProfileId;
    private int userFollowId;

    public UserEntity toEntity(){
        DataCryptoUtill dataCryptoUtill = new DataCryptoUtill();

        return UserEntity.builder()
                .userId(userId)
                .userPassword(dataCryptoUtill.encoding(userPassword))
                .userEmail(userEmail)
                .userNickname(userNickname)
                .userLoginstate(userLoginstate)
                .userProfileId(userProfileId)
                .userFollowId(userFollowId)
                .build();
    }
}
