package com.scottlogic.foodplanner.services;

import com.scottlogic.foodplanner.models.Recipe;
import com.scottlogic.foodplanner.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    private boolean DoesRecipeOfSameNameExists(String name) {
        return recipeRepository.exists(
                Example.of(new Recipe(name))
        );
    }

    public List<Recipe> GetAllRecipes() {
        return recipeRepository.findAll();
    }

    public Optional<Recipe> GetRecipe(Integer id) {
        return recipeRepository.findById(id);
    }


    public Recipe CreateRecipe(Recipe recipe) throws DataIntegrityViolationException {

        if (DoesRecipeOfSameNameExists(recipe.getName())) {
            throw new DataIntegrityViolationException("Recipe already exists");
        }

        return recipeRepository.save(recipe);
    }
}
