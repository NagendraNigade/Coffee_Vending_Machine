package main.java.coffeemachine.domain;

import java.util.HashMap;
import java.util.Map;

public class Ingredient {
    Map<String,Integer> ingredient = new HashMap<>();

    public Map<String, Integer> getIngredient() {
        return ingredient;
    }

    public void setIngredient(Map<String, Integer> ingredient) {
        this.ingredient = ingredient;
    }
}
