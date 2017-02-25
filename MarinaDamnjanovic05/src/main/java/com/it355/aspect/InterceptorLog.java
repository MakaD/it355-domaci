package com.it355.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.springframework.aop.MethodBeforeAdvice;

/**
 *
 * @author Marina
 */
public class InterceptorLog implements MethodBeforeAdvice{

    @Override
    public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
        System.out.println("logBefore() metoda je pozvana!");
        System.out.println("presretanje : " + arg0.getName());
        System.out.println("******");    
    }
    
    @After("execution(*com.it355.dao.impl.AdDaoImpl.addAd(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("logAfter() metoda je pozvana!");
        System.out.println("presretanje : " +
        joinPoint.getSignature().getName());
        System.out.println("******");
    }

    @AfterThrowing(
    pointcut = "execution(*com.it355.dao.impl.AdDaoImpl.addAdThrowException())", throwing= "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("logAfterThrowing() metoda je pozvana!");
        System.out.println("presretanje : " + joinPoint.getSignature().getName());
        System.out.println("Exception : " + error);
        System.out.println("******");
    }

    @Around("execution(* execution(*com.it355.dao.impl.AdDaoImpl.addAdAround(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("logAround() metoda je pozvana!");
        System.out.println("presretanje metode : " + joinPoint.getSignature().getName());
        System.out.println("presretanje : " +
        Arrays.toString(joinPoint.getArgs()));
        System.out.println("Around before metoda je pozvana!");
        joinPoint.proceed();
        System.out.println("Around metoda je pozvana!");
        System.out.println("******");
    }
    
}
