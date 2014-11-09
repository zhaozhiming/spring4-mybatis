package com.farmer.baton.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ControllerAspect {
    private static final Log log = LogFactory.getLog(ControllerAspect.class);

    @Around("execution(public * com.farmer.baton.controller.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        log.debug(String.format("%s start", methodName));
        joinPoint.proceed();
        log.debug(String.format("%s finish", methodName));
        return null;

    }
}

