package br.net.galdino.exercicio5;

import java.util.InputMismatchException;
import java.util.Scanner;
 
public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();
            if (age < 18) {
                throw new AgeNotAllowedException("Sorry, you are not old enough to access this website.");
            } else {
                System.out.println("Welcome to the website!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a valid age.");
        } catch (AgeNotAllowedException e) {
            System.out.println(e.getMessage());
        }
    }
}
 
class AgeNotAllowedException extends Exception {
    public AgeNotAllowedException(String message) {
        super(message);
    }
}
