package ru.gb.sem06_homework02.service;


import ru.gb.sem06_homework02.domain.Characters;
import ru.gb.sem06_homework02.domain.Result;

public interface ServiceApi {
    public Characters getAllCharacters();
    public Result getCharacterById(Long id);

}
