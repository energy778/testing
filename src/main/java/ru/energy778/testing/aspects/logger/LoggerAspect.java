package ru.energy778.testing.aspects.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.List;

@Aspect
@Component
public class LoggerAspect {

    @Pointcut("execution(public * ru.energy778.testing.dao.TestDataDAOCSV.getQuestions(..))")
    public void callGetQuestions() {
    }

    @Pointcut("execution(public * ru.energy778.testing.service.TestingServiceImpl.passExamination(..))")
    public void callPassExamination() {
    }

    @Before("within(ru.energy778.testing.service.*)")
    public void logBefore(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().toShortString() + " is called...");
    }

    @AfterReturning(
            pointcut = "callGetQuestions()",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result){
        System.out.println(joinPoint.getSignature().toShortString() + " is called...");
        if (result instanceof List)
            System.out.println(String.format("... загружено вопросов: %1$s", ((List) result).size()));
    }

//    @AfterReturning(
//            pointcut = "@target(ru.energy778.testing.aspects.logger.LoggerAnn)",
//            returning = "result")
//    public void logAfterReturning(JoinPoint joinPoint, Object result){
//        System.out.println(joinPoint.getSignature().toShortString() + " is called...");
//        if (result instanceof List)
//            System.out.println(String.format("... загружено вопросов: %1$s", ((List) result).size()));
//    }

    @Around("callPassExamination()")
    public Object aroundCallAt(ProceedingJoinPoint call) throws Throwable {

        StopWatch clock = new StopWatch(call.toString());
        try {
            clock.start(call.toShortString());
            return call.proceed();
        } finally {
            clock.stop();
            System.out.println(clock.prettyPrint());
        }

    }

}

//https://habr.com/ru/post/428548/ - неплохой обзор
