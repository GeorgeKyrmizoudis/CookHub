package com.example.cookhub.pojo;

import java.util.ArrayList;

public class Recipe {

    public String uri;
    public String label;
    public String image;
    public Images images;
    public String source;
    public String url;
    public String shareAs;
    public int yield;
    public ArrayList<String> dietLabels;
    public ArrayList<String> healthLabels;
    public ArrayList<String> cautions;
    public ArrayList<String> ingredientLines;
    public ArrayList<Ingredient> ingredients;
    public float calories;
    public int glycemicIndex;
    public int totalCO2Emissions;
    public String co2EmissionsClass;
    public float totalWeight;
    public ArrayList<String> cuisineType;
    public ArrayList<String> mealType;
    public ArrayList<String> dishType;
    public TotalNutrients totalNutrients;
    public TotalDaily totalDaily;
    public ArrayList<Digest> digest;


    public Recipe() {
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShareAs() {
        return shareAs;
    }

    public void setShareAs(String shareAs) {
        this.shareAs = shareAs;
    }

    public int getYield() {
        return yield;
    }

    public void setYield(int yield) {
        this.yield = yield;
    }

    public ArrayList<String> getDietLabels() {
        return dietLabels;
    }

    public void setDietLabels(ArrayList<String> dietLabels) {
        this.dietLabels = dietLabels;
    }

    public ArrayList<String> getHealthLabels() {
        return healthLabels;
    }

    public void setHealthLabels(ArrayList<String> healthLabels) {
        this.healthLabels = healthLabels;
    }

    public ArrayList<String> getCautions() {
        return cautions;
    }

    public void setCautions(ArrayList<String> cautions) {
        this.cautions = cautions;
    }

    public ArrayList<String> getIngredientLines() {
        return ingredientLines;
    }

    public void setIngredientLines(ArrayList<String> ingredientLines) {
        this.ingredientLines = ingredientLines;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getGlycemicIndex() {
        return glycemicIndex;
    }

    public void setGlycemicIndex(int glycemicIndex) {
        this.glycemicIndex = glycemicIndex;
    }

    public int getTotalCO2Emissions() {
        return totalCO2Emissions;
    }

    public void setTotalCO2Emissions(int totalCO2Emissions) {
        this.totalCO2Emissions = totalCO2Emissions;
    }

    public String getCo2EmissionsClass() {
        return co2EmissionsClass;
    }

    public void setCo2EmissionsClass(String co2EmissionsClass) {
        this.co2EmissionsClass = co2EmissionsClass;
    }

    public float getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    public ArrayList<String> getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(ArrayList<String> cuisineType) {
        this.cuisineType = cuisineType;
    }

    public ArrayList<String> getMealType() {
        return mealType;
    }

    public void setMealType(ArrayList<String> mealType) {
        this.mealType = mealType;
    }

    public ArrayList<String> getDishType() {
        return dishType;
    }

    public void setDishType(ArrayList<String> dishType) {
        this.dishType = dishType;
    }

    public TotalNutrients getTotalNutrients() {
        return totalNutrients;
    }

    public void setTotalNutrients(TotalNutrients totalNutrients) {
        this.totalNutrients = totalNutrients;
    }

    public TotalDaily getTotalDaily() {
        return totalDaily;
    }

    public void setTotalDaily(TotalDaily totalDaily) {
        this.totalDaily = totalDaily;
    }

    public ArrayList<Digest> getDigest() {
        return digest;
    }

    public void setDigest(ArrayList<Digest> digest) {
        this.digest = digest;
    }
}

