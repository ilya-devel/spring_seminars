package ru.gb.homework.recipe_book.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ru.gb.homework.recipe_book.models.Recipe;
import ru.gb.homework.recipe_book.repositories.RecipeRepository;

@Service
@AllArgsConstructor
public class RecipeService {

    private RecipeRepository recipeRepository;

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).get();
    }

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(Recipe recipe, Long id) {
        Recipe updRecipe = recipeRepository.findById(id).get();
        updRecipe.setTitle(recipe.getTitle());
        updRecipe.setDescription(recipe.getDescription());
        updRecipe.setIngredients(recipe.getIngredients());
        updRecipe.setSteps(recipe.getSteps());
        recipeRepository.save(updRecipe);
        return updRecipe;
    }

    public Recipe deleteRecipeById (Long id) {
        Recipe recipe = recipeRepository.findById(id).get();
        recipeRepository.deleteById(id);
        return recipe;
    }
}
