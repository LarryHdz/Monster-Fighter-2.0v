package monster;

public class PlayerMonster 
{
int max=4, min=1;

Dice x = new Dice();

private String uname;
private int attack;
private int defense;
private int agility;
private int rank;
private int xp;
private int win;
private int lose;
boolean newMon;


PlayerMonster()
{

}

public void make(String n)
{
	uname = n;
	
	this.attack();
	this.defense();
	this.agility();
	rank =0;
	xp =0;
	win = 0;
	lose =0;
	newMon = true;
}

public void dbm(String name, String at,String de, String ag, String r, String x, String w, String l)
{
	uname = name;
	
	attack = Integer.parseInt(at);
	defense = Integer.parseInt(de);
	agility = Integer.parseInt(ag);
	rank = Integer.parseInt(r);
	xp = Integer.parseInt(x);
	win = Integer.parseInt(w);
	lose = Integer.parseInt(l);
	newMon =false;
}

public void displayAll()
{
	System.out.println("Name: " + uname);
	System.out.println("Attack: " + attack);
	System.out.println("Defense: " + defense);
	System.out.println("Agility: " + agility);
	System.out.println("Rank: "+ rank);
	System.out.println("Xp: " + xp);
	System.out.println("Win: " + win);
	System.out.println("Lose: " + lose);
}


public void name(String n)
{
	uname = n;
}
public void attack()
{
	attack= x.roll();
}
public void defense()
{
	defense = x.roll();
}
public void agility()
{
	agility = x.roll();
}

//need to store into the data base

public int getAttack()
{
	return attack;
}

public int getDefense()
{
	return defense;
}

public int getAgility()
{
	return agility;
}


public int getRank()
{
	return rank;
}

public int getXp()
{
	return xp;
}

public int getWin()
{
	return win;
}

public int getLose()
{
	return lose;
}

public String getName()
{
	return uname;
}
}
