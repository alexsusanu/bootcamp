package com.assignment9.demo;

import com.assignment9.demo.Recipe;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FileService {

      List<Recipe> recipeList = new ArrayList<>();
      public List<Recipe> readFile() throws IOException {
            Reader reader = new FileReader("recipes.txt");
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader()
                                                            .withDelimiter(',')
                                                            .withEscape('\\')
                                                            .withIgnoreSurroundingSpaces()
                                                            .parse(reader);

            for (CSVRecord record : records){
                  Integer cookingMinutes = Integer.parseInt(record.get("Cooking Minutes"));
                  Boolean dairyFree = Boolean.parseBoolean(record.get("Dairy Free"));
                  Boolean glutenFree = Boolean.parseBoolean(record.get("Gluten Free"));
                  String instructions = record.get("Instructions");
                  Double preparationMinutes = Double.parseDouble(record.get("Preparation Minutes"));
                  Double pricePerServing = Double.parseDouble(record.get("Price Per Serving"));
                  Integer readyInMinutes = Integer.parseInt(record.get("Ready In Minutes"));
                  Integer servings = Integer.parseInt(record.get("Servings"));
                  Double spoonacularScore = Double.parseDouble(record.get("Spoonacular Score"));
                  String title = record.get("Title");
                  Boolean vegan = Boolean.parseBoolean(record.get("Vegan"));
                  Boolean vegetarian = Boolean.parseBoolean(record.get("Vegetarian"));

                  recipeList.add(new Recipe(cookingMinutes, dairyFree, glutenFree, instructions, preparationMinutes, pricePerServing,
                                            readyInMinutes, servings, spoonacularScore, title, vegan, vegetarian));

            }
            return recipeList;
      }

      public String xFree(List<Recipe> recipeList, String x){
            String xList = "";
            for (Recipe recipe : recipeList){
                  switch (x){
                        case Recipe.GLUTEN_FREE:
                              if(recipe.getGlutenFree().equals(true)){
                                    xList += recipe;
                              }
                              break;
                        case Recipe.VEGAN:
                              if(recipe.getVegan().equals(true)){
                                    xList += recipe;
                              }
                              break;
                        case Recipe.VEGETARIAN:
                              if(recipe.getVegetarian().equals(true)){
                                    xList += recipe;
                              }
                              break;
                        case Recipe.VEGAN_GLUTEN_FREE:
                              if(recipe.getVegan().equals(true) && recipe.getGlutenFree().equals(true)){
                                    xList += recipe;
                              }
                              break;
                  }
            }
            return xList;
      }

      public String xFree(List<Recipe> recipeList){
           String xList = "";
           for (Recipe recipe : recipeList){
                xList += recipe;
           }
           return xList;
      }

}
