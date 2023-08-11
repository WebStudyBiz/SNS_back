package com.example.snsproject_biz.auth.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterDTO {
    @NotBlank(message = "아이디가 비어있습니다.")
    private String userId;
    @NotBlank(message = "비밀번호가 비어있습니다.")
    private String password;
    @NotBlank(message = "비밀번호 확인이 비어있습니다.")
    private String passwordCheck;
    @Email
    @NotBlank(message = "이메일이 비어있습니다.")
    private String email;
    @NotBlank(message = "닉네임이 비어있습니다.")
    private String nickName;
    @Max(value=3)
    private int loginState;
    private String profileId;
    private String followId;
}
