package com.scottlogic.foodplanner.controllers;

import com.scottlogic.foodplanner.models.Recipe;
import com.scottlogic.foodplanner.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(value = "recipes")
    public List<Recipe> GetAllRecipes() {
        return recipeService.GetAllRecipes();
    }

    @GetMapping(value = "recipes/{id}")
    public Optional<Recipe> GetRecipe(@PathVariable Integer id) {
        return recipeService.GetRecipe(id);
    }

    @PostMapping(value = "recipes")
    public Recipe CreateRecipe(@RequestBody Recipe recipe){
        try {
            return recipeService.CreateRecipe(recipe);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Recipe of name: '" + recipe.getName() + "' already exists.");
        }
    }
}
