package com.sharmokh.mongorecipeapp.controllers;

import com.sharmokh.mongorecipeapp.commands.IngredientCommand;
import com.sharmokh.mongorecipeapp.commands.RecipeCommand;
import com.sharmokh.mongorecipeapp.commands.UnitOfMeasureCommand;
import com.sharmokh.mongorecipeapp.services.IngredientService;
import com.sharmokh.mongorecipeapp.services.RecipeService;
import com.sharmokh.mongorecipeapp.services.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService unitOfMeasureService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService,
                                UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping({"/recipe/{recipeId}/ingredients"})
    public String getIngredientsPage(@PathVariable String recipeId, Model model) {
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));
        log.debug("Displaying ingredients for Recipe ID: " + recipeId);
        return "recipe/ingredient/list";
    }

    @GetMapping({"/recipe/{recipeId}/ingredient/{id}/update"})
    public String updateIngredientPage(@PathVariable String recipeId, @PathVariable String id, Model model) {
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));
        model.addAttribute("uomList", unitOfMeasureService.listAllUnitOfMeasures());
        log.debug("Displaying Ingredient ID: " + id);
        return "recipe/ingredient/ingredient_form";
    }

    @GetMapping("recipe/{recipeId}/ingredient/{id}/delete")
    public String deleteRecipe(@PathVariable String recipeId, @PathVariable String id, Model model) {
        ingredientService.deleteByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id));
        return "redirect:/recipe/" + recipeId + "/ingredients";
    }

    @GetMapping({"/recipe/{recipeId}/ingredient/new"})
    public String newIngredientPage(@PathVariable String recipeId, Model model) {
        RecipeCommand recipeCommand = recipeService.findCommandById(Long.valueOf(recipeId));
        // todo raise exception if null

        model.addAttribute("ingredient", IngredientCommand.builder().recipeId(Long.valueOf(recipeId)).uom(new UnitOfMeasureCommand()).build());
        model.addAttribute("uomList", unitOfMeasureService.listAllUnitOfMeasures());
        return "recipe/ingredient/ingredient_form";
    }

    @PostMapping({"/recipe/{recipeId}/ingredient"})
    public String saveOrUpdate(@ModelAttribute IngredientCommand command) {
        IngredientCommand savedIngredient = ingredientService.saveIngredientCommand(command);
        log.debug("Ingredient " + savedIngredient.getId() + " has been added or updated.");
        return "redirect:/recipe/" + savedIngredient.getRecipeId() + "/ingredients";
    }

}
