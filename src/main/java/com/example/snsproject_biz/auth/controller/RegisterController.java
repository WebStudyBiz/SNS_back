package com.example.snsproject_biz.auth.controller;


import com.example.snsproject_biz.auth.domain.dto.RegisterDTO;
import com.example.snsproject_biz.auth.domain.entity.UserEntity;
import com.example.snsproject_biz.auth.service.RegisterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class RegisterController {

    @Autowired
    private RegisterServiceImpl registerService;

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

    // 모든 회원정보 조회
    @GetMapping("/register")
    public ResponseEntity getUserByAll(){
        return new ResponseEntity("", HttpStatus.OK);
    }

    // 특정 유저 조회
    @GetMapping("/register/{id}")
    public ResponseEntity getUserById(@PathVariable String id){
        ArrayList<UserEntity> searchResult = registerService.findByOneUser(id);
        if(searchResult.size() == 0){
            return ResponseEntity.badRequest().body(searchResult);
        }else{
            return ResponseEntity.ok().body(searchResult);
        }
    }

    // 회원가입
    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody RegisterDTO user){
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
        long deleteResult = registerService.deleteUser(id);
        if(deleteResult == 1){
            return ResponseEntity.ok().body(deleteResult);
        }else {
            return ResponseEntity.badRequest().body(deleteResult);
        }
    }

    // 회원정보 수정
    @PutMapping("/register")
    public ResponseEntity updateUser(RegisterDTO user){
        boolean updateResult = registerService.updateUser(user);
        if(updateResult == true){
            return ResponseEntity.ok().body(updateResult);
        }else{
            return ResponseEntity.badRequest().body(updateResult);
        }
    }
}
