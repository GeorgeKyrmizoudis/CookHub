package com.example.cookhub.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class Recipe implements Parcelable {

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

    protected Recipe(Parcel in) {
        uri = in.readString();
        label = in.readString();
        image = in.readString();
        source = in.readString();
        url = in.readString();
        shareAs = in.readString();
        yield = in.readInt();
        dietLabels = in.createStringArrayList();
        healthLabels = in.createStringArrayList();
        cautions = in.createStringArrayList();
        ingredientLines = in.createStringArrayList();
        calories = in.readFloat();
        glycemicIndex = in.readInt();
        totalCO2Emissions = in.readInt();
        co2EmissionsClass = in.readString();
        totalWeight = in.readFloat();
        cuisineType = in.createStringArrayList();
        mealType = in.createStringArrayList();
        dishType = in.createStringArrayList();
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(uri);
        dest.writeString(label);
        dest.writeString(image);
        dest.writeString(source);
        dest.writeString(url);
        dest.writeString(shareAs);
        dest.writeInt(yield);
        dest.writeStringList(dietLabels);
        dest.writeStringList(healthLabels);
        dest.writeStringList(cautions);
        dest.writeStringList(ingredientLines);
        dest.writeFloat(calories);
        dest.writeInt(glycemicIndex);
        dest.writeInt(totalCO2Emissions);
        dest.writeString(co2EmissionsClass);
        dest.writeFloat(totalWeight);
        dest.writeStringList(cuisineType);
        dest.writeStringList(mealType);
        dest.writeStringList(dishType);
    }
}

