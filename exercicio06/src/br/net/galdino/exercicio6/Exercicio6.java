package br.net.galdino.exercicio6;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio6 {
	
    public static void main(String[] args) {
        ArrayList<String> shoppingList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
 
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add an item");
            System.out.println("2. Remove an item");
            System.out.println("3. Display the list");
            System.out.println("4. Exit");
 
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character
 
            switch (choice) {
                case 1:
                    System.out.println("Enter item to add:");
                    String itemToAdd = scanner.nextLine();
                    shoppingList.add(itemToAdd);
                    break;
                case 2:
                    System.out.println("Enter item to remove:");
                    String itemToRemove = scanner.nextLine();
                    shoppingList.remove(itemToRemove);
                    break;
                case 3:
                    System.out.println("Shopping List:");
                    for (String item : shoppingList) {
                        System.out.println(item);
                    }
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
