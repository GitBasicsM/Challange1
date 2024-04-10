package Challange1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static List<Item> cart = new ArrayList<>();

    public static void showMainMenu(Scanner scanner, UserSession userSession, ItemInventory inventory) {
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Buy");
            System.out.println("2. Sell");
            System.out.println("3. View Cart");
            System.out.println("4. Logout");
            System.out.print("Select an option: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    showBuyMenu(scanner, inventory);
                    break;
                case 2:
                    showSellMenu(scanner, userSession.getCurrentUser(), inventory);
                    break;
                case 3:
                    showCartMenu(scanner, inventory);
                    break;
                case 4:
                    System.out.println("Thank you for using the app. You have successfully logged out.");
                    return; // Logout
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }

    private static void showBuyMenu(Scanner scanner, ItemInventory inventory) {
        List<Item> items = inventory.getItems();
        if (items.isEmpty()) {
            System.out.println("No items available for sale.");
            return;
        }

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - $" + item.getPrice());
        }

        System.out.println("Select an item to buy (or 0 to go back):");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice > 0 && choice <= items.size()) {
            Item selectedItem = items.get(choice - 1);
            cart.add(selectedItem);
            System.out.println(selectedItem.getName() + " added to cart!");
        }
    }

    private static void showSellMenu(Scanner scanner, User currentUser, ItemInventory inventory) {
        System.out.println("1. List my items");
        System.out.println("2. Add an item for sale");
        System.out.print("Select an option: ");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                List<Item> userItems = inventory.getItemsBySeller(currentUser.getEmail());
                if (userItems.isEmpty()) {
                    System.out.println("You have no items listed for sale.");
                } else {
                    userItems.forEach(item ->
                            System.out.println(item.getName() + " - $" + item.getPrice()));
                }
                break;
            case 2:
                System.out.print("Enter item name: ");
                String name = scanner.nextLine();
                System.out.print("Enter item category: ");
                String category = scanner.nextLine();
                System.out.print("Enter item price: ");
                double price = Double.parseDouble(scanner.nextLine());

                inventory.addItem(name, category, price, currentUser.getEmail());
                System.out.println("Item added for sale.");
                break;
            default:
                System.out.println("Invalid option, try again.");
                break;
        }
    }

    private static void showCartMenu(Scanner scanner, ItemInventory inventory) {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        double total = 0;
        for (Item item : cart) {
            System.out.println(item.getName() + " - $" + item.getPrice());
            total += item.getPrice();
        }
        System.out.println("Total: $" + total);
        System.out.println("1. Checkout");
        System.out.println("2. Return to Main Menu");
        System.out.print("Choose an option: ");
        
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            cart.forEach(inventory::removeItem);
            cart.clear();
            System.out.println("You have successfully checked out your cart.");
        }
    }
}
