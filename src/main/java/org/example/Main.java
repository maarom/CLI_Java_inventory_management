package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        Menu(scanner, inventory);
    }

    private static void Menu(Scanner scanner, Inventory inventory) {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add new item");
            System.out.println("2. Remove item");
            System.out.println("3. View all items");
            System.out.println("4. Update quantity");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                scanner.next(); // clear the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id;
                    while (true) {
                        if (scanner.hasNextInt()) {
                            id = scanner.nextInt();
                            if(id < 0) {
                                System.out.println("Id must be positive number");
                                continue;
                            }
                            else if (!inventory.isIdUnique(id)) {
                                System.out.println("ID must be unique. Please enter a different ID:");
                                continue;
                            }
                            break;
                        } else {
                            System.out.println("Invalid ID. Please enter a valid integer ID:");
                            scanner.next(); // clear the invalid input
                        }
                    }
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter quantity: ");
                    int quantity;
                    while (true) {
                        if (scanner.hasNextInt()) {
                            quantity = scanner.nextInt();
                            if (quantity < 0) {
                                System.out.println("Quantity cannot be negative. Please enter a non-negative integer:");
                                continue;
                            }
                            break;
                        } else {
                            System.out.println("Invalid quantity. Please enter a valid integer quantity:");
                            scanner.next(); // clear the invalid input
                        }
                    }
                    System.out.print("Enter price: ");
                    double price;
                    while (true) {
                        if (scanner.hasNextDouble()) {
                            price = scanner.nextDouble();
                            if (price < 0) {
                                System.out.println("Price cannot be negative. Please enter a non-negative number:");
                                continue;
                            }
                            break;
                        } else {
                            System.out.println("Invalid price. Please enter a valid double price:");
                            scanner.next(); // clear the invalid input
                        }
                    }
                    inventory.addItem(new Item(id, name, quantity, price));
                    break;
                case 2:
                    System.out.print("Enter ID of item to remove: ");
                    int removeId;
                    while (true) {
                        if (scanner.hasNextInt()) {
                            removeId = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Invalid ID. Please enter a valid integer ID:");
                            scanner.next(); // clear the invalid input
                        }
                    }
                    inventory.removeItem(removeId);
                    break;
                case 3:
                    System.out.println("Inventory items:");
                    inventory.viewItems();
                    break;
                case 4:
                    System.out.print("Enter ID of item to update: ");
                    int updateId;
                    while (true) {
                        if (scanner.hasNextInt()) {
                            updateId = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Invalid ID. Please enter a valid integer ID:");
                            scanner.next(); // clear the invalid input
                        }
                    }
                    System.out.print("Enter new quantity: ");
                    int newQuantity;
                    while (true) {
                        if (scanner.hasNextInt()) {
                            newQuantity = scanner.nextInt();
                            if (newQuantity < 0) {
                                System.out.println("Quantity cannot be negative. Please enter a non-negative integer:");
                                continue;
                            }
                            break;
                        } else {
                            System.out.println("Invalid quantity. Please enter a valid integer quantity:");
                            scanner.next(); // clear the invalid input
                        }
                    }
                    inventory.updateQuantity(updateId, newQuantity);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}