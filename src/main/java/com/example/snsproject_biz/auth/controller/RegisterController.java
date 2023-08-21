package com.example.snsproject_biz.auth.controller;


import com.example.snsproject_biz.auth.domain.dto.RegisterDTO;
import com.example.snsproject_biz.auth.domain.entity.UserEntity;
import com.example.snsproject_biz.auth.service.RegisterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class RegisterController {

    @Autowired
    private RegisterServiceImpl registerService;
    // 모든 회원정보 조회
    @GetMapping("/register")
    public ResponseEntity getUserByAll(){
        return new ResponseEntity("", HttpStatus.OK);
    }

    // 특정 유저 조회
    @GetMapping("/register/{id}")
    public ResponseEntity getUserById(@PathVariable String Id){
        return new ResponseEntity("", HttpStatus.OK);
    }

    @PostMapping("/register/check-duplicate-userid")
    public ResponseEntity DuplicateCheckByUserId(@RequestBody Map<String, String> userData){
        boolean duplck = registerService.checkUserIdDuplicate(userData.get("userId"));
        if(duplck == true){
            return ResponseEntity.ok().body(duplck);
        }else{
            return ResponseEntity.badRequest().body(duplck);
        }
    }

    @PostMapping("/register/check-duplicate-nickname")
    public ResponseEntity DuplicateCheckByUserNickname(@RequestBody Map<String, String> userData){
        boolean duplck = registerService.checkNicknameDuplicate(userData.get("userNickname"));
        if(duplck == true){
            return ResponseEntity.ok().body(duplck);
        }else{
            return ResponseEntity.badRequest().body(duplck);
        }
    }

    // 회원가입
    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody RegisterDTO user){
        System.out.println(user);
        boolean registerResult = registerService.registerUser(user);
        if(registerResult == true){
            return ResponseEntity.ok().body(registerResult);
        }else {
            return ResponseEntity.badRequest().body(registerResult);
        }
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
