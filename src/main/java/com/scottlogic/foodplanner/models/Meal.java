package com.scottlogic.foodplanner.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;


@Entity
@Table(name = "meals")
@Data
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private final String name;
    private MEAL_TIME meal_time;
    private LocalDate meal_date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public Meal(String name, Recipe recipe, MEAL_TIME meal_time, LocalDate meal_date) {
        this.name = name;
        this.recipe = recipe;
        this.meal_time = meal_time;
        this.meal_date = meal_date;
    }

    public Meal() {
        name = "this is not right";
    }

}
