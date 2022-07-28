package com.shop.demo.dao;

import javax.persistence.*;
import java.util.List;

@Entity
public class Recipe {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;
     @Column(columnDefinition = "TEXT")
     private String description;

     @OneToMany(mappedBy = "recipe")
     private List<RecipeIngredients> ingredients;

     private int timePrepare;

     public Recipe() {
     }

     public Recipe(String name, String description, List<RecipeIngredients> ingredients, int timePrepare) {
          this.name = name;
          this.description = description;
          this.ingredients = ingredients;
          this.timePrepare = timePrepare;
     }

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public List<RecipeIngredients> getIngredients() {
          return ingredients;
     }

     public void setIngredients(List<RecipeIngredients> ingredients) {
          this.ingredients = ingredients;
     }

     public int getTimePrepare() {
          return timePrepare;
     }

     public void setTimePrepare(int timePrepare) {
          this.timePrepare = timePrepare;
     }

}
