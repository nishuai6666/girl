package com.nsproject.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 制作切面（AOP）
 * */
@Aspect
@Component
public class HttpAspect {

   private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);



    @Pointcut("execution(public * com.nsproject.girl.controller.GirlController.*(..))")
    public  void  log(){


    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
       // System.out.println("切面植入之前");
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("method={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}", joinPoint.getArgs() );
        // logger.info("切面植入之前");
    }

    @After("log()")
    public  void doAfter(){
       // System.out.println("切面植入之后！！！！");
        logger.info("切面植入之后！！！！");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());

    }

}
