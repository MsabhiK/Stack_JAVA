package com.codingdojo.zookeeper;

public class Gorilla extends Mammal {

	public void throwSomething() {
		super.energy -= 5;
		System.out.println("The gorilla has thrown something");
		displayEnergy();
	}
	
	public void eatBananas(int nbre) {
		super.energy += 10*nbre;
		System.out.println("The gorilla's satisfaction");
		displayEnergy();
	}
	
	public void climb() {
		super.energy -= 10;
		System.out.println("The gorilla has climbed a tree");
		displayEnergy();
	}

}
