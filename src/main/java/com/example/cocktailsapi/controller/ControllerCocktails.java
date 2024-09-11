package com.example.cocktailsapi.controller;

import com.example.cocktailsapi.model.Cocktail;
import com.example.cocktailsapi.model.Ingredient;
import com.example.cocktailsapi.service.ServiceCocktails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("cocktails")
public class ControllerCocktails {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private final ServiceCocktails serviceCocktails;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public ControllerCocktails(ServiceCocktails serviceCocktails){
        this.serviceCocktails = serviceCocktails;
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------

    @GetMapping("/")
    public String getCocktails(Model model){
        List<Cocktail> cocktails = serviceCocktails.getCocktails();
        model.addAttribute("cocktails", cocktails);
        return "cocktail-list";
    }

    //Hvorfor skal cocktail herunder ikke i tuborg klammer {} ?
    @GetMapping("/cocktail")
    public String viewCocktails(@RequestParam("name") String name, Model model){
        Cocktail cocktail = serviceCocktails.findCocktailByName(name);
        model.addAttribute("cocktail", cocktail);
        return "cocktail-detail";
    }

    @PostMapping("/add")
    public String addCocktail(@ModelAttribute Cocktail cocktail){
        serviceCocktails.addCocktail(cocktail);
        return "redirect:/addCocktail";
    }

    @GetMapping("/search")
    public String searchByIngredient(@RequestParam("ingredient") String ingredient, Model model){
        List<Cocktail> cocktails = serviceCocktails.searchByIngredient(ingredient);
        model.addAttribute("cocktails", cocktails);
//        model.addAttribute("ingredients", ingredient);
        return "cocktail-list";
    }

    //***END***---------------------------------------------------------------------------------------------------------
}
