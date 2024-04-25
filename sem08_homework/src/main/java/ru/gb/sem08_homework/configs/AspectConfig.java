package ru.gb.sem08_homework.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import ru.gb.sem08_homework.aspects.LoggingAspect;

@Configuration
@ComponentScan(basePackages = "ru.gb")
@EnableAspectJAutoProxy
public class AspectConfig {

    @Bean
    public LoggingAspect loggingAspect () {
        return new LoggingAspect();
    }

}
