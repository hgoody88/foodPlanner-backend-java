package com.scottlogic.foodplanner.repositories;

import com.scottlogic.foodplanner.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}
