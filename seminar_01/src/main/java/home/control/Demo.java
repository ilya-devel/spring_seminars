package home.control;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import home.classes.Person;

public class Demo {
    public static void run() {
        // Создаём объекты классов
        Person person1 = new Person("Ruby", "Rose", 14);
        Person person2 = new Person("Ruby", "Rose", 14);
        // Демонстрация созданных объектов
        System.out.println("\nДемонстрация созданных объектов");
        System.out.println(person1);
        System.out.println(person2);
        // Хэш коды объектов
        System.out.println("\nХэш коды объектов");
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
        // Сравнение двух объектов
        System.out.println("\nСравнение двух объектов");
        System.out.println(person1.equals(person2));
        // Преобразование объекта в JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(person1);
        // Вывод JSON
        System.out.println("\nВывод JSON");
        System.out.println(json);
        // Обратное преобразование из JSON в класс Person
        Person fromJson = new Gson().fromJson(json, Person.class);
        // Демонстрация результатов обратного преобразования
        System.out.println("\nДемонстрация результатов обратного преобразования");
        System.out.println(fromJson);
        System.out.println(fromJson.equals(person1));
    }
}