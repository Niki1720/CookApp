package com.shop.demo.Service;

import com.shop.demo.Repository.IngredientRepository;
import com.shop.demo.dao.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    private IngredientRepository ingredientRepository;
    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> getIngredients() {
        return ingredientRepository.findAll();
    }

    public Optional<Ingredient> getIngredient(Long id){
        return ingredientRepository.findById(id);
    }

    public Ingredient addIngredient (Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    public  Ingredient updateIngredient (Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }
    public  void deleteIngredient (Long id ){
        ingredientRepository.deleteById(id);
    }

}

