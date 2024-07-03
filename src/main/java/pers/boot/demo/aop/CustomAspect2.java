package pers.boot.demo.aop;

import pers.boot.demo.annotation.CustomAnnotation2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2020-11-28
 **/
@Aspect
@Component
@Order(Ordered.LOWEST_PRECEDENCE-100)
public class CustomAspect2 {
    @Around("@annotation(customAnnotation)")
    public void test(ProceedingJoinPoint joinPoint, CustomAnnotation2 customAnnotation){
        System.out.println("Around before CustomAspect2 ");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("Around after CustomAspect2");

    }
    @After("pointCut()")
    public void after(){
        System.out.println("after CustomAspect2");

    }
    @Before("pointCut()")
    public void before(){
        System.out.println("before CustomAspect2");

    }

    @Pointcut("@annotation(pers.boot.demo.annotation.CustomAnnotation2)")
    public void pointCut(){

    }
}
