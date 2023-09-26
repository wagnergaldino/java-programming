package br.net.galdino.exercicio9;

import java.util.HashSet;
import java.util.Scanner;

public class Exercicio9 {
	
	public static void main(String[] args) {
		
		RatingSystem ratingSystem = new RatingSystem();
		
		Scanner scanner = new Scanner(System.in);
		 
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add a Movie Rating");
            System.out.println("2. Display the Ratings");
            System.out.println("3. Exit");
 
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character
 
            switch (choice) {
                case 1:
                    System.out.println("Enter a Movie to add:");                    
                    String movie = scanner.next();
                    System.out.print("Enter Movie Rating: ");
                    int rating = scanner.nextInt();
                    MovieRating movieRating = new MovieRating(movie, rating);
                    ratingSystem.addRating(movieRating);
                    break;
                case 2:
                    System.out.println("Movie Rating List:");
                    ratingSystem.displayRatings();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }		
	}	
}

class RatingSystem {
    private HashSet<MovieRating> ratings;
 
    public RatingSystem() {
        ratings = new HashSet<MovieRating>();
    }
 
    public void addRating(MovieRating rating) {
        ratings.add(rating);
    }
 
    public void displayRatings() {
        for (MovieRating rating : ratings) {
            System.out.println(rating.getMovieTitle() + ": " + rating.getRating());
        }
    }
}

class MovieRating {
    private String movieTitle;
    private int rating;
 
    public MovieRating(String movieTitle, int rating) {
        this.movieTitle = movieTitle;
        this.rating = rating;
    }
 
    public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getMovieTitle() {
        return movieTitle;
    }
 
    public int getRating() {
        return rating;
    }
}

