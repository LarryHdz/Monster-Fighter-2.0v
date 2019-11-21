package monster;
import javax.swing.*;
public class PlayerMonster 
{
int max=4, min=1;

Dice x = new Dice();

private int hp = 20;
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

public void make(String n){
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

public void dbm(String name, String at,String de, String ag, String r, String x, String w, String l){
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

public void displayAll(){
	String stats ="Name: " + uname + "\n"+ "Attack: " + attack+ "\n" + "Defense: " + defense+ "\n"+"Agility: " + agility+ "\n"+ "Rank: "+ rank+ "\n" + "Xp: " + xp+ "\n" +"Win: " + win+ "\n" +"Lose: " + lose+ "\n";
	
	JOptionPane.showMessageDialog(null,stats);
}

public void name(String n){
	uname = n;
}

public void attack(){
	attack= x.roll();
}

public void defense(){
	defense = x.roll();
}

public void agility(){
	agility = x.roll();
}

//need to store into the data base

public int getAttack(){
	return attack;
}

public int getDefense(){
	return defense;
}

public int getAgility(){
	return agility;
}

public int getRank(){
	return rank;
}

public int getXp(){
	return xp;
}

public int getWin(){
	return win;
}

public int getLose(){
	return lose;
}

public String getName(){
	return uname;
}

public int getHp()
{
	return hp;
}

//was adding instead of subtracting was doing negative - negative

public boolean setHp(int h) 
{
	hp = hp -h;
	
	if(this.getHp() < 1)
	{
		return false;
	}
	else
	{
		return true;
	}
	
}

public void heal(int i) {
	hp = hp+i;
}

public void setWin(int w)
{
	win =win +w;
}

public void setLose(int l)
{
	lose = lose +l;
}

public void setRank()
{
	rank = xp/20;

}

public void setAttack(int a)
{
	attack =a;
}

public void setDefense(int a)
{
	defense =a;
}

public void setAgility(int a)
{
	agility =a;

}

public void setXp(int x)
{
	xp =x;

}








}

