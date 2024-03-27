package Challange1;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please login using your Quinnipiac email.");
        String email = scanner.nextLine();

        System.out.println("Please login using your Quinnipiac password.");
        String password = scanner.nextLine();

        scanner.close(); 
    }
}

