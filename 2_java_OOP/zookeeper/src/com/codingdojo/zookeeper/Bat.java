package com.codingdojo.zookeeper;

public class Bat extends Mammal {

	public Bat(int energy) {
		super(energy);
	}
	
	public void fly(int nb_fly) {
		super.energy -= 50*nb_fly;
		System.out.printf("The bat is airborne by %d flys. ", nb_fly);
		displayEnergy();
	}
	
	public void eatHumans(int nbre) {
		super.energy += 25*nbre;
		System.out.printf("The bat's satisfaction by %d humans. ", nbre);
		displayEnergy();
	}
	
	public void attackTown(int nbr_town) {
		super.energy -= 100*nbr_town;
		System.out.printf("The bat's attack %d towns. ", nbr_town);
		displayEnergy();
	}

}
