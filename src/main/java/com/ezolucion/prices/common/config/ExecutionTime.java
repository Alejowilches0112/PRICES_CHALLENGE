package com.ezolucion.prices.common.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExecutionTime{

    @Around("execution(* com.ezolucion.prices.adapter.in.*.*(..))")
    public Object executionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        var timeStart = System.currentTimeMillis();
        var result = joinPoint.proceed();
        var timeFinish = System.currentTimeMillis();
        var totalTime = timeFinish - timeStart;
        var message = new StringBuilder().append("The total execution time of the method: ").append(joinPoint.getSignature().getName())
                        .append(" of the class: ").append(joinPoint.getTarget().getClass()).append(" was ").append(totalTime);
        log.info(message.toString());
        return result;
    }
}