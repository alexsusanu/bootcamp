package com.assignment9.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class FileController {
    @Autowired
    private FileService fileService;

    @GetMapping("/gluten-free")
    public String glutenFree() throws IOException {
        List<Recipe> recipeList = fileService.readFile();
        return fileService.xFree(recipeList, Recipe.GLUTEN_FREE);
    }

    @GetMapping("/vegan")
    public String vegan() throws IOException {
        List<Recipe> recipeList = fileService.readFile();
        return fileService.xFree(recipeList, Recipe.VEGAN);
    }

    @GetMapping("/vegan-and-gluten-free")
    public String veganGlutenFree() throws IOException {
        List<Recipe> recipeList = fileService.readFile();
        return fileService.xFree(recipeList, Recipe.VEGAN_GLUTEN_FREE);
    }

    @GetMapping("/vegetarian")
    public String vegetarian() throws IOException {
        List<Recipe> recipeList = fileService.readFile();
        return fileService.xFree(recipeList, Recipe.VEGETARIAN);
    }

    @GetMapping("/all-recipes")
    public String allRecipes() throws IOException {
        List<Recipe> recipeList = fileService.readFile();
        return fileService.xFree(recipeList);
    }
}
