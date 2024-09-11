package com.example.cocktailsapi.model;

public class Ingredient {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String ingredientName;
    private boolean isAllergen;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Ingredient(String ingredientName, boolean isAllergen){
    this.ingredientName = ingredientName;
    this.isAllergen = isAllergen;
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public String getIngredientName() {
        return ingredientName;
    }

    public boolean isAllergen(){
        return isAllergen;
    }

    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString(){
        return "Ingredient: " + ingredientName;
    }

    //***END***---------------------------------------------------------------------------------------------------------
}
