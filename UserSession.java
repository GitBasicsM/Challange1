package Challange1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserSession {
    private Map<String, User> users = new HashMap<>();
    private User currentUser;

    public UserSession() {
        // Predefined users for demonstration purposes
        users.put("user1@quinnipiac.edu", new User("user1@quinnipiac.edu", "password1"));
        users.put("user2@quinnipiac.edu", new User("user2@quinnipiac.edu", "password2"));
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public boolean login(Scanner scanner) {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = users.get(email);
        if (user != null && user.checkPassword(password)) {
            currentUser = user;
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Login failed.");
            return false;
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
