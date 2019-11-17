package monster;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException 
	{

		/*System.out.println("Monster FIGHTER v2.0!!!!!!!");
		
		testing the Dice class;
		Dice x = new Dice();
		System.out.println(x.roll());

		String s = "Hello";
			
			s = Hashing.encryptThisString(s);
	
		System.out.println(s);*/
		
		Database db = new Database();
		PlayerMonster p1 = new PlayerMonster();
		
		
		
		//db.callPlayerMonster(p1);
		db.makeMonster(p1);
		//p1.displayAll();
		
		PlayerMonster p2 = new PlayerMonster();
		db.callAdversaryMonster(p1, p2);
		p2.displayAll();
		
	}

}
