package monster;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException 
	{
		Database db = new Database();
		PlayerMonster pl1 = new PlayerMonster();
		PlayerMonster pl2 = new PlayerMonster();
			db.callPlayerMonster(pl1);
			
			db.callAdversaryMonster(pl1,pl2);
			pl2.displayAll();
		
		
	}

}
