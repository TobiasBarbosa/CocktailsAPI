package com.example.cocktailsapi.repository;

import com.example.cocktailsapi.model.Cocktail;
import com.example.cocktailsapi.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class RepositoryCocktails {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private ArrayList<Cocktail> cocktails = new ArrayList<>();
    private ArrayList<Cocktail> cocktailsWithAllergens = new ArrayList<>();
    private ArrayList<Cocktail> cocktailsWithoutAllergens = new ArrayList<>();

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public RepositoryCocktails(){
        populateCocktailsRep();
    }

    //jeg kan ikke finde mit gamle tema :(( hvad hed den? tror du jeg kan huske det??
    //***POPULATE***----------------------------------------------------------------------------------------------------
    public void populateCocktailsRep(){
        //Ingredients
        Ingredient gin = new Ingredient("Gin", false);
        Ingredient tonic = new Ingredient("Tonic", false);
        Ingredient bourbonWhiskey = new Ingredient("Bourbon Whiskey", false);
        Ingredient sugar = new Ingredient("Sugar", false);
        Ingredient angostura = new Ingredient("Angostura", false);
        Ingredient orangePeel = new Ingredient("Orange Peel", false);
        Ingredient rom = new Ingredient("Rom", false);
        Ingredient gingerBeer = new Ingredient("Ginger Beer", false);
        Ingredient lemonJuice = new Ingredient("Lemon Juice", false);
        Ingredient lemonSlices = new Ingredient("Lemon Slices", false);

        //Cocktails
        cocktails.add(new Cocktail("Gin and Tonic", Arrays.asList(gin,tonic, lemonSlices)));
        cocktails.add(new Cocktail("Old Fashioned", Arrays.asList(bourbonWhiskey,sugar,angostura,orangePeel)));
        cocktails.add(new Cocktail("Dark n Stormy", Arrays.asList(rom,gingerBeer,lemonJuice, lemonSlices)));
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public ArrayList<Cocktail> getCocktails(){
        return cocktails;
    }

    public Cocktail findCocktailByName(String name){
        for(Cocktail cocktail : cocktails){
            if(cocktail.getName().equalsIgnoreCase(name)){
                return cocktail;
            }

        }
        return null;
    }

    public Cocktail addCocktail(Cocktail cocktail){
        cocktails.add(cocktail);
        return cocktail;
    }

    public Cocktail updateAttraction(String searchName, Cocktail cocktail){
        for(Cocktail cocktail1 : cocktails){
            if(cocktail1.getName().equalsIgnoreCase(searchName)){
                cocktail1.setName(cocktail.getName());
                cocktail1.setIngredients(cocktail.getIngredients());
                return cocktail1;
            }
        }
        return null;
    }

    public void removeAttraction(String searchName){
        for(Cocktail cocktail : cocktails){
            if(cocktail.getName().equalsIgnoreCase(searchName)){
                cocktails.remove(cocktail);
            }
        }
    }

    public List<Cocktail> searchByIngredient(String ingredient){
        List<Cocktail> cocktailsWithIngredient = new ArrayList<>();
        for (Cocktail cocktail : cocktails) {
            for (Ingredient ingredient1 : cocktail.getIngredients()){
                if(ingredient1.getIngredientName().equalsIgnoreCase(ingredient))
                    cocktailsWithIngredient.add(cocktail);
            }
        }
        return cocktailsWithIngredient;
    }

    //------------------------------------------------------------------------------------------------------------------
    public ArrayList<Cocktail> getCocktailsWithAllergens() {
         for (Cocktail cocktail : cocktails) {
            for (Ingredient ingredient : cocktail.getIngredients())
                if (ingredient.isAllergen()){
                    cocktailsWithAllergens.add(cocktail);
                    return cocktailsWithAllergens;
                }
        }
        return null;
    }

    public ArrayList<Cocktail> getCocktailsWithoutAllergens() {
        for (Cocktail cocktail : cocktails) {
            for (Ingredient ingredient : cocktail.getIngredients())
                if (!ingredient.isAllergen()){
                    cocktailsWithoutAllergens.add(cocktail);
                    return cocktailsWithoutAllergens;
                }
        }
        return null;
    }

    //***END***---------------------------------------------------------------------------------------------------------
}
