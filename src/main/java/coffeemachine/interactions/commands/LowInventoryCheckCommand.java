package main.java.coffeemachine.interactions.commands;

import main.java.coffeemachine.handler.CoffeeMachineCommandHandler;

import java.util.List;
import java.util.Map;

public class LowInventoryCheckCommand implements Command{
    CoffeeMachineCommandHandler coffeeMachineCommandHandler;

    public LowInventoryCheckCommand(CoffeeMachineCommandHandler coffeeMachineCommandHandler) {
        this.coffeeMachineCommandHandler = coffeeMachineCommandHandler;
    }

    public List<String> execute(Map<String,Integer> threshold){
        return coffeeMachineCommandHandler.checkLowRunningInventory(threshold);
    }
}
