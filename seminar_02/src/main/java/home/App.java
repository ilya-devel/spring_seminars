package home;

import home.classes.Car;
import home.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Car car1 = context.getBean(Car.class, "BMW", "X1");
        Car car2 = context.getBean(Car.class, "BMW", "X1");
        Car car3 = context.getBean(Car.class, "BMW", "X1");
        Car car4 = context.getBean(Car.class, "BMW", "X1");
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
        System.out.println(car4);
    }
}