package com.shop.demo.dao;

import javax.persistence.*;

@Entity
public class RecipeIngredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    private Integer recipeAmount;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public RecipeIngredients() {
    }

    public RecipeIngredients(Long id, Ingredient ingredient, Integer recipeAmount, Recipe recipe) {
        this.id = id;
        this.ingredient = ingredient;
        this.recipeAmount = recipeAmount;
        this.recipe = recipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Integer getRecipeAmount() {
        return recipeAmount;
    }

    public void setRecipeAmount(Integer recipeAmount) {
        this.recipeAmount = recipeAmount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
