package org.example;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(int id) {
        items.removeIf(item -> item.getId() == id);
    }

    public void viewItems() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    public void updateQuantity(int id, int newQuantity) {
        boolean found = false;
        for (Item item : items) {
            if (item.getId() == id) {
                item.setQuantity(newQuantity);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Item with ID " + id + " not found.");
        }
    }

    public boolean isIdUnique(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return false;
            }
        }
        return true;
    }
}
