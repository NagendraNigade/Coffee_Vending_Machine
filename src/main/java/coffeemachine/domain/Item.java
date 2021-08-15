package main.java.coffeemachine.domain;

public class Item {
    String name;
    Ingredient itemIngredients;

    @Override
    public boolean equals(Object o){
        if(this.name==((Item) o).name){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return this.name.hashCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ingredient getItemIngredients() {
        return itemIngredients;
    }

    public void setItemIngredients(Ingredient itemIngredients) {
        this.itemIngredients = itemIngredients;
    }
}
