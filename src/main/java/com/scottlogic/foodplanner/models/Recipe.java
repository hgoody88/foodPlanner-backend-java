package com.scottlogic.foodplanner.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "recipes")
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public Recipe(String name) {
        this.name = name;
    }

    public Recipe() {

    }
}
