package br.net.galdino.exercicio2;

public class StudentExamAnalyzer {

	public static void main(String[] args) {
		int[] scores = new int[] {2, 4, 6, 8, 0, 1, 3, 5, 7, 9};
		System.out.println("Average score = " + calculateAverage(scores));
		System.out.println("Highest score = " + findHighestScore(scores));
	}
	
	private static double calculateAverage(int[] scores) {
		int total = 0;
		int count = 0;
		for(int score : scores) {
			count++;
			total+=score;
		}
		return (double) total / count;
	}
	
	private static int findHighestScore(int[] scores) {
		int higher = 0;
		for(int score : scores) {
			if(score > higher) {
				higher = score;
			}
		}
		return higher;
	}

}
