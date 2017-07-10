package it.polimi.ingsw.GC_04.client.view.gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.polimi.ingsw.GC_04.server.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.server.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.server.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.server.model.card.VentureCard;


public class GameBoardGUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3719421921069872238L;
//	private ViewGUI viewGUI;
	private StateOfTheGameGUI state;
	private TowerButtons towerButtons;
	String input = new String();
	
	private Color colorC;
	private Color colorV;
	
	private JPanel panel;
	private JLabel gameBoard;
	private JLabel punchBoard;
	private JLabel personalTile;
	private JLabel slotVentureCards;
	private JLabel slotCharacterCards;
	
	private JButton[] territoryButtons; 
	private JButton[] characterButtons; 
	private JButton[] buildingButtons; 
	private JButton[] ventureButtons;
	
	private JButton[] pBoardTerritory;
	private JButton[] pBoardCharacter; 
	private JButton[] pBoardVenture; 
	private JButton[] pBoardBuilding;  
	
	private JButton[] excommunicationTiles;
	
	private JButton[] leaderCards;
	
	TextField numberOfCoins;
	TextField numberOfWoods;
	TextField numberOfStones;
	TextField numberOfServants;
	TextField blackDiceValue;
	TextField whiteDiceValue;
	TextField orangeDiceValue;
	
	private  JButton bT16; 
	 
	private JButton bT17;
	private JButton bT18;
	private JButton bT19;
	private JButton bT20;
	private JButton bT21;
	private JButton bT22;
	private JButton bT23;
	private JButton bT24;
	private JButton bT25;
	private JButton pBoard2;
	private JButton pBoard3;
	private JButton pBoard4;


	private Clip clip;
	private Dimension dimension;

	
	public GameBoardGUI() throws IOException {
		
		java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		
		setExtendedState(MAXIMIZED_BOTH);
		
		this.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage				//to change the icon in the frame
				(this.getClass().getResource("/immagini/leaders_b_c_00.jpg")));
		setTitle("Lorenzo il Magnifico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dimension = new Dimension(1358, 720);
		setSize(dimension);
		setLayout(new BorderLayout());
		setPreferredSize(getSize(dimension));
		setResizable(true);
		
		ImageIcon gameBoardImage = new ImageIcon(getClass().getResource("/immagini/gameboardRid.png"));	
		Image img = gameBoardImage.getImage();
		Image newimg = img.getScaledInstance(500, 700, Image.SCALE_DEFAULT);
		
		gameBoardImage = new ImageIcon(newimg);
		gameBoard = new JLabel(gameBoardImage);
		gameBoard.setIcon(gameBoardImage);
		pBoard2 = new JButton(" Player2");
		pBoard3 = new JButton(" Player3");
		pBoard4 = new JButton(" Player4");

		ImageIcon punchBoardImage = new ImageIcon(getClass().getResource("/immagini/punchboard_f_c_03.jpg"));
		punchBoard = new JLabel(punchBoardImage);
		punchBoard.setIcon(punchBoardImage);
		
		ImageIcon personalTileImage = new ImageIcon(getClass().getResource("/ExcommunicationTiles/personalbonustile_2.png"));
		personalTile = new JLabel(personalTileImage);
		personalTile.setIcon(personalTileImage);
		
		ImageIcon slotVentureCardsImage = new ImageIcon(getClass().getResource("/immagini/venturePBoard.jpg"));
		slotVentureCards = new JLabel(slotVentureCardsImage);
		slotVentureCards.setIcon(slotVentureCardsImage);
		
		ImageIcon slotCharacterCardsImage = new ImageIcon(getClass().getResource("/immagini/characterPBoard.jpg"));
		slotCharacterCards = new JLabel(slotCharacterCardsImage);
		slotCharacterCards.setIcon(slotCharacterCardsImage);
		
		JButton bT0 = new JButton();		
		JButton bT1 = new JButton();		
		JButton bT2 = new JButton();		
		JButton bT3 = new JButton();
		territoryButtons = new JButton[4];
		territoryButtons[0] = bT0;
		territoryButtons[1] = bT1;
		territoryButtons[2] = bT2;
		territoryButtons[3] = bT3;
		
		JButton bT4 = new JButton();
		JButton bT5 = new JButton();
		JButton bT6 = new JButton();
		JButton bT7 = new JButton();
		characterButtons = new JButton[4];
		characterButtons[0] = bT4;
		characterButtons[1] = bT5;
		characterButtons[2] = bT6;
		characterButtons[3] = bT7;
		
		
		JButton bT8 = new JButton();
		JButton bT9 = new JButton();
		JButton bT10 = new JButton();
		JButton bT11 = new JButton();
		buildingButtons = new JButton[4]; 
		buildingButtons[0] = bT8;
		buildingButtons[1] = bT9;
		buildingButtons[2] = bT10;
		buildingButtons[3] = bT11;
		

		JButton bT12 = new JButton();
		JButton bT13 = new JButton();
		JButton bT14 = new JButton();
		JButton bT15 = new JButton();
		ventureButtons = new JButton[4];
		ventureButtons[0] = bT12;
		ventureButtons[1] = bT13;
		ventureButtons[2] = bT14;
		ventureButtons[3] = bT15;
		
		
		
		JButton tB1 = new JButton();  //TerritoryCardSlot for player1
		JButton tB2 = new JButton();
		JButton tB3 = new JButton();
		JButton tB4 = new JButton();
		JButton tB5 = new JButton();
		JButton tB6 = new JButton();
		pBoardTerritory = new JButton[6];
		pBoardTerritory[0] = tB1;
		pBoardTerritory[1] = tB2;
		pBoardTerritory[2] = tB3;
		pBoardTerritory[3] = tB4;
		pBoardTerritory[4] = tB5;
		pBoardTerritory[5] = tB6;
		
		
		JButton cB1 = new JButton();  //CharacterCardSlot for player1
		JButton cB2 = new JButton();
		JButton cB3 = new JButton();
		JButton cB4 = new JButton();
		JButton cB5 = new JButton();
		JButton cB6 = new JButton();
		pBoardCharacter = new JButton[6];
		pBoardCharacter[0] = cB1;
		pBoardCharacter[1] = cB2;
		pBoardCharacter[2] = cB3;
		pBoardCharacter[3] = cB4;
		pBoardCharacter[4] = cB5;
		pBoardCharacter[5] = cB6;
		
		JButton bB1 = new JButton();  //BuildingCardSlot for player1
		JButton bB2 = new JButton();
		JButton bB3 = new JButton();
		JButton bB4 = new JButton();
		JButton bB5 = new JButton();
		JButton bB6 = new JButton();
		pBoardBuilding = new JButton[6];
		pBoardBuilding[0] = bB1;
		pBoardBuilding[1] = bB2;
		pBoardBuilding[2] = bB3;
		pBoardBuilding[3] = bB4;
		pBoardBuilding[4] = bB5;
		pBoardBuilding[5] = bB6;
		
		
		JButton vB1 = new JButton(); //VentureCardSlor for player1
		JButton vB2 = new JButton();
		JButton vB3 = new JButton();
		JButton vB4 = new JButton();
		JButton vB5 = new JButton();
		JButton vB6 = new JButton();
		pBoardVenture = new JButton[6];
		pBoardVenture[0] = vB1;
		pBoardVenture[1] = vB2;
		pBoardVenture[2] = vB3;
		pBoardVenture[3] = vB4;
		pBoardVenture[4] = vB5;
		pBoardVenture[5] = vB6;
		
		
		
		JButton leaderCard1P1 = new JButton();
		JButton leaderCard2P1 = new JButton();
		JButton leaderCard3P1 = new JButton();
		JButton leaderCard4P1 = new JButton();
		JButton leaderCard5P1 = new JButton();
		leaderCards = new JButton[5];
		leaderCards[0] = leaderCard1P1;
		leaderCards[1] = leaderCard2P1;
		leaderCards[2] = leaderCard3P1;
		leaderCards[3] = leaderCard4P1;
		leaderCards[4] = leaderCard5P1;
		
		
		
		excommunicationTiles = new JButton[3];
		JButton excommTile1 = new JButton(); //this is the button of the first excommunicationCard
		JButton excommTile2 = new JButton();
		JButton excommTile3 = new JButton();
		excommunicationTiles[0] = excommTile1;
		excommunicationTiles[1] = excommTile2;
		excommunicationTiles[2] = excommTile3;
		
		
		excommTile1.setBorder(null);
		excommTile2.setBorder(null);
		excommTile3.setBorder(null);
		gameBoard.add(excommTile1); 
		gameBoard.add(excommTile2);
		gameBoard.add(excommTile3);
		
		numberOfCoins = new TextField();
		numberOfStones = new TextField();
		numberOfWoods = new TextField();
		numberOfServants = new TextField();
		
		blackDiceValue = new TextField();
		whiteDiceValue = new TextField();
		orangeDiceValue = new TextField();
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.orange);
		
		getContentPane().add(panel);
		
		gameBoard.setBounds(5,5, 500, 700);
		punchBoard.setBounds(550,50,500,352);
		personalTile.setBounds(510, 50,50,352);
		slotVentureCards.setBounds(500, 405, 580, 110);
		slotCharacterCards.setBounds(500, 515, 580, 110);
		
		panel.add(gameBoard);
		panel.add(punchBoard);
		panel.add(personalTile);
		
		Image img1 = punchBoardImage.getImage();
		Image newimg1 = img.getScaledInstance(200, 300, Image.SCALE_DEFAULT);
		punchBoardImage = new ImageIcon(newimg1);
		
		
		
		
		bT16 = new JButton("Council Palace");
		bT17 = new JButton("Run");
		bT18 = new JButton("Take");
		bT19 = new JButton("Run");
		bT20 = new JButton("Take");
		bT21 = new JButton("Take");
		bT22 = new JButton("Take");
		
		
		for (int i = 0; i < territoryButtons.length; i++) {
			territoryButtons[i].setContentAreaFilled(false);
			gameBoard.add(territoryButtons[i]);
			territoryButtons[i].setBorder(null);
		}
		for (int i = 0; i < characterButtons.length; i++) {
			characterButtons[i].setContentAreaFilled(false);
			gameBoard.add(characterButtons[i]);
			characterButtons[i].setBorder(null);
		}
		for (int i = 0; i < buildingButtons.length; i++) {
			buildingButtons[i].setContentAreaFilled(false);
			gameBoard.add(buildingButtons[i]);
			buildingButtons[i].setBorder(null);
		}
		for (int i = 0; i < ventureButtons.length; i++) {
			ventureButtons[i].setContentAreaFilled(false);
			gameBoard.add(ventureButtons[i]);
			ventureButtons[i].setBorder(null);
		}
		
		bT16.setContentAreaFilled(false);
		bT17.setContentAreaFilled(true);
		bT18.setContentAreaFilled(true);
		bT19.setContentAreaFilled(true);
		bT20.setContentAreaFilled(true);
		bT21.setContentAreaFilled(true);
		bT22.setContentAreaFilled(true);
		
		for (int i = 0; i < pBoardTerritory.length; i++) {
			pBoardTerritory[i].setContentAreaFilled(false);
			punchBoard.add(pBoardTerritory[i]);
		}
		for (int i = 0; i < pBoardCharacter.length; i++) {
			pBoardCharacter[i].setContentAreaFilled(false);
			slotCharacterCards.add(pBoardCharacter[i]);
		}
		for (int i = 0; i < pBoardBuilding.length; i++) {
			pBoardBuilding[i].setContentAreaFilled(false);
			punchBoard.add(pBoardBuilding[i]);
		}
		for (int i = 0; i < pBoardVenture.length; i++) {
			pBoardVenture[i].setContentAreaFilled(false);
			slotVentureCards.add(pBoardVenture[i]);
		}
		
		
		//bT1.setBounds(35, 50,80 ,90 );
		bT0.setBounds(35, 300, 80, 90);
		bT1.setBounds(35, 210, 80, 90);
		bT2.setBounds(35, 120, 80, 90);
		bT3.setBounds(35, 30,80 ,90 );
		bT4.setBounds(120, 300, 80, 90);
		bT5.setBounds(120, 210, 80, 90);
		bT6.setBounds(120, 120, 80, 90);
		bT7.setBounds(120, 30, 80, 90);
		bT8.setBounds(220, 300, 60, 90);
		bT9.setBounds(220, 210, 60, 90);
		bT10.setBounds(220, 120, 60, 90);
		bT11.setBounds(220, 30, 60, 90);
		bT12.setBounds(310, 300, 60, 90);
		bT13.setBounds(310, 210, 60, 90);
		bT14.setBounds(310, 120, 60, 90);   //(100, 150, 300, 500) queste dimensioni mi servivano solo per ingrandire l'immagine(poi li dovrò cancellare)
		bT15.setBounds(310, 30, 60, 90);
		bT16.setBounds(240,400,120,30);
		bT17.setBounds(80, 590, 65, 20);
		bT18.setBounds(340, 595, 35, 20);
		bT19.setBounds(70, 645, 65, 20);
		bT20.setBounds(300, 585, 35,20);
		bT21.setBounds(260, 585, 35, 20);
		bT22.setBounds(375, 625, 35, 20);
		tB1.setBounds(5, 150, 80, 110);
		tB2.setBounds(85, 150, 80, 110);
		tB3.setBounds(165, 150, 80, 110);
		tB4.setBounds(245, 150, 80, 110);
		tB5.setBounds(325, 150, 80, 110);
		tB6.setBounds(405, 150, 80, 110);
		cB1.setBounds(555, 405, 80, 110);
		cB2.setBounds(630, 405, 80, 110);
		cB3.setBounds(710, 405, 80, 110);
		cB4.setBounds(790, 405, 80, 110);
		cB5.setBounds(870, 405, 80, 110);
		cB6.setBounds(945, 405, 80, 110);
		bB1.setBounds(5, 10, 80, 110);
		bB2.setBounds(85, 10, 80, 110);		
		bB3.setBounds(165, 10, 80, 110);		
		bB4.setBounds(245, 10, 80, 110);		
		bB5.setBounds(325, 10, 80, 110);		
		bB6.setBounds(405, 10, 80, 110);		
		vB1.setBounds(560, 515, 75, 110);
		vB2.setBounds(630, 515, 75, 110);
		vB3.setBounds(710, 515, 75, 110);
		vB4.setBounds(790, 515, 75, 110);
		vB5.setBounds(870, 515, 75, 110);
		vB6.setBounds(950, 515, 75, 110);
		leaderCard1P1.setBounds(1065,40,130,200);
		leaderCard2P1.setBounds(1195,40,130,200);
		leaderCard3P1.setBounds(1065,240,130,200);
		leaderCard4P1.setBounds(1195,240,130,200);
		leaderCard5P1.setBounds(1135,440,130,200);
		
		excommTile1.setBounds(110, 430, 26, 45);
		excommTile2.setBounds(145, 430, 26, 45);
		excommTile3.setBounds(180, 430, 26, 45);
		
		gameBoard.add(bT16);
		gameBoard.add(bT17);
		gameBoard.add(bT18);
		gameBoard.add(bT19);		
		gameBoard.add(bT20);
		gameBoard.add(bT21);
		gameBoard.add(bT22);
		punchBoard.add(tB1);
		
		bT16.setBorder(null);
		bT18.setBorder(null);
		bT20.setBorder(null);
		bT21.setBorder(null);
		bT22.setBorder(null);
		
		panel.add(pBoard2);
		panel.add(pBoard3);
		panel.add(pBoard4);
		pBoard2.setBounds(520, 10, 80, 35);
		pBoard3.setBounds(620, 10, 80, 35);
		pBoard4.setBounds(720, 10, 80, 35);
		
		panel.add(cB1);
		panel.add(cB2);
		panel.add(cB3);
		panel.add(cB4);
		panel.add(cB5);
		panel.add(cB6);
		panel.add(slotVentureCards);
		
		panel.add(vB1);
		panel.add(vB2);
		panel.add(vB3);
		panel.add(vB4);
		panel.add(vB5);
		panel.add(vB6);
		panel.add(slotCharacterCards);
		
		panel.add(leaderCard1P1);
		panel.add(leaderCard2P1);
		panel.add(leaderCard3P1);
		panel.add(leaderCard4P1);
		panel.add(leaderCard5P1);
		
		
		
		bT0.addActionListener(this);
		bT1.addActionListener(this);
		bT2.addActionListener(this);
		bT3.addActionListener(this);
		bT4.addActionListener(this);
		bT5.addActionListener(this);
		bT6.addActionListener(this);
		bT7.addActionListener(this);
		bT8.addActionListener(this);
		bT9.addActionListener(this);
		bT10.addActionListener(this);
		bT11.addActionListener(this);
		bT12.addActionListener(this);
		bT13.addActionListener(this);
		bT14.addActionListener(this);
		bT15.addActionListener(this);
		bT16.addActionListener(this);
		bT17.addActionListener(this);
		bT20.addActionListener(this);
		bT21.addActionListener(this);
		bT22.addActionListener(this);
		pBoard2.addActionListener(this);
		pBoard3.addActionListener(this);
		pBoard4.addActionListener(this);
		
		//bT20.setToolTipText("You have x Servants"); serve per mettere la scritta che appare avvicinando il cursore
		
		
		
		AudioInputStream audioIn = null;
		
		try {
			audioIn = AudioSystem.getAudioInputStream(GameBoardGUI.class.getResource("/immagini/Crash Bandicoot Medieval Music.wav"));
			
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
		Clip clip = null;
		try {
			clip = AudioSystem.getClip();
			
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		try {
			clip.open(audioIn);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		clip.start();
		
		colorC = new Color(0, 140, 255); 
		colorV = new Color(170,0 ,220 );
		
		
		
		
		pack();
		setVisible(true);
		}

		
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String input = "";
		for(int i = 0; i < territoryButtons.length; i++) {
			if (e.getSource()==territoryButtons[i]) {
				input += "TOWER 1 "+(i+1);
				towerButtons = new TowerButtons(this,"Do you want to take this card", new ImageIcon(getClass().getResource(state.getBigTower(new TerritoryCard())[i])));
				
			}
		}
		for(int i = 0; i < characterButtons.length; i++) {
			if (e.getSource()==characterButtons[i]) {
				input += "TOWER 2 "+(i+1);
				towerButtons = new TowerButtons(this,"Do you want to take this card", new ImageIcon(getClass().getResource(state.getBigTower(new CharacterCard())[i])));
				
			}
		}
		
		for(int i = 0; i < buildingButtons.length; i++) {
			
			if (e.getSource()==buildingButtons[i]) {
				input +="TOWER 3 "+(i+1);
				towerButtons = new TowerButtons(this,"Do you want to take this card", new ImageIcon(getClass().getResource(state.getBigTower(new BuildingCard())[i])));
				
			}
		}
		for(int i = 0; i < ventureButtons.length; i++) {
			if (e.getSource()==ventureButtons[i]) {
				input +="TOWER 4 "+(i+1);
					towerButtons = new TowerButtons(this,"Do you want to take this card", new ImageIcon(getClass().getResource(state.getBigTower(new VentureCard())[i])));
				
			}
		}
			

		if (e.getSource()== towerButtons.getDecline())
			input="";
		

			
			
			
			
		
	}
	
	
	


	public void setState(StateOfTheGame stateOfTheGame) {
		
		state=stateOfTheGame.getStateGUI();
	
		for (int i = 0; i < territoryButtons.length; i++) {
			ImageIcon imageIcon = new ImageIcon(getClass().getResource(state.getTower(new TerritoryCard())[i]));
			territoryButtons[i].setIcon(imageIcon);	
		}
		for (int i = 0; i < characterButtons.length; i++) {
			ImageIcon imageIcon = new ImageIcon(getClass().getResource(state.getTower(new CharacterCard())[i]));
			characterButtons[i].setIcon(imageIcon);	
		}
		for (int i = 0; i < buildingButtons.length; i++) {
			ImageIcon imageIcon = new ImageIcon(getClass().getResource(state.getTower(new BuildingCard())[i]));
			buildingButtons[i].setIcon(imageIcon);	
		}
		for (int i = 0; i < ventureButtons.length; i++) {
			ImageIcon imageIcon = new ImageIcon(getClass().getResource(state.getTower(new VentureCard())[i]));
			ventureButtons[i].setIcon(imageIcon);	
		}
		for (int i = 0; i < state.getPersonalBoard(new TerritoryCard()).length; i++) {
			ImageIcon imageIcon = new ImageIcon(getClass().getResource(state.getPersonalBoard(new TerritoryCard())[i]));
			pBoardTerritory[i].setIcon(imageIcon);
		}
		for (int i = 0; i < state.getPersonalBoard(new CharacterCard()).length; i++) {
			ImageIcon imageIcon = new ImageIcon(getClass().getResource(state.getPersonalBoard(new CharacterCard())[i]));
			pBoardCharacter[i].setIcon(imageIcon);
		}
		for (int i = 0; i < state.getPersonalBoard(new BuildingCard()).length; i++) {
			ImageIcon imageIcon = new ImageIcon(getClass().getResource(state.getPersonalBoard(new BuildingCard())[i]));
			pBoardBuilding[i].setIcon(imageIcon);
		}
		for (int i = 0; i < state.getPersonalBoard(new VentureCard()).length; i++) {
			ImageIcon imageIcon = new ImageIcon(getClass().getResource(state.getPersonalBoard(new VentureCard())[i]));
			pBoardCharacter[i].setIcon(imageIcon);
		}
		for (int i = 0; i < state.getMainLeaderCards().length; i++) {
			ImageIcon imageIcon = new ImageIcon(getClass().getResource(state.getMainLeaderCards()[i]));
			leaderCards[i].setIcon(imageIcon);
		}
		for (int i = 0; i < excommunicationTiles.length; i++) {
			ImageIcon imageIcon = new ImageIcon(getClass().getResource(state.getExcommunicationTiles()[i]));
			excommunicationTiles[i].setIcon(imageIcon);
		}
		numberOfCoins = new TextField(state.getMainResources()[0]);
		punchBoard.add(numberOfCoins);
		numberOfCoins.setBounds(40, 325, 25, 25);
		numberOfCoins.setBackground(Color.white);
		numberOfCoins.setVisible(true);
		
		numberOfWoods = new TextField(state.getMainResources()[1]);
		punchBoard.add(numberOfWoods);
		numberOfWoods.setBounds(110, 325, 25, 25);
		numberOfWoods.setBackground(Color.white);
		numberOfWoods.setVisible(true);
		
		numberOfStones = new TextField(state.getMainResources()[2]);
		punchBoard.add(numberOfStones);
		numberOfStones.setBounds(185, 325, 25, 25);
		numberOfStones.setBackground(Color.white);
		numberOfStones.setVisible(true);
		
		numberOfServants = new TextField(state.getMainResources()[3]);
		punchBoard.add(numberOfServants);
		numberOfServants.setBounds(270, 325, 25, 25);
		numberOfServants.setBackground(Color.white);
		numberOfServants.setVisible(true);
		
		blackDiceValue = new TextField(state.getDices()[0]);
		gameBoard.add(blackDiceValue);
		blackDiceValue.setBounds(255, 650, 25, 25);
		blackDiceValue.setBackground(Color.white);
		blackDiceValue.setVisible(true);
		
		whiteDiceValue = new TextField(state.getDices()[1]);
		gameBoard.add(whiteDiceValue);
		whiteDiceValue.setBounds(300, 650, 25, 25);
		whiteDiceValue.setBackground(Color.white);
		whiteDiceValue.setVisible(true);
		
		orangeDiceValue = new TextField(state.getDices()[2]);
		gameBoard.add(orangeDiceValue);
		orangeDiceValue.setBounds(345, 650, 25, 25);
		orangeDiceValue.setBackground(Color.white);
		orangeDiceValue.setVisible(true);
		
		
	}

			
	}		
	


