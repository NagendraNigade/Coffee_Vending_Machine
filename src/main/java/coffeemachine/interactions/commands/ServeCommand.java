package main.java.coffeemachine.interactions.commands;

import main.java.coffeemachine.domain.Item;
import main.java.coffeemachine.exceptions.IngredientNotFountException;
import main.java.coffeemachine.exceptions.InsufficientIngredientsException;
import main.java.coffeemachine.handler.CoffeeMachineCommandHandler;

public class ServeCommand implements Command{
    CoffeeMachineCommandHandler coffeeMachineCommandHandler;

    public ServeCommand(CoffeeMachineCommandHandler coffeeMachineCommandHandler) {
        this.coffeeMachineCommandHandler = coffeeMachineCommandHandler;
    }

    public void execute(Item item){
        try{
            coffeeMachineCommandHandler.serve(item);
            System.out.println(item.getName() + " is prepared");
        }
        catch (InsufficientIngredientsException insufficientIngredientsException){
            System.out.println(item.getName()+" cannot be prepared because "+insufficientIngredientsException.getIngredientName()+" is not sufficient");
        }
        catch (IngredientNotFountException ingredientNotFountException){
            System.out.println(item.getName()+" cannot be prepared because "+ingredientNotFountException.getIngredientName()+" is not available");
        }
        catch (Exception e){
        }
    }
}
