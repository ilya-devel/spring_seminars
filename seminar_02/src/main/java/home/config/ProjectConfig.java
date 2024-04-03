package home.config;

import home.classes.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.beans.BeanProperty;

@Configuration
public class ProjectConfig {
    @Bean
    @Scope("prototype")
    Car car (String model, String made) {
        Car obCar = new Car(model, made);
//        obCar.setModel("X3");
//        obCar.setMade("BMW");
        return obCar;
    }
}
