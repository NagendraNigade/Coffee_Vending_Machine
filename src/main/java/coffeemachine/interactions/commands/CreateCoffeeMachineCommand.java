package main.java.coffeemachine.interactions.commands;

import main.java.coffeemachine.handler.CoffeeMachineCommandHandler;

public class CreateCoffeeMachineCommand implements Command{
    CoffeeMachineCommandHandler coffeeMachineCommandHandler;

    public CreateCoffeeMachineCommand(CoffeeMachineCommandHandler coffeeMachineCommandHandler) {
        this.coffeeMachineCommandHandler = coffeeMachineCommandHandler;
    }

    @Override
    public void execute(int outlets) {
        coffeeMachineCommandHandler.createCoffeeMachine(outlets);
    }
}
