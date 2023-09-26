package br.net.galdino.exercicio4;

public class Application {

	public static void main(String[] args) {		
		System.out.println("grade = " + determineGrade(50));
	}
	
    public static String determineGrade(int score) {
        return score >= 90 ? "A" : score >= 80 ? "B" : score >= 70 ? "C" : score >= 60 ? "D" : "F";
    }

}
