package monster;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.*;


public class GUI 
{
	
	JFrame window;
	Container con;
	Database db = new Database();
	PlayerMonster x = new PlayerMonster();
	PlayerMonster y = new PlayerMonster();
	Battle fight = new Battle(x,y);
	
	
	JPanel TnameP, SbuttonP, MgameP, CbuttonP, playerPanel;
	JLabel TnameL, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	JButton newMonster, loginMonster, choice1, choice2, choice3, choice4;
	
	Font titleFont = new Font("Cooper", Font.PLAIN, 40);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	
	JTextArea MtextA; //allows for text
	
	nMonster making = new nMonster();
	lMonster login = new lMonster();
	ChoiceHandler choicehandler = new ChoiceHandler();
	
	Dice use = new Dice();
	
	int playerHP, monsterHP;
	int tmpx, tmpy, tmpw, tmph;
	int smpx, smpy, smpw, smph;
	int currentScreenWidth, currentScreenHight;
	String weapon, position;
	
	
	public GUI(){
		currentScreenWidth = 800;
		currentScreenHight = 600;
		tmpx = (int)Math.round(currentScreenWidth*0.125);
		tmpy = (int)Math.round(currentScreenHight*0.166);
		tmpw = (int)Math.round(currentScreenWidth*0.75);
		tmph = (int)Math.round(currentScreenWidth*0.25);
		window = new JFrame();
		window.setSize(currentScreenWidth, currentScreenHight);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - window.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - window.getHeight()) / 2);
		window.setLocation(x, y);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		
		con = window.getContentPane();
		
		
		TnameP = new JPanel();
		TnameP.setBounds(tmpx, tmpy, tmpw, tmph); // starts on(x,y), then given a (width, height)
		TnameP.setBackground(Color.black); // gives color to the title name
		
		TnameL = new JLabel("Monster Fighter v2.0!");
		TnameL.setForeground(Color.white); // font color blue look nice
		TnameL.setFont(titleFont);
		
		
		smpx = (int)Math.round(currentScreenWidth*0.375);
		smpy = (int)Math.round(currentScreenHight*0.666);
		smpw = (int)Math.round(currentScreenWidth*0.75);
		smph = (int)Math.round(currentScreenWidth*0.25);
		
		SbuttonP = new JPanel();
		SbuttonP.setBounds(smpx, smpy, smpw, smph); // starts on(x,y), then given a (width, height)
		SbuttonP.setBackground(Color.black);
		SbuttonP.setLayout(new GridLayout(2,1));
		
		newMonster = new JButton("New Monster!");
		newMonster.setBackground(Color.white);
		newMonster.setForeground(Color.black);
		newMonster.setFont(normalFont);
		newMonster.addActionListener(making); //gives the button an action when clicked
		newMonster.setFocusPainted(false);
		
		loginMonster = new JButton("Login!");
		loginMonster.setBackground(Color.white);
		loginMonster.setForeground(Color.black);
		loginMonster.setFont(normalFont);
		
		loginMonster.addActionListener(login); //gives the button an action when clicked
		loginMonster.setFocusPainted(false);
		
		TnameP.add(TnameL);
		SbuttonP.add(newMonster);
		SbuttonP.add(loginMonster);
		
		con.add(TnameP);
		con.add(SbuttonP);

	}
	
	public class nMonster implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			try {
				if(db.makeMonster(x)) {
					createGameScreen();
				}
				else {
					//new GUI();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//Button actions
	public class lMonster implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			try {
				if(db.callPlayerMonster(x)) {
					createGameScreen();
				}
				else {
					//GUI();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void createGameScreen() {
		//Clear the Panels!!!!!!!
		TnameP.setVisible(false);
		SbuttonP.setVisible(false);
		
		MgameP = new JPanel();
		MgameP.setBounds(100, 100, 600, 250);
		MgameP.setBackground(Color.white); // Debugging set to black in full game
		
		con.add(MgameP);
		
		MtextA = new JTextArea(); // add the text here!!!
		
		MtextA.setBounds(100, 100, 600, 250);
		MtextA.setBackground(Color.white);
		MtextA.setForeground(Color.black);
		MtextA.setFont(normalFont);
		MtextA.setLineWrap(true);// moves words to lower lines if too long
		
		MgameP.add(MtextA);
		
		/////////////////////////////////////////
		// Actions
		
		CbuttonP = new JPanel();
		CbuttonP.setBounds(100, 350, 600, 100);
		CbuttonP.setBackground(Color.darkGray);
		CbuttonP.setLayout(new GridLayout(1,4)); //gives the layout to x rows and y columns etc;
		con.add(CbuttonP);

		choice1 = new JButton("Attack!");
		choice1.setBackground(Color.darkGray);
		choice1.setForeground(Color.black);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choicehandler); //directs the click
		choice1.setActionCommand("1");
		CbuttonP.add(choice1);

		choice2 = new JButton("Defend");
		choice2.setBackground(Color.darkGray);
		choice2.setForeground(Color.black);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choicehandler);
		choice2.setActionCommand("2");
		CbuttonP.add(choice2);

		choice3 = new JButton("Item");
		choice3.setBackground(Color.darkGray);
		choice3.setForeground(Color.black);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choicehandler);
		choice3.setActionCommand("3");
		CbuttonP.add(choice3);

		choice4 = new JButton("Run!");
		choice4.setBackground(Color.darkGray);
		choice4.setForeground(Color.black);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choicehandler);
		choice4.setActionCommand("4");
		CbuttonP.add(choice4);
		
		//////////////////////////////////////////
		
		//health and items
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		con.add(playerPanel);
		
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		
		weaponLabel = new JLabel("Items:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);

	
		playerSetup();
		//battlefield();
		
	}
	
	public void playerSetup(){
		//playerHP = 15;
		monsterHP = 20;
		weapon = "Medkit";
		weaponLabelName.setText(weapon);
	
		int c = x.getHp();
		hpLabelNumber.setText("" + c);
		
		//MtextA.enableInputMethods(false);
		MtextA.setText("player hp "+ c);
		
		//townGate();
		battlefield();
	}
	
	public void battlefield() {
		try {
			db.callAdversaryMonster(x,y);
			//y.displayAll();
			encounters();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void encounters() {

		//playerSetup();
		MtextA.setText("You go first!");
		
		if(fight.pfirst) {
			
			MtextA.setText("You go first!");
			//CbuttonP.setVisible(true);
			
		
		}
		 else {
			MtextA.setText("Monster goes first!");
			
			if(fight.monsterAttack()) {
				
				MtextA.setText("Monster attacks!");
				
				int temp = x.getHp();
				
				hpLabelNumber.setText(" "+temp);
				
				//CbuttonP.setVisible(false);
				
				fight.pfirst = true;
	
			}
			
			else {
				MtextA.setText("You Lost!");
				//update;
			}
		}
		
		
}
	
	/*public void playerSetup() {
		/*try {
			db.callPlayerMonster(x);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		//SbuttonP.setVisible(true); 
		//might have to clear the screen
		playerHP = x.getHp();
		
		hpLabelNumber.setText(" "+ playerHP);
		
		if(fight.getItem()) {
			weapon = "Health Pack";
		}
		else {
			weapon = " ";
		}
		weaponLabel.setText(weapon);
		
	} */
	

	public class ChoiceHandler implements ActionListener{
		//1, attack hit; 2, blocked!; 3, Item; 4, Run Away!;
		
		public void actionPerformed(ActionEvent event) {
			
			String yourChoice = event.getActionCommand();
			
			if(yourChoice.equals("1")) {
				//roll number for attacking so "You hit for _ points!" useack();
				if(fight.playerAttack()) {
					MtextA.setText("The monster has " + y.getHp());
				}
				else {
					MtextA.setText("You Won!");
				}
				
			}
			else if(yourChoice.equals("2")) {
				//roll dice 1 out 2 to defend "You blocked!" usedef();
				fight.defend();
				MtextA.setText("You blocked!");
			}
			else if(yourChoice.equals("3")) {
				//roll dice out of 5 when you can use an item "You healed _ points!" useitem();
				
				if(fight.getItem()) {
					fight.useItem();
					MtextA.setText("You healed for 5 points!");
					
					//update players health
					hpLabelNumber.setText(" "+x.getHp());
					weaponLabelName.setText(" ");
					
				}
				else {
					MtextA.setText("You dont have an item!");
				}
			}
			
			else if(yourChoice.equals("4")) {
				//roll dice 1 out 2 to run "You ran away!"userun();
					int t = use.roll();
					if(t-1 < 2) {
						MtextA.setText("You ran!");
						//end game?
					}
					else {
						MtextA.setText("You triped!");
						//continue
					}
			}
			
			fight.pfirst = false;
			
			//encounters();
			
		}
	}
	

	public static void main(String[] args) {
		new GUI();
	}


}

/*BUTTONS add1
CbuttonP = new JPanel();
CbuttonP.setBounds(100, 350, 600, 100);
CbuttonP.setBackground(Color.darkGray);
CbuttonP.setLayout(new GridLayout(1,4)); //gives the layout to x rows and y columns etc;
con.add(CbuttonP);

choice1 = new JButton("Attack!");
choice1.setBackground(Color.darkGray);
choice1.setForeground(Color.black);
choice1.setFont(normalFont);
choice1.setFocusPainted(false);
choice1.addActionListener(choicehandler); //directs the click
choice1.setActionCommand("1");
CbuttonP.add(choice1);

choice2 = new JButton("Defend");
choice2.setBackground(Color.darkGray);
choice2.setForeground(Color.black);
choice2.setFont(normalFont);
choice2.setFocusPainted(false);
choice2.addActionListener(choicehandler);
choice2.setActionCommand("2");
CbuttonP.add(choice2);

choice3 = new JButton("Item");
choice3.setBackground(Color.darkGray);
choice3.setForeground(Color.black);
choice3.setFont(normalFont);
choice3.setFocusPainted(false);
choice3.addActionListener(choicehandler);
choice3.setActionCommand("3");
CbuttonP.add(choice3);

choice4 = new JButton("Run!");
choice4.setBackground(Color.darkGray);
choice4.setForeground(Color.black);
choice4.setFont(normalFont);
choice4.setFocusPainted(false);
choice4.addActionListener(choicehandler);
choice4.setActionCommand("4");
CbuttonP.add(choice4);

playerPanel = new JPanel();
playerPanel.setBounds(100, 15, 600, 50);
playerPanel.setBackground(Color.black);
playerPanel.setLayout(new GridLayout(1,4));
con.add(playerPanel);

hpLabel = new JLabel("HP:");
hpLabel.setFont(normalFont);
hpLabel.setForeground(Color.white);
playerPanel.add(hpLabel);

hpLabelNumber = new JLabel();
hpLabelNumber.setFont(normalFont);
hpLabelNumber.setForeground(Color.white);
playerPanel.add(hpLabelNumber);

//can change for something else? Item?
weaponLabel = new JLabel("Item:");
weaponLabel.setFont(normalFont);
weaponLabel.setForeground(Color.white);
playerPanel.add(weaponLabel);

weaponLabelName = new JLabel();
weaponLabelName.setFont(normalFont);
weaponLabelName.setForeground(Color.white);
playerPanel.add(weaponLabelName);*/



//add 2
/*playerPanel = new JPanel();
playerPanel.setBounds(100, 15, 600, 50);
playerPanel.setBackground(Color.black);
playerPanel.setLayout(new GridLayout(1,4));
con.add(playerPanel);

hpLabel = new JLabel("HP:");
hpLabel.setFont(normalFont);
hpLabel.setForeground(Color.white);
playerPanel.add(hpLabel);

hpLabelNumber = new JLabel();
hpLabelNumber.setFont(normalFont);
hpLabelNumber.setForeground(Color.white);
playerPanel.add(hpLabelNumber);

//can change for something else? Item?
weaponLabel = new JLabel("Item:");
weaponLabel.setFont(normalFont);
weaponLabel.setForeground(Color.white);
playerPanel.add(weaponLabel);

weaponLabelName = new JLabel();
weaponLabelName.setFont(normalFont);
weaponLabelName.setForeground(Color.white);
playerPanel.add(weaponLabelName);*/