package ru.energy778.testing.aspects.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggerAspect {

    @Before("within(ru.energy778.testing.service.*)")
    public void logBefore(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().toShortString() + " is called...");
    }

    @AfterReturning(
            pointcut = "@target(ru.energy778.testing.aspects.logger.LoggerAnn)",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result){
        System.out.println(joinPoint.getSignature().toShortString() + " is called...");
        if (result instanceof List)
            System.out.println(String.format("... загружено вопросов: %1$s", ((List) result).size()));
    }

}
