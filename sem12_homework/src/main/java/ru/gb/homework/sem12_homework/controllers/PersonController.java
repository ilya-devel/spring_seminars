package ru.gb.homework.sem12_homework.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.homework.sem12_homework.models.Person;
import ru.gb.homework.sem12_homework.service.InterfaceFileGateway;
import ru.gb.homework.sem12_homework.service.PersonService;
/**
 * Controller for microservice of Person data
 */
@RestController
@AllArgsConstructor
@RequestMapping("/")
public class PersonController {

    @Autowired
    PersonService personService;

    private final InterfaceFileGateway fileGateway;


    @GetMapping
    public ResponseEntity<Iterable<Person>> getAllPersons() {
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Person person;
        try {
            person = personService.getPersonById(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        try {
            Person newPerson = personService.addPerson(person);
            fileGateway.writeToFile("Persons.txt", newPerson.toString());
            return new ResponseEntity<>(newPerson, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable Long id) {
        Person person;
        try {
            person = personService.deletePerson(id);
            return new ResponseEntity<>(person, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(
        @PathVariable Long id,
        @RequestBody Person updPerson
    ) {
        try {
            Person person = personService.updatePerson(id, updPerson);
            return new ResponseEntity<>(person, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
