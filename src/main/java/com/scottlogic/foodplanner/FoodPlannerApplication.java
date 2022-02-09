package com.scottlogic.foodplanner;

import com.scottlogic.foodplanner.models.MEAL_TIME;
import com.scottlogic.foodplanner.models.Meal;
import com.scottlogic.foodplanner.models.Recipe;
import com.scottlogic.foodplanner.repositories.MealRepository;
import com.scottlogic.foodplanner.repositories.RecipeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class FoodPlannerApplication {

	@Autowired
	private MealRepository mealRepository;

	@Autowired
	private RecipeRepository recipeRepository;

	public static void main(String[] args) {
		SpringApplication.run(FoodPlannerApplication.class, args);
	}

/*
	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		List allMeals = this.mealRepository.findAll();
		System.out.println(allMeals);

		Recipe recipe = new Recipe("Turkey chilli");

		var existingRecipes = recipeRepository.findAll();

		var matchingRecipes = existingRecipes.stream().filter(
				recipe1 -> recipe.getName().equals(recipe1.getName())
		).collect(Collectors.toList());

		Recipe savedRecipe;
		if(matchingRecipes.size() < 1) {
			savedRecipe = recipeRepository.save(recipe);
		}
		else {
			savedRecipe = matchingRecipes.get(0);
		}

		Meal meal = new Meal(
				"Super healthy chilli",
				savedRecipe,
				MEAL_TIME.LUNCH,
				LocalDate.now());

		try {
			mealRepository.save(meal);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
}
