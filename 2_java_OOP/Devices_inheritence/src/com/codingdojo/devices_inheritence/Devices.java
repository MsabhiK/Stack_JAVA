package com.codingdojo.devices_inheritence;

public class Devices {
	protected int battery=100;
	public Devices() {
		// TODO Auto-generated constructor stub
	}
	public Devices(int battery) {
		this.battery = 100;
	}
	public void displaylife() {
		System.out.println("Your battery remaining: " + battery);
	}
	
	public int getBattery() {
		return this.battery;
	}
	
	public void setBattery(int battery) {
		this.battery = battery;
	}
	

}
