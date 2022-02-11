package com.example.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AopTest {
    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("aop test ...");

        return proceedingJoinPoint.proceed();
    }
}