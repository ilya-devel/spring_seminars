package ru.gb.homework.sem10_homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.gb.homework.sem10_homework.models.Person;

/**
 * Manage data in database
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
