package com.example.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class AopTest {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void getMapping() {}

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postMapping() {}

    /* logging request */
    @Before("getMapping() || postMapping()")
    public void before(JoinPoint joinPoint) throws Throwable {

        log.info("aop test ...");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        StringBuilder sb = new StringBuilder();
        String method = request.getMethod();
        String path = request.getRequestURI();

        String ip = request.getHeader("X-FORWARDED-FOR");

        if(ip == null) {
            ip = request.getRemoteAddr();
        }

        sb.append(ip)
                .append(" ")
                .append(method)
                .append(" ")
                .append(path);

        log.info(sb.toString());
    }
}