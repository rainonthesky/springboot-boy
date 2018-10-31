package com.yaping.boy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Aspect
@Component
public class HttpAspect {
    private final static org.slf4j.Logger logger =  LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.yaping.boy.contoller.BoyController.*(..))")
    public void log() {

    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
       HttpServletRequest request= attributes.getRequest();
       logger.info("url={}",request.getRequestURI());
       logger.info("method={}",request.getMethod());
       logger.info("ip={}",request.getRemoteAddr());
       logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
       logger.info("args={}",joinPoint.getArgs());
        logger.info("1111111");
    }
    @After("log()")
    public void doAfter() {
        logger.info("222222");
    }
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object);
    }
}
