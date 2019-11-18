package monster;

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
	
	
	
	
	
	
	
	public boolean playerAttack()
	{
		int dmg = p1.getAttack()/2 -p2.getDefense();
		return p2.setHp(dmg);
			
	}
	
	public boolean monsterAttack()
	{
		int dmg = p2.getAttack()/2 -p1.getDefense();
		return p1.setHp(dmg);
	}
	
	public boolean defend()
	{
		int chance = (int) ((Math.random() * ((1 - 0) + 1)) + 0);
		
		if( chance > 0)
		{
			int dmg = p2.getAttack()/2 - p1.getDefense();
			return p1.setHp(dmg);
		}
		else
		{
			return true;
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
	
	
	
}
