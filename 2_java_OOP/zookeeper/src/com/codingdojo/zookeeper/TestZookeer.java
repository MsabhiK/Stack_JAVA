package com.codingdojo.zookeeper;

public class TestZookeer {

	public static void main(String[] args) {
		Mammal mammal1 = new Mammal();
		mammal1.displayEnergy();
		
		Gorilla gorila1 = new Gorilla();
		gorila1.throwSomething();
		gorila1.throwSomething();
		gorila1.throwSomething();
		gorila1.eatBananas(2);
		gorila1.climb();
		System.out.println("/***********************************************/");
		Bat bat1 = new Bat(300);
		bat1.displayEnergy();
		System.out.printf("-/: "); bat1.attackTown(3);
		System.out.printf("-/: "); bat1.eatHumans(2);
		System.out.printf("-/: "); bat1.fly(2);

	}

}
