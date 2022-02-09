package com.scottlogic.foodplanner.services;

import com.scottlogic.foodplanner.models.Meal;
import com.scottlogic.foodplanner.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealService {

    private final MealRepository mealRepository;

    @Autowired
    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public List<Meal> GetAllMeals() {
        return mealRepository.findAll();
    }

    public Optional<Meal> GetMealById(Integer mealId) {
        return mealRepository.findById(mealId);
    }

    public Meal CreateMeal(Meal meal) {
        return mealRepository.save(meal);
    }
}
