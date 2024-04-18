package ru.gb.sem06_homework02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.sem06_homework02.domain.Characters;
import ru.gb.sem06_homework02.domain.Result;
import ru.gb.sem06_homework02.service.ServiceApi;

@RestController
@RequestMapping("/api/characters")
public class ControllerAPI {
    @Autowired
    private ServiceApi serviceApi;

    @GetMapping
    public ResponseEntity<Characters> getCharacters()
    {
        Characters allCharacters = serviceApi.getAllCharacters();
        return new ResponseEntity<>(allCharacters, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result> getCharactersById(@PathVariable("id") Long id)
    {
        Result character = serviceApi.getCharacterById(id);
        return new ResponseEntity<>(character, HttpStatus.OK);
    }
}
