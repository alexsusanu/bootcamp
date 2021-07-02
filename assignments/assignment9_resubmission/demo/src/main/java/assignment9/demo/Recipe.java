package assignment9.demo;

public class Recipe {
    private Integer cookingMinutes;
    private Boolean dairyFree;
    private Boolean glutenFree;
    private String instructions;
    private Double preparationMinutes;
    private Double pricePerServing;
    private Integer readyInMinutes;
    private Integer servings;
    private Double spoonacularScore;
    private String title;
    private Boolean vegan;
    private Boolean vegetarian;

    public Recipe(Integer cookingMinutes, Boolean dairyFree, Boolean glutenFree, String instructions, Double preparationMinutes, Double pricePerServing, Integer readyInMinutes, Integer servings, Double spoonacularScore, String title, Boolean vegan, Boolean vegetarian) {
        this.cookingMinutes = cookingMinutes;
        this.dairyFree = dairyFree;
        this.glutenFree = glutenFree;
        this.instructions = instructions;
        this.preparationMinutes = preparationMinutes;
        this.pricePerServing = pricePerServing;
        this.readyInMinutes = readyInMinutes;
        this.servings = servings;
        this.spoonacularScore = spoonacularScore;
        this.title = title;
        this.vegan = vegan;
        this.vegetarian = vegetarian;
    }

    public Integer getCookingMinutes() {
        return cookingMinutes;
    }

    public void setCookingMinutes(Integer cookingMinutes) {
        this.cookingMinutes = cookingMinutes;
    }

    public Boolean getDairyFree() {
        return dairyFree;
    }

    public void setDairyFree(Boolean dairyFree) {
        this.dairyFree = dairyFree;
    }

    public Boolean getGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(Boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Double getPreparationMinutes() {
        return preparationMinutes;
    }

    public void setPreparationMinutes(Double preparationMinutes) {
        this.preparationMinutes = preparationMinutes;
    }

    public Double getPricePerServing() {
        return pricePerServing;
    }

    public void setPricePerServing(Double pricePerServing) {
        this.pricePerServing = pricePerServing;
    }

    public Integer getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(Integer readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public Double getSpoonacularScore() {
        return spoonacularScore;
    }

    public void setSpoonacularScore(Double spoonacularScore) {
        this.spoonacularScore = spoonacularScore;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public String boolToString(Boolean arg){
        if (!arg) {
            return "No";
        }
        return "Yes";
    }

    @Override
    public String toString() {
        return "<h2>" + this.title + "</h2>\n" +
                "<h4 style=\"display: inline\">Cooking time: </h4>" + this.cookingMinutes + "<br>" +
                "<h4 style=\"display: inline\">Preparation Minutes: </h4>" + this.preparationMinutes + "<br>" +
                "<h4 style=\"display: inline\">Ready in minutes: </h4>" + this.readyInMinutes + "<br>" +
                "<h4 style=\"display: inline\">Dairy Free?: </h4>" + boolToString(this.dairyFree) + "<br>" +
                "<h4 style=\"display: inline\">Gluten Free?: </h4>" + boolToString(this.glutenFree) + "<br>" +
                "<h4 style=\"display: inline\">Vegan?: </h4>" + boolToString(this.vegan)+ "<br>" +
                "<h4 style=\"display: inline\">Vegetarian?: </h4>" + boolToString(this.vegetarian) + "<br>" +
                "<h4 style=\"display: inline\">Servings: </h4>" + this.servings + "<br>" +
                "<h4 style=\"display: inline\">Price per serving: </h4>" + this.pricePerServing + "<br>" +
                "<h4>Instructions: </h4><p>" + this.instructions + "</p>\n";
    }
}
