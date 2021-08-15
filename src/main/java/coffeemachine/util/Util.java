package main.java.coffeemachine.util;

import main.java.coffeemachine.domain.Item;
import main.java.coffeemachine.exceptions.CoffeeMachineDoesNotServeThisItem;
import main.java.coffeemachine.exceptions.IngredientNotFountException;
import main.java.coffeemachine.exceptions.InsufficientIngredientsException;
import main.java.coffeemachine.exceptions.NoFreeOutletException;
import main.java.coffeemachine.interactions.machines.CoffeeMachine;

import java.util.Map;

public class Util {
    CoffeeMachine coffeeMachine;

    public Util(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public void validateItemServedByCoffeeMachine(Item item){
        if(!coffeeMachine.getServingItems().contains(item)){
            throw new CoffeeMachineDoesNotServeThisItem();
        }
    }

    public void validationEnoughQuantityAvailable(Item item){
        if(coffeeMachine.getFreeOutlets()==0) throw new NoFreeOutletException();
        for(Map.Entry entry :  item.getItemIngredients().getIngredient().entrySet()){
            if(coffeeMachine.getInventory().getIngredient().containsKey(entry.getKey())){
                int currentQuantity = coffeeMachine.getInventory().getIngredient().get(entry.getKey());
                if(currentQuantity<(int) entry.getValue()){
                    throw new InsufficientIngredientsException((String)entry.getKey());
                }
            }
            else{
                throw new IngredientNotFountException((String) entry.getKey());
            }
        }
    }

    public void reduceFreeOutletByNumber(int number){
        coffeeMachine.setFreeOutlets(coffeeMachine.getFreeOutlets()-number);
    }

}
