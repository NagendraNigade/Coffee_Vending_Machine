package main.java.coffeemachine.exceptions;

public class IngredientNotFountException extends RuntimeException{
    String ingredientName;

    public IngredientNotFountException(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientName() {
        return ingredientName;
    }
}
