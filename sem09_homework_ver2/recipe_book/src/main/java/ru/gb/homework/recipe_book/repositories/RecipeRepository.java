package ru.gb.homework.recipe_book.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.gb.homework.recipe_book.models.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
