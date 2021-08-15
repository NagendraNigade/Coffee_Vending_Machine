package main.java.coffeemachine.interactions.commands;

import main.java.coffeemachine.domain.Item;
import main.java.coffeemachine.handler.CoffeeMachineCommandHandler;

import java.util.Set;

public class AddServingsCommand implements Command{
    CoffeeMachineCommandHandler coffeeMachineCommandHandler;

    public AddServingsCommand(CoffeeMachineCommandHandler coffeeMachineCommandHandler) {
        this.coffeeMachineCommandHandler = coffeeMachineCommandHandler;
    }

    @Override
    public void execute(Set<Item> servings) {
        coffeeMachineCommandHandler.addServingItems(servings);
    }

}
