package com.scottlogic.foodplanner.controllers;

import com.scottlogic.foodplanner.models.Meal;
import com.scottlogic.foodplanner.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MealController {

    private final MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping(value = "meals")
    public @ResponseBody List<Meal> GetAllMeals() {
        return mealService.GetAllMeals();
    }

    @GetMapping(value = "meals/{id}")
    public @ResponseBody Optional<Meal> GetMeal(@PathVariable Integer id) {
        return mealService.GetMealById(id);
    }

    @PostMapping(value = "meals")
    public @ResponseBody Meal CreateMeal(@RequestBody Meal meal) {
        return mealService.CreateMeal(meal);
    }
}
