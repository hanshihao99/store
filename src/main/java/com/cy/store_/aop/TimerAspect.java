package com.cy.store_.aop;

import com.cy.store_.service.impl.UserServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/17/23:13
 */
@Component
@Aspect
public class TimerAspect {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Around("execution(* com.cy.store_.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        // 获取被调用方法的信息
        Signature signature = pjp.getSignature();
        String methodName = signature.getName();

        // 先记录开始时间
        long start = System.currentTimeMillis();
        Object result = pjp.proceed(); // 调用目标方法
        long end = System.currentTimeMillis();
        long executionTime = end - start;
//        logger.info("耗时 : " + (end - start));
        logger.info("方法名: " + methodName + ", 耗时: " + executionTime + "ms");
        return result;
    }
}
