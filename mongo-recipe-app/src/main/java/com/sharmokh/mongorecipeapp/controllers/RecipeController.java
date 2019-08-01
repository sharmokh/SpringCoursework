package com.sharmokh.mongorecipeapp.controllers;

import com.sharmokh.mongorecipeapp.commands.RecipeCommand;
import com.sharmokh.mongorecipeapp.exceptions.NotFoundException;
import com.sharmokh.mongorecipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Slf4j
@Controller
public class RecipeController {

    private static final String RECIPE_FORM = "recipe/recipe_form";
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    // Get Method - receives a recipe id and renders the recipe in HTML
    @GetMapping({"/recipe/{id}/show"})
    public String getRecipePage(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findById(id));
        return "recipe/show";
    }

    // Get Method - template to update recipe
    @GetMapping("recipe/{id}/update")
    public String updateRecipePage(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findCommandById(id));
        log.debug("Updating Recipe ID: " + id);

        return RECIPE_FORM;
    }

    // Get Method - template for new recipe
    @GetMapping({"/recipe/new"})
    public String newRecipePage(Model model) {

        model.addAttribute("recipe", new RecipeCommand());
        log.debug("Creating new recipe.");

        return RECIPE_FORM;
    }

    // Post Method - save or update a recipe
    @PostMapping("recipe")
    public String saveOrUpdate(@Valid @ModelAttribute("recipe") RecipeCommand command, BindingResult result) {

        if (result.hasErrors()) {
            return RECIPE_FORM;
        }

        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);
        log.debug("New or Updated Recipe ID: " + savedCommand.getId());

        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }

    @GetMapping("recipe/{id}/delete")
    public String deleteRecipe(@PathVariable String id, Model model) {

        log.debug("Delete Recipe ID: " + id);
        recipeService.deleteById(id);

        return "redirect:/";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception) {
        log.error(exception.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
}
