package main.java.coffeemachine.exceptions;

public class InsufficientIngredientsException extends RuntimeException{
    String ingredientName;

    public InsufficientIngredientsException(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientName() {
        return ingredientName;
    }
}
