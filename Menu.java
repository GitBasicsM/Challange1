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

    private static void showCartMenu(Scanner scanner, ItemInventory inventory) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showCartMenu'");
    }

    private static void showSellMenu(Scanner scanner, User currentUser, ItemInventory inventory) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showSellMenu'");
    }

    private static void showBuyMenu(Scanner scanner, ItemInventory inventory) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showBuyMenu'");
    }
}