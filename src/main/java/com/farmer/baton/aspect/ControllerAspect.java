package com.farmer.baton.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ControllerAspect {
    private static final Log log = LogFactory.getLog(ControllerAspect.class);

    @Before("execution(* com.farmer.baton.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) {
        log.debug("aspect before..." + joinPoint.getSignature().getName());
    }


}

