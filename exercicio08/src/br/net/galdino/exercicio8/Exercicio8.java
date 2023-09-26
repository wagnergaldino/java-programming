package br.net.galdino.exercicio8;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercicio8 {
	
    public static void main(String[] args) {
        Set<String> votes = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
 
        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Cast a vote");
            System.out.println("2. Count votes");
            System.out.println("3. Display vote count");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
 
            switch (choice) {
                case 1:
                    System.out.print("Enter candidate's name: ");
                    String candidate = scanner.nextLine();
                    votes.add(candidate);
                    break;
                case 2:
                    int count = votes.size();
                    System.out.println("Total votes: " + count);
                    break;
                case 3:
                    System.out.println("Vote count for each candidate:");
                    for (String candidateName : votes) {
                        int candidateCount = 0;
                        for (String vote : votes) {
                            if (vote.equals(candidateName)) {
                                candidateCount++;
                            }
                        }
                        System.out.println(candidateName + ": " + candidateCount);
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
