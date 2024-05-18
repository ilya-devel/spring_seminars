package ru.gb.homework.sem11_homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.gb.homework.sem11_homework.models.Person;
import ru.gb.homework.sem11_homework.repository.PersonRepository;

/**
 * Service command for manage of PersonRepository
 */
@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Iterable<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id).get();
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public Person deletePerson(Long id) {
        Person person = personRepository.findById(id).get();
        personRepository.deleteById(id);
        return person;
    }

    public Person updatePerson(Long id, Person updPerson) {
        Person person = personRepository.findById(id).get();
        person.setLogin(updPerson.getLogin());
        person.setMail(updPerson.getMail());
        person.setPassword(updPerson.getPassword());
        personRepository.save(person);
        return person;
    }
}
