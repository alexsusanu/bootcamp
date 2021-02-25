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

        public static final String GLUTEN_FREE = "gluten free";
        public static final String VEGAN = "vegan";
        public static final String VEGETARIAN = "vegetarian";
        public static final String VEGAN_GLUTEN_FREE = "vegan gluten free";

    @Override
    public String toString() {
        return "Title: " + this.title + "\n" +
                "Cooking time: " + this.cookingMinutes + "\n" +
                "Preparation Minutes: " + this.preparationMinutes + "\n" +
                "Ready in minutes: " + this.readyInMinutes + "\n" +
                "Dairy Free?: " + boolToString(this.dairyFree) + "\n" +
                "Gluten Free?: " + boolToString(this.glutenFree) + "\n" +
                "Vegan?: " + boolToString(this.vegan)+ "\n" +
                "Vegetarian?: " + boolToString(this.vegetarian) + "\n" +
                "Servings: " + this.servings + "\n" +
                "Price per serving: " + this.pricePerServing + "\n" +
                "Instructions: " + this.instructions;
    }


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
}
