package com.shop.demo.Controller;


import com.shop.demo.Service.IngredientService;
import com.shop.demo.dao.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class IngredientApi {

    private IngredientService ingredientService;

    @Autowired
    public IngredientApi(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/ingredients")
    public List<Ingredient> geIngredients(){
        return ingredientService.getIngredients();
    }
    @GetMapping("/ingredients/{id}")
    public Ingredient getIngredient (@PathVariable Long id){
        return ingredientService.getIngredient(id).orElseThrow(() -> new RuntimeException("Nie znaleziono składnika o id"+ id));
    }
    @PostMapping("/ingredients")
    public Ingredient addIngredient(@RequestBody Ingredient ingredient){
        return ingredientService.addIngredient(ingredient);
    }
    @PutMapping("/ingredients/{id}")
    public Ingredient updateIngredient (@RequestBody Ingredient ingredient){
        return ingredientService.updateIngredient(ingredient);
    }
    @DeleteMapping("ingredients/{id}")
    public void deleteIngredient (@PathVariable Long id){
        ingredientService.deleteIngredient(id);
    }

}
