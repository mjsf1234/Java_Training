package src.main.models;

import java.util.ArrayList;

public class Cart {
    ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<Item>();
    }

    public Item getItem(int index) {
        return new Item(this.items.get(index));
    }

    public void setItem(int index, Item item) {
        this.items.set(index, new Item(item));
    }

    // add methode to add the item to cart
    public boolean add(Item item) {

        if (this.items.contains(item)) {
            return false;
        }

        items.add(item);
        return true;
    }

    // Contain methode to check if item is present in the cart or not
    public boolean contain(Item item) {
        return items.contains(item);
    }

    // adding the remove methode

    public void remove(String name) {

        // functional approach

        this.items.removeIf((item) -> {
            return item.getName().equals(name);
        });

        // Loop approach
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getName().equals(name)) {
                this.items.remove(i);
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.items.size(); i++) {
            temp += this.items.get(i).toString();
            temp += "\n";
        }
        return temp;
    }

}
