package main.java.coffeemachine.interactions.machines;

import main.java.coffeemachine.domain.Ingredient;
import main.java.coffeemachine.domain.Item;

import java.util.*;

public class CoffeeMachine {
    private int totalOutlet;
    private int freeOutlets;
    private Set<Item> servingItems = new HashSet<>();
    private Ingredient inventory;

    public CoffeeMachine(int totalOutlet, int freeOutlets) {
        this.totalOutlet = totalOutlet;
        this.freeOutlets = freeOutlets;
        inventory = new Ingredient();
    }

    public int getTotalOutlet() {
        return totalOutlet;
    }

    public void setTotalOutlet(int totalOutlet) {
        this.totalOutlet = totalOutlet;
    }

    public int getFreeOutlets() {
        return freeOutlets;
    }

    public void setFreeOutlets(int freeOutlets) {
        this.freeOutlets = freeOutlets;
    }

    public Set<Item> getServingItems() {
        return servingItems;
    }

    public void setServingItems(Set<Item> servingItems) {
        this.servingItems = servingItems;
    }

    public Ingredient getInventory() {
        return inventory;
    }

    public void setInventory(Ingredient inventory) {
        this.inventory = inventory;
    }
}
