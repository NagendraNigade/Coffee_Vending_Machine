package test.interactions.commands;

import main.java.coffeemachine.domain.Ingredient;
import main.java.coffeemachine.domain.Item;
import main.java.coffeemachine.handler.CoffeeMachineCommandHandler;
import main.java.coffeemachine.interactions.commands.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ServeCommandTest {
    CoffeeMachineCommandHandler coffeeMachineCommandHandler;
    ServeCommand serveCommand;
    public void init(){
        coffeeMachineCommandHandler = new CoffeeMachineCommandHandler();
        serveCommand = new ServeCommand(coffeeMachineCommandHandler);

        Map<String, Command> commands = new HashMap<>();
        commands.put("create_machine",new CreateCoffeeMachineCommand(coffeeMachineCommandHandler));
        commands.put("add_inventory",new AddInventoryCommand(coffeeMachineCommandHandler));
        commands.put("add_Servings",new AddServingsCommand(coffeeMachineCommandHandler));
        commands.put("serve",new ServeCommand(coffeeMachineCommandHandler));

        //Static Input
        int outlets = 4;
        Ingredient inventory = new Ingredient();
        inventory.getIngredient().put("hot_water",500);
        inventory.getIngredient().put("hot_milk",500);
        inventory.getIngredient().put("ginger_syrup",100);
        inventory.getIngredient().put("sugar_syrup",100);
        inventory.getIngredient().put("tea_leaves_syrup",100);

        Item hotTea = new Item();
        hotTea.setName("hot_tea");
        Ingredient ingredient1 = new Ingredient();
        ingredient1.getIngredient().put("hot_water",200);
        ingredient1.getIngredient().put("hot_milk",100);
        ingredient1.getIngredient().put("ginger_syrup",10);
        ingredient1.getIngredient().put("sugar_syrup",10);
        ingredient1.getIngredient().put("tea_leaves_syrup",30);
        hotTea.setItemIngredients(ingredient1);

        Item hotCoffee = new Item();
        hotCoffee.setName("hot_coffee");
        Ingredient ingredient2 = new Ingredient();
        ingredient2.getIngredient().put("hot_water",100);
        ingredient2.getIngredient().put("hot_milk",400);
        ingredient2.getIngredient().put("ginger_syrup",30);
        ingredient2.getIngredient().put("sugar_syrup",50);
        ingredient2.getIngredient().put("tea_leaves_syrup",30);
        hotCoffee.setItemIngredients(ingredient2);

        Item blackTea = new Item();
        blackTea.setName("black_tea");
        Ingredient ingredient3 = new Ingredient();
        ingredient3.getIngredient().put("hot_water",300);
        ingredient3.getIngredient().put("ginger_syrup",30);
        ingredient3.getIngredient().put("sugar_syrup",50);
        ingredient3.getIngredient().put("tea_leaves_syrup",30);
        blackTea.setItemIngredients(ingredient3);

        Item greenTea = new Item();
        greenTea.setName("green_tea");
        Ingredient ingredient4 = new Ingredient();
        ingredient4.getIngredient().put("hot_water",100);
        ingredient4.getIngredient().put("ginger_syrup",30);
        ingredient4.getIngredient().put("sugar_syrup",50);
        ingredient4.getIngredient().put("green_mixture",30);
        greenTea.setItemIngredients(ingredient4);

        Set<Item> servings = new HashSet<>();
        servings.add(hotTea);
        servings.add(hotCoffee);
        servings.add(greenTea);
        servings.add(blackTea);

        //Machine Created and Inventory Added
        commands.get("create_machine").execute(outlets);
        commands.get("add_inventory").execute(inventory);
        commands.get("add_Servings").execute(servings);

    }

    @Test
    public void validServe(){
        init();
        Item blackTea = new Item();
        blackTea.setName("black_tea");
        int prevHotWaterQuantity = coffeeMachineCommandHandler.getCoffeeMachine().getInventory().getIngredient().get("hot_water");
        Ingredient ingredient3 = new Ingredient();
        ingredient3.getIngredient().put("hot_water",300);
        ingredient3.getIngredient().put("ginger_syrup",30);
        ingredient3.getIngredient().put("sugar_syrup",50);
        ingredient3.getIngredient().put("tea_leaves_syrup",30);
        blackTea.setItemIngredients(ingredient3);
        serveCommand.execute(blackTea);
        Assert.assertEquals((int) coffeeMachineCommandHandler.getCoffeeMachine().getInventory().getIngredient().get("hot_water"),prevHotWaterQuantity-(int) ingredient3.getIngredient().get("hot_water"));
    }


}
