package com.codingdojo.zookeeper;

public class Mammal {
	protected int energy = 100;

	public Mammal() {
		// TODO Auto-generated constructor stub
	}

	public Mammal(int energy) {
		this.energy = energy;
	}
	
	public void displayEnergy() {
		System.out.println("The energy level is: " + energy);
	}

	
	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}
	

}
