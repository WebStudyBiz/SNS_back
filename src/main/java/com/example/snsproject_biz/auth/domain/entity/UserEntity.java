package com.example.snsproject_biz.auth.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "tb_user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "USER_INDEX")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userIndex; // 유저 고유번호
    @Column(name = "USER_ID")
    private String userId; // 유저 아이디
    @Column(name = "USER_PW")
    private String userPassword; // 유저 페스워드
    @Column(name = "USER_EMAIL")
    private String userEmail; // 유저 이메일
    @Column(name = "USER_NM")
    private String userNickname; // 유저 닉네임
    @Column(name = "USER_LOGINSTATE")
    private int userLoginstate; // 일반 로그인, SNS로그인 판별
    @Column(name = "USER_PHOTOID")
    private int userProfileId; // 유저 프로필 사진 인덱스
    @Column(name = "USER_FOLLOWID")
    private int userFollowId; // 유저 팔로우 인덱스
    @Column(name = "USER_CREATEdATE")
    @CreationTimestamp
    private Timestamp userCreateDate;
    @Column(name = "USER_MODIFYDATE")
    @UpdateTimestamp
    private Timestamp userModifyDate;
}
