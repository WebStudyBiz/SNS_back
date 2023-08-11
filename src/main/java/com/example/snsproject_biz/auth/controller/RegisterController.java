package com.example.snsproject_biz.auth.controller;


import com.example.snsproject_biz.auth.domain.dto.RegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class RegisterController {

    @Autowired
    private RegisterController registerController;
    // 모든 회원정보 조회
    @GetMapping("/register")
    public ResponseEntity getAllUserData(){
        return new ResponseEntity("", HttpStatus.OK);
    }

    // 특정 유저 조회
    @GetMapping("/register/{id}")
    public ResponseEntity findUserById(@PathVariable String Id){
        return new ResponseEntity("", HttpStatus.OK);
    }

    // 회원가입
    @PostMapping("/register")
    public ResponseEntity registerUser(RegisterDTO user){
        return new ResponseEntity("", HttpStatus.OK);
    }

    // 회원탈퇴
    @DeleteMapping("/register/{id}")
    public ResponseEntity deleteUser(@PathVariable String id){
        return new ResponseEntity("", HttpStatus.OK);
    }

    // 회원정보 수정
    @PutMapping("/register")
    public ResponseEntity updateUser(RegisterDTO user){
        return new ResponseEntity("", HttpStatus.OK);
    }
}
