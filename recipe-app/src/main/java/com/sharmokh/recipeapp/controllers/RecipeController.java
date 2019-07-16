package com.sharmokh.recipeapp.controllers;

import com.sharmokh.recipeapp.commands.RecipeCommand;
import com.sharmokh.recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    // Get Method - receives a recipe id and renders the recipe in HTML
    @GetMapping
    @RequestMapping({"/recipe/{id}/show"})
    public String getRecipePage(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return "recipe/show";
    }

    // Get Method - template to update recipe
    @GetMapping
    @RequestMapping("recipe/{id}/update")
    public String updateRecipePage(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        log.debug("Updating Recipe ID: " + id);

        return "recipe/recipe_form";
    }

    // Get Method - template for new recipe
    @GetMapping
    @RequestMapping({"/recipe/new"})
    public String newRecipePage(Model model) {

        model.addAttribute("recipe", new RecipeCommand());
        log.debug("Creating new recipe.");

        return "recipe/recipe_form";
    }

    // Post Method - save or update a recipe
    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command) {

        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);
        log.debug("New or Updated Recipe ID: " + savedCommand.getId());

        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }

    @GetMapping
    @RequestMapping("recipe/{id}/delete")
    public String deleteRecipe(@PathVariable String id, Model model) {

        log.debug("Delete Recipe ID: " + id);
        recipeService.deleteById(Long.valueOf(id));

        return "redirect:/";
    }

}
