package main.java.coffeemachine.handler;

import main.java.coffeemachine.domain.Ingredient;
import main.java.coffeemachine.domain.Item;
import main.java.coffeemachine.exceptions.CoffeeMachineNotCreatedException;
import main.java.coffeemachine.interactions.machines.CoffeeMachine;
import main.java.coffeemachine.util.Util;

import java.util.*;

public class CoffeeMachineCommandHandler {
    CoffeeMachine coffeeMachine;
    Util machineUtil;

    public CoffeeMachine getCoffeeMachine() {
        return coffeeMachine;
    }

    public void createCoffeeMachine(int outlets){
        coffeeMachine = new CoffeeMachine(outlets,outlets);
        machineUtil = new Util(coffeeMachine);
    }

    public void addServingItems(Set<Item> servingItems){
        if(coffeeMachine!=null){
            for(Item item:servingItems){
                coffeeMachine.getServingItems().add(item);
            }
        }
        else {
            throw new CoffeeMachineNotCreatedException();
        }
    }

    public void addInventory(Ingredient newIngredient){
        this.changeInventory(newIngredient,true);
    }

    public void serve(Item servingItem){
        try{
            machineUtil.validateItemServedByCoffeeMachine(servingItem);
            synchronized (this){
                machineUtil.validationEnoughQuantityAvailable(servingItem);
                this.changeInventory(servingItem.getItemIngredients(),false);
                machineUtil.reduceFreeOutletByNumber(1);
            }
        }
        finally {
        }
    }

    public List<String> checkLowRunningInventory(Map<String,Integer> threshold){
        List<String> lowIngredients = new LinkedList<>();
        for(Map.Entry entry : threshold.entrySet()){
            if((!coffeeMachine.getInventory().getIngredient().containsKey(entry.getKey())) || (coffeeMachine.getInventory().getIngredient().containsKey(entry.getKey()) && (int)entry.getValue()>(int)coffeeMachine.getInventory().getIngredient().get(entry.getKey()))){
                lowIngredients.add((String) entry.getKey());
            }
        }
        return lowIngredients;
    }

    private synchronized void changeInventory(Ingredient newIngredient, boolean addToInventory){
        if(coffeeMachine!=null){
            if(addToInventory){
                //Add Ingredient To Machine
                for (Map.Entry entry : newIngredient.getIngredient().entrySet()){
                    if(coffeeMachine.getInventory().getIngredient().containsKey(entry.getKey())){
                        int oldQuantity = coffeeMachine.getInventory().getIngredient().get(entry.getKey());
                        coffeeMachine.getInventory().getIngredient().put((String) entry.getKey(),oldQuantity+(Integer) entry.getValue());
                    }
                    else {
                        coffeeMachine.getInventory().getIngredient().put((String) entry.getKey(),(Integer) entry.getValue());
                    }
                }
            }
            else {
                //Remove ingredients from Machine
                for (Map.Entry entry : newIngredient.getIngredient().entrySet()){
                    if(coffeeMachine.getInventory().getIngredient().containsKey(entry.getKey())){
                        int oldQuantity = coffeeMachine.getInventory().getIngredient().get(entry.getKey());
                        coffeeMachine.getInventory().getIngredient().put((String) entry.getKey(),oldQuantity-(Integer) entry.getValue());
                    }
                    else {
                        // Throw Exception - Ingredient Not Present
                    }
                }
            }
        }
        else{
            throw new CoffeeMachineNotCreatedException();
        }
    }
}
