package br.net.galdino.exercicio1;

public class EvenNumberCounter {
	
	public static void main(String[] args) {
		System.out.println("Total of even numbers: " + countAndDisplayEvens(-10));
	}
	
	private static int countAndDisplayEvens(int limit) {
		int counter = 0;
		if(limit >= 2) {
			for(int i = 2; i <= limit; i++) {
				if(i % 2 == 0) {
					counter++;
					System.out.println("Even number = " + i);
				}
			}
		} else {
			for(int i = limit; i <= 2; i++) {
				if(i % 2 == 0) {
					counter++;
					System.out.println("Even number = " + i);
				}
			}
		}
		return counter;
	}

}
