package com.example.snsproject_biz.auth.controller;

import com.example.snsproject_biz.auth.domain.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class LoginController {

    @GetMapping("/login/{id}")
    public ResponseEntity findNotExpireJwtToken(@PathVariable String id){
        return new ResponseEntity("", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(LoginDTO loginDto){
        return new ResponseEntity("", HttpStatus.OK);
    }

    @PutMapping("/login/{id}")
    public ResponseEntity refreshJwtToken(@PathVariable String id){
        return new ResponseEntity("", HttpStatus.OK);
    }
}
