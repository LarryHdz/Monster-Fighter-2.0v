package monster;

import java.util.Random;

public class Dice {
	//Dice that rolls a random number 1 - 5
	Dice() {
	}
	
	
	int roll() {
		Random x = new Random();
		return x.nextInt((5-1)+1)+1;
	}

}
