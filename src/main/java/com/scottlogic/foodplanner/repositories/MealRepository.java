package com.scottlogic.foodplanner.repositories;

import com.scottlogic.foodplanner.models.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Integer> {
}