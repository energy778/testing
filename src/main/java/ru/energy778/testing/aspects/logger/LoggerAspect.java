package ru.energy778.testing.aspects.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    @Before("within(ru.energy778.testing.service.*)")
    public void logBefore(JoinPoint joinPoint){

        System.out.println(joinPoint.getSignature().toShortString() + " is called...");

    }

}
