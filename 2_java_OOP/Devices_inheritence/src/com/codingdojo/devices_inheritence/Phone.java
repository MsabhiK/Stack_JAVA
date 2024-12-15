package com.codingdojo.devices_inheritence;

public class Phone extends Devices {

	public void phoneCall() {
		//super.setBattery(getBattery());
		//super.battery=100;
		if(super.battery > 10) {
			System.out.println("YOU MADE A CALL!!! ");
			super.battery -= 5;
		} else {
			System.out.println("Battery critical you should charging your phone!!!");
		}
		displaylife();
	}
	
	public void playGame() {
		if(super.battery > 25) {
			System.out.println("YOU PLAY A GAME!!! ");
			super.battery -= 20;
		} else {
			System.out.println("Battery critical you should charging your phone!!!");
		}
		displaylife();
	}
	
	public void chargePhone() {
		if(super.battery < 51) {
			System.out.println("YOU CHARGE PHONE!!! ");
			super.battery += 50;
		} else {
			System.out.println("You don't need to charge your phone!!!");
		}
		displaylife();
	}

}
