package com.example.cocktailsapi.model;

import java.util.ArrayList;
import java.util.List;

public class Cocktail {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String name;
    private List<Ingredient> ingredients;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Cocktail(String name, List<Ingredient> ingredients){
        this.name = name;
        this.ingredients = ingredients;
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    //***SETTER METHODS***----------------------------------------------------------------------------------------------
    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString(){
        String cocktail = "Cocktail: " + name + "\n" +
                          "Ingredients: ";
        for(Ingredient ingredient : getIngredients()){
            cocktail += ingredient + ", ";
        }

        return cocktail;
    }

    //***END***---------------------------------------------------------------------------------------------------------
}
