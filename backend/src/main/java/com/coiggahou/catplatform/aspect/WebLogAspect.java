package com.coiggahou.catplatform.aspect;


import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class WebLogAspect {

    private final static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
    private final static String LINE_SEPARATOR = System.lineSeparator();

    @Pointcut("execution(public * com.coiggahou.catplatform.controller..*.*(..))")
    public void webLog() {}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attrs.getRequest();

        logger.info("=============================== Start ===============================");
        logger.info("URL             : {}", request.getRequestURL().toString());
        logger.info("HTTP Method     : {}", request.getMethod());
        logger.info("Class Method    : {}.{}", proceedingJoinPoint.getSignature().getDeclaringType(), proceedingJoinPoint.getSignature().getName());
        logger.info("IP              : {}", request.getRemoteAddr());
        logger.info("Request Args    : {}", new Gson().toJson(proceedingJoinPoint.getArgs()));

        Object result = proceedingJoinPoint.proceed();

        logger.info("Response Args   : {}", new Gson().toJson(result));
        logger.info("Time-Consuming  : {} ms", System.currentTimeMillis() - startTime);
        logger.info("===============================  End  ===============================" + LINE_SEPARATOR);

        return result;
    }

    @After("webLog()")
    public void doAfter(JoinPoint joinPoint) {
    }
}
