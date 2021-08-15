package main.java.coffeemachine.interactions.commands;

import main.java.coffeemachine.domain.Ingredient;
import main.java.coffeemachine.handler.CoffeeMachineCommandHandler;

import java.util.Set;

public class AddInventoryCommand implements Command {
    CoffeeMachineCommandHandler coffeeMachineCommandHandler;

    public AddInventoryCommand(CoffeeMachineCommandHandler coffeeMachineCommandHandler) {
        this.coffeeMachineCommandHandler = coffeeMachineCommandHandler;
    }

    @Override
    public void execute(Ingredient inventory) {
        coffeeMachineCommandHandler.addInventory(inventory);
    }
}
