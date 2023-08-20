package com.example.snsproject_biz.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LogAspect {
    @Pointcut("within(com.example.snsproject_biz.*.controller.*)")
    public void Controller() {}

    @Before("Controller()")
    public void BeforeRequest(JoinPoint joinPoint){
        log.info("===== Start Request : {}", joinPoint.getSignature().toShortString());
        Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .map(str -> "\t" + str)
                .forEach(log::info);
    }

    @AfterReturning(pointcut = "Controller()", returning = "returnValue")
    public void afterReturningLogging(JoinPoint joinPoint, Object returnValue){
        log.info("===== End Request : {}", joinPoint.getSignature().toShortString());

        if(returnValue == null) return;

        log.info("\t{}", returnValue.toString());
    }

    @AfterThrowing(pointcut = "Controller()",throwing = "e")
    public void afterThrowingLogging(JoinPoint joinPoint, Exception e){
        log.error("===== Occured error in request : {}", joinPoint.getSignature().toShortString());
        log.error("\t{}", e.getMessage());
    }
}
