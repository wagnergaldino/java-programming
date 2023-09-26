package br.net.galdino.exercicio7;

import java.util.HashMap;
import java.util.Scanner;

public class Exercicio7 {
	
	public static void main(String[] args) {
        HashMap<String, Integer> cart = new HashMap<>();
        HashMap<String, Double> prices = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
 
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add item to cart");
            System.out.println("2. Display cart contents");
            System.out.println("3. Calculate total price");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
 
            if (choice == 1) {
                System.out.print("Enter item name: ");
                String itemName = scanner.next();
                System.out.print("Enter item quantity: ");
                int quantity = scanner.nextInt();
                cart.put(itemName, quantity);
                prices.put(itemName, quantity * 2.5);
            } else if (choice == 2) {
                System.out.println("Cart contents:");
                for (String itemName : cart.keySet()) {
                    int quantity = cart.get(itemName);
                    System.out.println(itemName + ": " + quantity);
                }
            } else if (choice == 3) {
                double totalPrice = 0;
                for (String itemName : cart.keySet()) {
                    int quantity = cart.get(itemName);
                    double price = prices.get(itemName);
                    totalPrice += quantity * price;
                }
                System.out.println("Total price: " + totalPrice);
            } else if (choice == 4) {
            	System.out.println("Exiting program...");
                return;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
