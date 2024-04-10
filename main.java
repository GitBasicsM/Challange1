package Challange1;

import java.util.Scanner;

public class main {
    private static final Scanner scanner = new Scanner(System.in);
    private static UserSession userSession = new UserSession();
    private static ItemInventory itemInventory = new ItemInventory();

    public static void main(String[] args) {
        System.out.println(" __      __       .__                                __________      ___.                  __          \r\n" + //
                        "/  \\    /  \\ ____ |  |   ____  ____   _____   ____   \\______   \\ ____\\_ |__   ____ _____ _/  |_  ______\r\n" + //
                        "\\   \\/\\/   // __ \\|  | _/ ___\\/  _ \\ /     \\_/ __ \\   |    |  _//  _ \\| __ \\_/ ___\\\\__  \\\\   __\\/  ___/\r\n" + //
                        " \\        /\\  ___/|  |_\\  \\__(  <_> )  Y Y  \\  ___/   |    |   (  <_> ) \\_\\ \\  \\___ / __ \\|  |  \\___ \\ \r\n" + //
                        "  \\__/\\  /  \\___  >____/\\___  >____/|__|_|  /\\___  >  |______  /\\____/|___  /\\___  >____  /__| /____  >\r\n" + //
                        "       \\/       \\/          \\/            \\/     \\/          \\/           \\/     \\/     \\/          \\/ ");
        while (!userSession.isLoggedIn()) {
            if (!userSession.login(scanner)) {
                return; // Exit the application if login fails
            }
        }
        Menu.showMainMenu(scanner, userSession, itemInventory);
    }
}

