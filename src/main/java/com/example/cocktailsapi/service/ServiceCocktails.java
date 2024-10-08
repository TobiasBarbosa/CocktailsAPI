package com.example.cocktailsapi.service;

import com.example.cocktailsapi.model.Cocktail;
import com.example.cocktailsapi.repository.RepositoryCocktails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceCocktails {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private final RepositoryCocktails repositoryCocktails;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public ServiceCocktails (RepositoryCocktails repositoryCocktails){
        this.repositoryCocktails = repositoryCocktails;
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
   public ArrayList<Cocktail> getCocktails(){
        return repositoryCocktails.getCocktails();
   }

    public Cocktail findCocktailByName(String name){
       return repositoryCocktails.findCocktailByName(name);
    }

    public List<Cocktail> searchByIngredient(String ingredient){
        return repositoryCocktails.searchByIngredient(ingredient);
    }

    //***NO USE METHODS***----------------------------------------------------------------------------------------------

    public Cocktail addCocktail(Cocktail cocktail){
        return repositoryCocktails.addCocktail(cocktail);
    }

    public Cocktail updateCocktail(String searchName, Cocktail cocktail){
        return repositoryCocktails.updateCocktail(searchName,cocktail);
    }

    public void removeCocktail(String searchName){
        repositoryCocktails.removeCocktail(searchName);
    }

    public ArrayList<Cocktail> getCocktailsWithAllergens(){
        return repositoryCocktails.getCocktailsWithAllergens();
    }

    public ArrayList<Cocktail> getCocktailsWithoutAllergens(){
        return repositoryCocktails.getCocktailsWithoutAllergens();
    }

    //***END***---------------------------------------------------------------------------------------------------------
}
