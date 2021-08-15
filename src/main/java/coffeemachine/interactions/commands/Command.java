package main.java.coffeemachine.interactions.commands;

import main.java.coffeemachine.domain.Ingredient;
import main.java.coffeemachine.domain.Item;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Command {
    default void execute(int outlets){};
    default void execute(Set<Item> servings){};
    default void execute(Ingredient ingredient){};
    default void execute(Item item){};
    default List<String> execute(Map<String,Integer> threshold){return null;};
}
