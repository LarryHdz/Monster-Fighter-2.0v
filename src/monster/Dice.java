package monster;

import java.util.Random;

public class Dice {
	//Dice working on by Larry
	Dice() {
	}
	
	
	int roll() {
		Random x = new Random();
		return x.nextInt((5-1)+1)+1;
	}

}
