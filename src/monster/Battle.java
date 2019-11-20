package monster;
import javax.swing.*;
public class Battle 
{
	PlayerMonster p1;
	PlayerMonster p2;
	
	boolean pfirst;
	boolean item;
	
	public Battle(PlayerMonster player, PlayerMonster adversary)
	{
		
			p1 = player;
			p2 = adversary;
		
		if(player.getAgility() > adversary.getAgility())
		{
			pfirst = true;
		}
		else
		{
			pfirst = false;
		}
		
	}
	
	//false =  player win
	public boolean playerAttack()
	{
		int dmg = p1.getAttack()/2 - p2.getDefense();
		return p2.setHp(dmg);
			
	}
	
	//false = player lose
	public boolean monsterAttack()
	{
		int dmg = p2.getAttack() -p1.getDefense();
		return p1.setHp(dmg);
	}

	public void defend()
	{
		int chance = (int) ((Math.random() * ((1 - 0) + 1)) + 0);
		
		if(chance > 0)
		{
			if(p2.getAttack() < p1.getDefense()) {
			int dmg = p2.getAttack() - p1.getDefense();
			 p1.setHp(dmg);
			}	
		}
	}

	public void generateItem()
	{
		int chance = (int) ((Math.random() * ((100 - 1) + 1)) + 1);
		
		if(chance <= 5)
		{
			item = true;
		}
		else
		{
			item = false;
		}
		
		
	}
	
	public boolean getItem()
	{
		return item;
	}
	
	public void useItem()
	{
			 p1.setHp(-5);
			 
			 item =false;
	}
	
	public void rank()
	{
		int r = p1.getRank();
		p1.setRank();
		if(p1.getRank() > r)
		{
			p1.displayAll();
			String option = JOptionPane.showInputDialog("You leveled up!\n Add +1 to any stat\n 1.Attack " + p1.getAttack() + "\n 2.Defense " + p1.getDefense()+ "\n 3.Agility " + p1.getDefense() + "\n");
			
			if(option == "1")
			{
				p1.setAttack(p1.getAttack()+1);
			}
			else if(option == "2")
			{
				p1.setDefense(p1.getDefense()+1);
			}
			else
			{
				p1.setAgility(p1.getAgility()+1);
				
			}
			
		}
		
		
	}
	
	public void xp()
	{
		String message =  "Won " + p1.getHp() + " xp";
		JOptionPane.showMessageDialog(null, message);
		
		p1.setXp(p1.getXp()+ p1.getHp());
	}
	
	
	
}
