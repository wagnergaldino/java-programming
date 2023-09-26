package br.net.galdino.exercicio3;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<Animal>();
		
		animals.add(new Dog("dog1"));
		animals.add(new Cat("cat1"));
		animals.add(new Bird("bird1"));
		animals.add(new Dog("dog2"));
		animals.add(new Cat("cat2"));
		animals.add(new Bird("bird2"));
		
		for(Animal animal : animals) {
			System.out.println(animal.toString());
			animal.makeSound();
		}
	}

}

class Animal {
	private String nome;

	public Animal(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Animal [nome=" + nome + "]";
	}
	
	public void makeSound() {
		System.out.println("The animal makes a sound.");
	}
}

class Dog extends Animal {
	public Dog(String nome) {
		super(nome);
	}

	@Override
	public void makeSound() {
		System.out.println("The dog barks.");
	}
}

class Cat extends Animal {
	public Cat(String nome) {
		super(nome);
	}

	@Override
	public void makeSound() {
		System.out.println("The cat meows.");
	}
}

class Bird extends Animal {
	public Bird(String nome) {
		super(nome);
	}

	@Override
	public void makeSound() {
		System.out.println("The bird chirps.");
	}
}
