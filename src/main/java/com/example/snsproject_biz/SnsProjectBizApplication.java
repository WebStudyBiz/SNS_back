package com.example.snsproject_biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SnsProjectBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnsProjectBizApplication.class, args);
    }

}
