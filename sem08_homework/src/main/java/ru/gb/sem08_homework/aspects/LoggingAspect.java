package ru.gb.sem08_homework.aspects;

import java.time.LocalDateTime;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

    @AfterReturning(value = "@annotation(ru.gb.sem08_homework.annotations.TrackUserAction)", returning = "returnedValue")
    public void logRequest(Object returnedValue) {
        System.out.println(
                "\nUser request => " + LocalDateTime.now()
                        + "\t" + returnedValue);
    }

}
