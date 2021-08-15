package main.java.coffeemachine.exceptions;

public class CoffeeMachineNotCreatedException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Coffee Machine is Not Created Yet !";
    }
}
