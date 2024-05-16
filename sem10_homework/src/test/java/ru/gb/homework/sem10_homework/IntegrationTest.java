package ru.gb.homework.sem10_homework;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.gb.homework.sem10_homework.models.Person;
import ru.gb.homework.sem10_homework.repository.PersonRepository;
import ru.gb.homework.sem10_homework.service.PersonService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class IntegrationTest {
    @MockBean
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    @Test
    public void createNewPersonTest() {

        // Condition block

        Person newPerson = new Person();
        newPerson.setId(1L);
        newPerson.setLogin("Test login");
        newPerson.setMail("test_mail@mail.ru");
        newPerson.setPassword("test_password");

        when(personRepository.save(newPerson)).thenReturn(newPerson);

        // Action block

        personService.addPerson(newPerson);

        // Check block

        verify(personRepository).save(newPerson);

    }

    @Test
    public void getPersonByIdTest() {
        // Condition block

        Person person1 = new Person(1L, "First", "first@mail.ru", "password");
        Person person2 = new Person(1L, "Second", "second@mail.ru", "password");
        Person person3 = new Person(1L, "Third", "third@mail.ru", "password");
        Person person4 = new Person(1L, "Fourth", "fourth@mail.ru", "password");

        when(personRepository.findById(2L)).thenReturn(Optional.of(person2));
        when(personRepository.findById(5L)).thenReturn(Optional.empty());

        // Action block

        personService.getPersonById(2L);
        assertThrows(Exception.class, () -> {personService.getPersonById(5L);});

        // Check block

        verify(personRepository).findById(2L);
        verify(personRepository).findById(5L);
    }
}
