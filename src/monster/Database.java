package monster;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Database 
{
	Connection con;
	
	Database()
	{
		String url = "jdbc:mysql://35.232.190.192:3306/db4?useSSL=false";
		
		 try {
			con = DriverManager.getConnection(url, "user4", "4782");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean callPlayerMonster(PlayerMonster m) throws SQLException{
		//Scanner s = new Scanner(System.in);
		//System.out.println("Please input monster name: ");
		String name = JOptionPane.showInputDialog("Please input monster name:");
		//= s.next();
		
		
		
		java.sql.Statement stmt = con.createStatement();
		String sqlStatement;
		ResultSet result;
		
		if(exists(name) == false){
			System.out.println("No monster found");
			
			//s.close();
			return false;
		}
		else{
			sqlStatement = "select * from Monsters where uname = " + "\"" + name + "\"";
			result = stmt.executeQuery(sqlStatement);
			
			//System.out.println("Monster found. Please input password: ");
			
			//player password
			String pword = JOptionPane.showInputDialog("Monster found. Please input password: ");
			
			//= s.next();
			//s.close();
			result.next();
			//password hash from database
			String dhash = result.getString(9);
			//turn password to hash
			String phash = Hashing.encryptThisString(pword);
			//System.out.println(phash);
			//System.out.println(dhash);
			
			//has match?
			if(phash.equals(dhash)){
				
				
m.dbm(result.getString(1), result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8));
				
				//System.out.println("Password Correct. Monster ready for battle!");
					JOptionPane.showMessageDialog(null,"Password Correct. Monster ready for battle!");
                m.displayAll();
				return true;
				
			}
			else{
				//System.out.println("Password Incorrect");
				JOptionPane.showMessageDialog(null,"Password Incorrect");
				return false;
				
				
			}
		}
	}

	public boolean callAdversaryMonster(PlayerMonster player, PlayerMonster adversary) throws SQLException{
		int holder = player.getRank()+5;
		
		System.out.println(player.getRank());
		java.sql.Statement stmt = con.createStatement();
		String sqlStatement ;
		ResultSet result;
		
		sqlStatement = "select count(*) from Monsters where rank between " + player.getRank() + " and " + holder ;
		result = stmt.executeQuery(sqlStatement);
		result.next();
		
		String r = result.getString(1); 
		
		int counts = Integer.parseInt(r);
		
		if(counts == 0){
			return false;
		}
		else{
			sqlStatement = "select * from Monsters where rank between " + player.getRank() + " and " + holder ;
			result = stmt.executeQuery(sqlStatement);
			result.next();
		
			int stop = (int) ((Math.random() * ((counts - 0) + 1)) + 0);
			for(int i = 0; i < stop; ++i)
			{
				result.next();
			}
			
			
	adversary.dbm(result.getString(1), result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8));
			
			
			return true;
		}	
	}
	
	public boolean makeMonster(PlayerMonster m) throws SQLException{
		java.sql.Statement stmt = con.createStatement();
		String sqlStatement ;
		//Scanner s = new Scanner(System.in);
		//System.out.println("Please input a new monster name: ");
		
		String name =JOptionPane.showInputDialog("Please input a new monster name: ");
		//= s.next();
		
		if(exists(name) == false)
		{
		
		
		m.make(name);
		
		//System.out.println("New monster is ready for battle!");
		JOptionPane.showMessageDialog(null, "New monster is ready for battle!");
		m.displayAll();
		
		//System.out.println("Please input a password for your monster");
		String pword = JOptionPane.showInputDialog("Please input a password for your monster");
		//= s.next();
		String phash = Hashing.encryptThisString(pword);
		
		
		
		sqlStatement = "insert into Monsters Values ("+ "\"" + m.getName() + "\"" +"," + m.getAttack() + ", " + m.getDefense() + ", " + m.getAgility() + ", " + m.getRank() + ", " + m.getXp() + ", " + m.getWin() + ", " + m.getLose() + ", "  + "\"" + phash + "\"" + ")";
		stmt.executeUpdate(sqlStatement); 
		//s.close();
		return true;
		}
		else{
			//System.out.println("Monster name is taken");
			JOptionPane.showMessageDialog(null, "Monster name is taken");
			//s.close();
			return false;
		}
	}
	
	public boolean exists(String name) throws SQLException {
		
		java.sql.Statement stmt = con.createStatement();
		String sqlStatement = "select Count(*) from Monsters where uname = " + "\"" + name + "\"";
		ResultSet result = stmt.executeQuery(sqlStatement); 
		
		result.next();
		
		String r = result.getString(1); 
		
		int exists = Integer.parseInt(r);
		
		if(exists == 0){
			return false;
		}
		else{
			return true;
		}
	}
	
	public void closedb() throws SQLException{
		con.close();
	}
	
	public void updateDB(PlayerMonster m) throws SQLException{
		java.sql.Statement stmt = con.createStatement();
		String sqlStatement ;
		
			sqlStatement = "UPDATE Monsters SET attack = " + m.getAttack() + ", defense = " + m.getDefense() + ", agility = " + m.getAgility() + ", rank = " + m.getRank() + ", xp = " + m.getXp() + ", win = " + m.getWin() + ", lose = " + m.getLose() + "WHERE uname =" + "\"" + m.getName() + "\"";
			
			stmt.executeUpdate(sqlStatement); 
		
	}
	
	
}
