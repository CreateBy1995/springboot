package com.example.demo.aop;

import com.example.demo.annotation.CustomAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2020-11-28
 **/
@Aspect
@Component
public class CustomAspect {
    @Around("@annotation(customAnnotation)")
    public void test(ProceedingJoinPoint joinPoint,CustomAnnotation customAnnotation){
        System.out.println("Around before CustomAspect");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("Around after CustomAspect");

    }
//    @AfterReturning("pointCut()")
//    public void afterReturning(){
//        System.out.println("AfterReturning CustomAspect");
//
//    }
    @Before("pointCut()")
    public void before(){
        System.out.println("Before CustomAspect");

    }
    @After("pointCut()")
    public void after(){
        System.out.println("After CustomAspect");

    }
//    @AfterThrowing("pointCut()")
//    public void afterThrowing(){
//        System.out.println("afterThrowing CustomAspect");
//
//    }

    @Pointcut("@annotation(com.example.demo.annotation.CustomAnnotation)")
    public void pointCut(){

    }
}
