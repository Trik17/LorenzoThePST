package it.polimi.ingsw.GC_04.client.view;


import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import it.polimi.ingsw.GC_04.server.model.resource.MilitaryPoints;




public class GameBoardGUI extends JFrame implements ActionListener {
	private Color colorC;
	private Color colorV;
	private ImageIcon gameboard;
	private ImageIcon punchboard;
	private ImageIcon personalTile;
	private ImageIcon excommunicationCard1;
	private ImageIcon excommunicationCard2;
	private ImageIcon excommunicationCard3;
	private ImageIcon slotVentureCards;
	private ImageIcon slotCharacterCards;
	private ImageIcon leaderCardBack;
	private ImageIcon Card1;
	private ImageIcon Card5;
	private ImageIcon[] charachterCards;
	private ImageIcon[] buldingCards;
	private ImageIcon[] ventureCards;
	private ImageIcon[] territoryCards;
	private JPanel panel;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private  JButton bT0; 
	private  JButton bT1; 
	private  JButton bT2; 
	private  JButton bT3; 
	private  JButton bT4; 
	private  JButton bT5; 
	private  JButton bT6; 
	private  JButton bT7; 
	private  JButton bT8; 
	private  JButton bT9; 
	private  JButton bT10; 
	private  JButton bT11; 
	private  JButton bT12; 
	private  JButton bT13; 
	private  JButton bT14; 
	private  JButton bT15; 
	private  JButton bT16; 
	private JButton[] territoryBttons = {bT0,bT1,bT2,bT3}; 
	private JButton[] characterBttons = {bT4,bT5,bT6,bT7}; 
	private JButton[] buildingBttons = {bT8,bT9,bT10,bT11}; 
	private JButton[] ventureBttons = {bT12,bT13,bT14,bT15}; 
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
	private JButton VB1;
	private JButton VB2;
	private JButton VB3;
	private JButton VB4;
	private JButton VB5;
	private JButton VB6;
	private JButton CB1;
	private JButton CB2;
	private JButton CB3;
	private JButton CB4;
	private JButton CB5;
	private JButton CB6;
	private JButton[] pBoardCharacter = {CB1,CB2,CB3,CB4,CB5,CB6}; 
	private JButton[] pBoardVenture = {VB1,VB2,VB3,VB4,VB5,VB6}; 
	private JButton[] pBoardBuilding; 
	private JButton[] pBoardTerritory; 
	private Clip clip;
	private Dimension dimension;
	private JButton excommTile1;
	private JButton excommTile2;
	private JButton excommTile3;

	
	public GameBoardGUI() throws IOException, InterruptedException {
		//java.awt.Toolkit.getDefaultToolkit().getScreenSize();
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
		
		
		
		int numeroCarte = 14;
		ImageIcon[] territoryCards = new ImageIcon[numeroCarte];
		ImageIcon[] buildingCards = new ImageIcon[numeroCarte];
		ImageIcon[] characterCards = new ImageIcon[numeroCarte];
		ImageIcon[] ventureCards = new ImageIcon[numeroCarte];
		
		for (int i = 0; i < numeroCarte; i++) {
			String nomeCarta = "territoryCard" + i; //così ottieni 'carta0', 'carta1' etc.
					//territoryCards[i] = new ImageIcon(getClass().getResource("/TerritoryCardRid/devcards_f_en_c_"+i+".png"));
			
		territoryCards[0] = new ImageIcon(getClass().getResource("/TerritoryCardRid/devcards_f_en_c_1.png"));
		territoryCards[1] = new ImageIcon(getClass().getResource("/TerritoryCardRid/devcards_f_en_c_2.png"));
		territoryCards[2] = new ImageIcon(getClass().getResource("/TerritoryCardRid/devcards_f_en_c_3.png"));
		territoryCards[3] = new ImageIcon(getClass().getResource("/TerritoryCardRid/devcards_f_en_c_4.png"));
		territoryCards[4] = new ImageIcon(getClass().getResource("/TerritoryCardRid/devcards_f_en_c_5.png"));
		territoryCards[5] = new ImageIcon(getClass().getResource("/TerritoryCardRid/devcards_f_en_c_6.png"));
		territoryCards[6] = new ImageIcon(getClass().getResource("/TerritoryCardRid/devcards_f_en_c_7.png"));
		territoryCards[7] = new ImageIcon(getClass().getResource("/TerritoryCardRid/devcards_f_en_c_8.png"));
		territoryCards[8] = new ImageIcon(getClass().getResource("/TerritoryCardRid/devcards_f_en_c_9.png"));
		territoryCards[9] = new ImageIcon(getClass().getResource("/TerritoryCardRid/devcards_f_en_c_10.png"));
		territoryCards[10] = new ImageIcon(getClass().getResource("/TerritoryCardRid/devcards_f_en_c_11.png"));
		territoryCards[11] = new ImageIcon(getClass().getResource("/TerritoryCardRid/devcards_f_en_c_12.png"));
		buildingCards[12] = new ImageIcon(getClass().getResource("/BuildingCardRid/devcards_f_en_c_26.png"));
		territoryCards[13] = new ImageIcon(getClass().getResource("/TerritoryCardRid/devcards_f_en_c_14.png"));
		characterCards[8] = new ImageIcon(getClass().getResource("/CharacterCardRid/devcards_f_en_c_70.png"));
		ventureCards[10] = new ImageIcon(getClass().getResource("/VentureCardRid/devcards_f_en_c_88.png"));
		}
		
		Random random = new Random();
		int casuale = random.nextInt(territoryCards.length);
		
		
		gameboard = new ImageIcon(getClass().getResource("/immagini/gameboardRid.png"));	
		Image img = gameboard.getImage();
		Image newimg = img.getScaledInstance(500, 700, Image.SCALE_DEFAULT);
		
		gameboard = new ImageIcon(newimg);
		label1 = new JLabel(gameboard);
		//getContentPane().add(label1);
		label1.setIcon(gameboard);
		//this.getContentPane().setBackground(Color.orange);
		pBoard2 = new JButton(" Player2");
		pBoard3 = new JButton(" Player3");
		pBoard4 = new JButton(" Player4");

		punchboard = new ImageIcon(getClass().getResource("/immagini/punchboard_f_c_03.jpg"));
		label2 = new JLabel(punchboard);
		//getContentPane().add(label2);
		label2.setIcon(punchboard);
		
		personalTile = new ImageIcon(getClass().getResource("/ExcommunicationTiles/personalbonustile_2.png"));
		label3 = new JLabel(personalTile);
		//getContentPane().add(label3);
		label3.setIcon(personalTile);
		
		slotVentureCards = new ImageIcon(getClass().getResource("/immagini/venturePBoard.jpg"));
		label4 = new JLabel(slotVentureCards);
		label4.setIcon(slotVentureCards);
		
		slotCharacterCards = new ImageIcon(getClass().getResource("/immagini/characterPBoard.jpg"));
		label5 = new JLabel(slotCharacterCards);
		label5.setIcon(slotCharacterCards);
		
		leaderCardBack = new ImageIcon(getClass().getResource("/LeaderCards/leaders_b_c_00.jpg"));
		JButton leaderCard1P1 = new JButton(leaderCardBack);
		JButton leaderCard2P1 = new JButton(leaderCardBack);
		JButton leaderCard3P1 = new JButton(leaderCardBack);
		JButton leaderCard4P1 = new JButton(leaderCardBack);
		JButton leaderCard5P1 = new JButton(leaderCardBack);
		
		
		
		excommunicationCard1 = new ImageIcon(getClass().getResource("/ExcommunicationTiles/excomm_1_1 rid.png"));
		excommunicationCard2 = new ImageIcon(getClass().getResource("/ExcommunicationTiles/excomm_2_1 rid.png"));
		excommunicationCard3 = new ImageIcon(getClass().getResource("/ExcommunicationTiles/excomm_3_1 rid.png"));
		excommTile1 = new JButton(excommunicationCard1);
		excommTile2 = new JButton(excommunicationCard2);
		excommTile3 = new JButton(excommunicationCard3);
		excommTile1.setBounds(110, 420, 30, 60);
		excommTile2.setBounds(140, 420, 30, 60);
		excommTile3.setBounds(170, 420, 30, 60);
		excommTile1.setBorder(null);
		excommTile2.setBorder(null);
		excommTile3.setBorder(null);
		label1.add(excommTile1);
		label1.add(excommTile2);
		label1.add(excommTile3);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.orange);
		
		getContentPane().add(panel);
		
		label1.setBounds(5,5, 500, 700);
		label2.setBounds(550,50,500,352);
		label3.setBounds(510, 50,50,352);
		label4.setBounds(500, 405, 580, 110);
		label5.setBounds(500, 515, 580, 110);
		
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		
		Image img1 = punchboard.getImage();
		Image newimg1 = img.getScaledInstance(200, 300, Image.SCALE_DEFAULT);
		punchboard = new ImageIcon(newimg1);
		
		bT0 = new JButton();		
		bT0.setIcon(territoryCards[3]);
		bT1 = new JButton();		
		bT1.setIcon(territoryCards[3]);
		bT2 = new JButton();		
		bT2.setIcon(territoryCards[3]);
		bT3 = new JButton();
		bT3.setIcon(territoryCards[3]);
		bT4 = new JButton(characterCards[8]);
		bT5 = new JButton(characterCards[8]);
		bT6 = new JButton(characterCards[8]);
		bT7 = new JButton(characterCards[8]);
		//bT8 = new JButton("View");
		bT8 = new JButton(buildingCards[12]);
		bT9 = new JButton(buildingCards[12]);
		bT10 = new JButton(buildingCards[12]);
		bT11 = new JButton(buildingCards[12]);
		bT12 = new JButton(ventureCards[10]);
		bT13 = new JButton(ventureCards[10]);
		bT14 = new JButton(ventureCards[10]);
		bT15 = new JButton(ventureCards[10]);
		bT16 = new JButton("Council Palace");
		bT17 = new JButton("Run");
		bT18 = new JButton("Take");
		bT19 = new JButton("Run");
		bT20 = new JButton("Take");
		bT21 = new JButton("Take");
		bT22 = new JButton("Take");
		CB1 = new JButton();
		//CB1.setIcon(territoryCards[casuale]);
		CB2 = new JButton();
		//CB2.setIcon(territoryCards[casuale]);
		CB3 = new JButton();
		//CB3.setIcon(territoryCards[casuale]);
		CB4 = new JButton();
		//CB4.setIcon(territoryCards[casuale]);
		CB5 = new JButton(Card1);
		CB6 = new JButton();
		VB1 = new JButton();
		VB2 = new JButton();
		VB3 = new JButton();
		VB4 = new JButton();
		VB5 = new JButton();
		VB6 = new JButton();
		
		bT0.setContentAreaFilled(false);
		bT1.setContentAreaFilled(false);
		bT2.setContentAreaFilled(false);
		bT3.setContentAreaFilled(false); //usato per annerire la scritta del bottone
		bT4.setContentAreaFilled(false);
		bT5.setContentAreaFilled(false);
		bT6.setContentAreaFilled(false);
		bT7.setContentAreaFilled(false);
		bT8.setContentAreaFilled(false);
		bT9.setContentAreaFilled(false);
		bT10.setContentAreaFilled(false);
		bT11.setContentAreaFilled(false);
		bT12.setContentAreaFilled(false);
		bT13.setContentAreaFilled(false);
		bT14.setContentAreaFilled(false);
		bT15.setContentAreaFilled(false);
		bT16.setContentAreaFilled(false);
		bT17.setContentAreaFilled(true);
		bT18.setContentAreaFilled(true);
		bT19.setContentAreaFilled(true);
		bT20.setContentAreaFilled(true);
		bT21.setContentAreaFilled(true);
		bT22.setContentAreaFilled(true);
		CB1.setContentAreaFilled(false);
		CB2.setContentAreaFilled(false);
		CB3.setContentAreaFilled(false);
		CB4.setContentAreaFilled(false);
		CB5.setContentAreaFilled(false);
		CB6.setContentAreaFilled(false);
		VB1.setContentAreaFilled(false);
		VB2.setContentAreaFilled(false);
		VB3.setContentAreaFilled(false);
		VB4.setContentAreaFilled(false);
		VB5.setContentAreaFilled(false);
		VB6.setContentAreaFilled(false);
		
		
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
		bT17.setBounds(80, 580, 25, 20);
		bT18.setBounds(340, 595, 35, 20);
		bT19.setBounds(80, 640, 25, 20);
		bT20.setBounds(300, 585, 35,20);
		bT21.setBounds(260, 585, 35, 20);
		bT22.setBounds(375, 625, 35, 20);
		CB1.setBounds(555, 405, 80, 110);
		CB2.setBounds(630, 405, 80, 110);
		CB3.setBounds(710, 405, 80, 110);
		CB4.setBounds(790, 405, 80, 110);
		CB5.setBounds(870, 405, 80, 110);
		CB6.setBounds(945, 405, 80, 110);
		VB1.setBounds(560, 515, 75, 110);
		VB2.setBounds(630, 515, 75, 110);
		VB3.setBounds(710, 515, 75, 110);
		VB4.setBounds(790, 515, 75, 110);
		VB5.setBounds(870, 515, 75, 110);
		VB6.setBounds(950, 515, 75, 110);
		leaderCard1P1.setBounds(1070,40,130,200);
		leaderCard2P1.setBounds(1200,40,130,200);
		leaderCard3P1.setBounds(1070,240,130,200);
		leaderCard4P1.setBounds(1200,240,130,200);
		leaderCard5P1.setBounds(1070,440,130,200);
		
		
		label1.add(bT0);
		label1.add(bT1);
		label1.add(bT2);
		label1.add(bT3);
		label1.add(bT4);
		label1.add(bT5);
		label1.add(bT6);
		label1.add(bT7);
		label1.add(bT8);
		label1.add(bT9);
		label1.add(bT10);
		label1.add(bT11);
		label1.add(bT12);
		label1.add(bT13);
		label1.add(bT14);
		label1.add(bT15);
		label1.add(bT16);
		label1.add(bT17);
		label1.add(bT18);
		label1.add(bT19);		
		label1.add(bT20);
		label1.add(bT21);
		label1.add(bT22);
		label4.add(CB1);
		label4.add(CB2);
		label4.add(CB3);
		label4.add(CB4);
		label4.add(CB5);
		label4.add(CB6);
		label5.add(VB1);
		label5.add(VB2);
		label5.add(VB3);
		label5.add(VB4);
		label5.add(VB5);
		label5.add(VB6);
		bT0.setBorder(null);
		bT1.setBorder(null);
		bT2.setBorder(null);
		bT3.setBorder(null);
		bT4.setBorder(null);
		bT5.setBorder(null);
		bT6.setBorder(null);
		bT7.setBorder(null);
		bT8.setBorder(null);
		bT9.setBorder(null);
		bT10.setBorder(null);
		bT11.setBorder(null);
		bT12.setBorder(null);
		bT13.setBorder(null);
		bT14.setBorder(null);
		bT15.setBorder(null);
		bT16.setBorder(null);
		bT17.setBorder(null);
		bT18.setBorder(null);
		bT19.setBorder(null);
		bT20.setBorder(null);
		bT21.setBorder(null);
		bT22.setBorder(null);
		
		panel.add(pBoard2);
		panel.add(pBoard3);
		panel.add(pBoard4);
		pBoard2.setBounds(520, 10, 80, 35);
		pBoard3.setBounds(620, 10, 80, 35);
		pBoard4.setBounds(720, 10, 80, 35);
		
		panel.add(CB1);
		panel.add(CB2);
		panel.add(CB3);
		panel.add(CB4);
		panel.add(CB5);
		panel.add(CB6);
		panel.add(label4);
		
		panel.add(VB1);
		panel.add(VB2);
		panel.add(VB3);
		panel.add(VB4);
		panel.add(VB5);
		panel.add(VB6);
		panel.add(label5);
		
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
		
		TextField numberOfServants = new TextField("number");
		label2.add(numberOfServants);
		numberOfServants.setBounds(270, 325, 25, 25);
		numberOfServants.setBackground(Color.white);
		numberOfServants.setVisible(true);
			
		TextField numberOfCoins = new TextField("number");
		label2.add(numberOfCoins);
		numberOfCoins.setBounds(40, 325, 25, 25);
		numberOfCoins.setBackground(Color.white);
		numberOfCoins.setVisible(true);
		
		TextField numberOfWoods = new TextField("number");
		label2.add(numberOfWoods);
		numberOfWoods.setBounds(110, 325, 25, 25);
		numberOfWoods.setBackground(Color.white);
		numberOfWoods.setVisible(true);
		

		TextField numberOfStones = new TextField("number");
		label2.add(numberOfStones);
		numberOfStones.setBounds(185, 325, 25, 25);
		numberOfStones.setBackground(Color.white);
		numberOfStones.setVisible(true);
		
		AudioInputStream audioIn = null;
		
		try {
			audioIn = AudioSystem.getAudioInputStream(GameBoardGUI.class.getResource("/immagini/Crash Bandicoot Medieval Music.wav"));
			
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Clip clip = null;
		try {
			clip = AudioSystem.getClip();
			
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			clip.open(audioIn);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			Thread.sleep(100);
			
			
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clip.start();
		
		colorC = new Color(0, 140, 255);
		colorV = new Color(170,0 ,220 );
		
		
		
		
		pack();
		setVisible(true);
		}
	
		
	public static void main(String[] args) throws IOException, InterruptedException  {
		 new GameBoardGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e1) {
		
			if(e1.getSource()==bT0){
//				Buttons b = new Buttons();
//				b.Card = new ImageIcon(getClass().getResource("/BuildingCard/devcards_f_en_c_25.png"));
//				b.getContentPane().setBackground(Color.green);	
				
				
			}
		
			if(e1.getSource()==bT1){
				Buttons b =	new Buttons();
				b.getContentPane().setBackground(Color.GREEN);
				bT1.setVisible(false);
				//label2.add(bT1).setVisible(true);;
				//bT1.setEnabled(true);
				//bT1.setLocation(10, 150);
				
			}
		
			if(e1.getSource()==bT2){
				Buttons b = new Buttons();
				b.getContentPane().setBackground(Color.green);
				
			}
			if(e1.getSource()==bT3){
				
				Buttons b = new Buttons();
				b.getContentPane().setBackground(Color.green);
				
			}
			if(e1.getSource()==bT4){
				Buttons b = new Buttons();
				b.getContentPane().setBackground(colorC);
				bT4.setVisible(false);
				b.getContentPane().setForeground(Color.white);
				CB1.setDisabledIcon(Card1);
				CB1.setVisible(true);
				/*JDialog dialogCard = new JDialog();
				ImageIcon charachterCards= new ImageIcon(getClass().getResource("/CharacterCard/devcards_f_en_c_49.png"));
				JLabel labelCard = new JLabel(charachterCards);
				labelCard.setLayout(null);
				dialogCard.getContentPane().add(labelCard); //se diventa troppo difficile associare le immagini alle rispettive ridimensionate creo i dialog
				dialogCard.setVisible(true);
				dialogCard.setBackground(Color.blue);
				dialogCard.setForeground(Color.white);*/
			}
			if(e1.getSource()==bT5){
				Buttons b =	new Buttons();
				b.getContentPane().setBackground(colorC);
				b.getContentPane().setForeground(Color.white);
				
			}
			if(e1.getSource()==bT6){
				Buttons b = new Buttons();
				b.getContentPane().setBackground(colorC );
				b.getContentPane().setForeground(Color.white);
			}
			if(e1.getSource()==bT7){
				Buttons b = new Buttons();
				b.getContentPane().setBackground(colorC);
				b.getContentPane().setForeground(Color.white);
			}
			if(e1.getSource()==bT8){
				Buttons b = new Buttons();
				b.getContentPane().setBackground(Color.yellow);
			
			}
			if(e1.getSource()==bT9){
				Buttons b =	new Buttons();
				b.getContentPane().setBackground(Color.yellow);
				
			}
			if(e1.getSource()==bT10){
				Buttons b = new Buttons();
				b.getContentPane().setBackground(Color.yellow);
				
			}
			if(e1.getSource()==bT11){
				Buttons b = new Buttons();
				b.getContentPane().setBackground(Color.yellow);
			
			}
			if(e1.getSource()==bT12){
				Buttons b = new Buttons();
				b.getContentPane().setBackground(colorV);
			
			}
			if(e1.getSource()==bT13){
				Buttons b =	new Buttons();
				b.getContentPane().setBackground(colorV);
							}
			if(e1.getSource()==bT14){
				Buttons b = new Buttons();
				b.getContentPane().setBackground(colorV);
				
			}
			if(e1.getSource()==bT15){
				Buttons b = new Buttons();
				b.getContentPane().setBackground(colorV);
			
			}
			
			
			if(e1.getSource()==bT16){
				Color colorCP = new Color(255, 240, 190);
				JDialog dialogCouncil = new JDialog();
				dialogCouncil.setTitle("Council Privilege");
				dialogCouncil.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage
						(dialogCouncil.getClass().getResource("/immagini/leaders_b_c_00.jpg")));
				JButton servants = new JButton();
				JButton coins = new JButton();
				JButton faithPoints = new JButton();
				JButton militaryPoints = new JButton();
				JButton woodsAndStones = new JButton();
				JButton button = new JButton("OK");
				//dialogCouncil.setLayout(null);
				dialogCouncil.add(button);
				ImageIcon councilPrivilege = new ImageIcon(getClass().getResource("/immagini/councilPrivilege.png"));
				JLabel labelCouncil = new JLabel(councilPrivilege);
				labelCouncil.setLayout(null);
				TextField textField = new TextField("Choose your privilege");
				labelCouncil.add(servants);
				labelCouncil.add(coins);
				labelCouncil.add(faithPoints);
				labelCouncil.add(militaryPoints);
				labelCouncil.add(woodsAndStones);
				labelCouncil.add(button);
				dialogCouncil.add(labelCouncil);
				labelCouncil.add(textField);
				textField.setEditable(false);
				dialogCouncil.setSize(600, 400);
				dialogCouncil.setLocation(450, 200);
				dialogCouncil.setResizable(false);
				labelCouncil.setBounds(100, 100, 100, 100);
				textField.setBounds(200, 10, 150, 25);
				woodsAndStones.setBounds(200, 150, 50, 50);
				servants.setBounds(255, 150, 50, 50);
				coins.setBounds(320, 150, 50, 50);
				faithPoints.setBounds(430, 150, 50, 50);
				militaryPoints.setBounds(370, 150, 50, 50);
				button.setBounds(280, 300, 60, 35);
				servants.setContentAreaFilled(false);
				coins.setContentAreaFilled(false);
				faithPoints.setContentAreaFilled(false);
				militaryPoints.setContentAreaFilled(false);
				woodsAndStones.setContentAreaFilled(false);
				dialogCouncil.getContentPane().setBackground(colorCP);
				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(e.getSource()==button)
							dialogCouncil.dispose();
					}
				});
				
				
				dialogCouncil.setVisible(true);
				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(e.getSource()==button)
							dialogCouncil.dispose();
						
					}
				});
				
					
			}
			if(e1.getSource()==pBoard2){
				JDialog dialog1 = new JDialog();
				dialog1.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage
						(dialog1.getClass().getResource("/immagini/leaders_b_c_00.jpg")));
				JLabel boardP2 = new JLabel();
				JLabel ventureLabelP2 = new JLabel();
				JLabel characterLabelP2 = new JLabel();
				JLabel labelTile = new JLabel(personalTile);
				JButton leaderCard1P2 = new JButton();
				JButton leaderCard2P2 = new JButton();
				JButton leaderCard3P2 = new JButton();
				JButton leaderCard4P2 = new JButton();
				JButton leaderCard5P2 = new JButton();
				
				dialog1.setTitle("Player2");
				dialog1.setSize(1250,650);
				dialog1.setResizable(true);
				dialog1.setLayout(null);
				dialog1.setLocation(40, 50);
				dialog1.getContentPane().setBackground(Color.red);
				
				punchboard = new ImageIcon(getClass().getResource("/immagini/punchboard_f_c_03.jpg"));
				slotVentureCards = new ImageIcon(getClass().getResource("/immagini/venturePBoard.jpg"));
				slotCharacterCards = new ImageIcon(getClass().getResource("/immagini/characterPBoard.jpg"));
								
				leaderCardBack = new ImageIcon(getClass().getResource("/LeaderCards/leaders_b_c_00.jpg"));
				personalTile = new ImageIcon(getClass().getResource("/ExcommunicationTiles/personalbonustile_2.png"));
				
				labelTile.setBounds(1, 5, 65, 355);
				boardP2.setBounds(50, 5, 900, 350);
				ventureLabelP2.setBounds(580, 5, 500,125 );
				characterLabelP2.setBounds(580, 148, 500,125 );
				leaderCard1P2.setBounds(560, 375, 130, 200);
				leaderCard2P2.setBounds(690, 375, 130, 200);
				leaderCard3P2.setBounds(820, 375, 130, 200);
				leaderCard4P2.setBounds(950, 375, 130, 200);
				leaderCard5P2.setBounds(1080, 375, 130, 200);
				
				leaderCard1P2.setContentAreaFilled(false);
				leaderCard2P2.setContentAreaFilled(false);
				leaderCard3P2.setContentAreaFilled(false);
				leaderCard4P2.setContentAreaFilled(false);
				leaderCard5P2.setContentAreaFilled(false);
				
				leaderCard1P2.setIcon(leaderCardBack);
				leaderCard2P2.setIcon(leaderCardBack);
				leaderCard3P2.setIcon(leaderCardBack);
				leaderCard4P2.setIcon(leaderCardBack);
				leaderCard5P2.setIcon(leaderCardBack);
				
				dialog1.add(leaderCard1P2);
				dialog1.add(leaderCard2P2);
				dialog1.add(leaderCard3P2);
				dialog1.add(leaderCard4P2);
				dialog1.add(leaderCard5P2);
				dialog1.add(boardP2);
				dialog1.add(ventureLabelP2);
				dialog1.add(characterLabelP2);
				dialog1.add(labelTile);
				
				boardP2.setIcon(punchboard);
				ventureLabelP2.setIcon(slotVentureCards);
				characterLabelP2.setIcon(slotCharacterCards);
				labelTile.setIcon(personalTile);
				
				TextField numberOfServants = new TextField("number");
				boardP2.add(numberOfServants);
				numberOfServants.setBounds(270, 325, 25, 25);
				numberOfServants.setBackground(Color.white);
				numberOfServants.setVisible(true);
					
				TextField numberOfCoins = new TextField("number");
				boardP2.add(numberOfCoins);
				numberOfCoins.setBounds(40, 325, 25, 25);
				numberOfCoins.setBackground(Color.white);
				numberOfCoins.setVisible(true);
				
				TextField numberOfWoods = new TextField("number");
				boardP2.add(numberOfWoods);
				numberOfWoods.setBounds(110, 325, 25, 25);
				numberOfWoods.setBackground(Color.white);
				numberOfWoods.setVisible(true);
				

				TextField numberOfStones = new TextField("number");
				boardP2.add(numberOfStones);
				numberOfStones.setBounds(185, 325, 25, 25);
				numberOfStones.setBackground(Color.white);
				numberOfStones.setVisible(true);

				ventureLabelP2.setVisible(true);
				characterLabelP2.setVisible(true);
				leaderCard1P2.setVisible(true);
				boardP2.setVisible(true);
				labelTile.setVisible(true);
				dialog1.setVisible(true);
				}
			
			if(e1.getSource()==pBoard3){
				JDialog dialog2 = new JDialog();
				dialog2.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage
						(dialog2.getClass().getResource("/immagini/leaders_b_c_00.jpg")));
				JLabel boardP3 = new JLabel();
				JLabel ventureLabelP3 = new JLabel();
				JLabel characterLabelP3 = new JLabel();
				JLabel labelTile = new JLabel(personalTile);
				JButton leaderCard1P3 = new JButton();
				JButton leaderCard2P3 = new JButton();
				JButton leaderCard3P3 = new JButton();
				JButton leaderCard4P3 = new JButton();
				JButton leaderCard5P3 = new JButton();
				
				dialog2.setTitle("Player3");
				dialog2.setSize(1250,650);
				dialog2.setResizable(true);
				dialog2.setLayout(null);
				dialog2.setLocation(40, 50);
				dialog2.getContentPane().setBackground(Color.blue);
				
				punchboard = new ImageIcon(getClass().getResource("/immagini/punchboard_f_c_03.jpg"));
				slotVentureCards = new ImageIcon(getClass().getResource("/immagini/venturePBoard.jpg"));
				slotCharacterCards = new ImageIcon(getClass().getResource("/immagini/characterPBoard.jpg"));
				leaderCardBack = new ImageIcon(getClass().getResource("/LeaderCards/leaders_b_c_00.jpg"));
				personalTile = new ImageIcon(getClass().getResource("/ExcommunicationTiles/personalbonustile_2.png"));
				
				labelTile.setBounds(1, 5, 65, 355);
				boardP3.setBounds(50, 5, 900, 350);
				ventureLabelP3.setBounds(580, 5, 500,125 );
				characterLabelP3.setBounds(580, 148, 500,125 );
				leaderCard1P3.setBounds(560, 375, 130, 200);
				leaderCard2P3.setBounds(690, 375, 130, 200);
				leaderCard3P3.setBounds(820, 375, 130, 200);
				leaderCard4P3.setBounds(950, 375, 130, 200);
				leaderCard5P3.setBounds(1080, 375, 130, 200);
				
				leaderCard1P3.setContentAreaFilled(false);
				leaderCard2P3.setContentAreaFilled(false);
				leaderCard3P3.setContentAreaFilled(false);
				leaderCard4P3.setContentAreaFilled(false);
				leaderCard5P3.setContentAreaFilled(false);
				
				leaderCard1P3.setIcon(leaderCardBack);
				leaderCard2P3.setIcon(leaderCardBack);
				leaderCard3P3.setIcon(leaderCardBack);
				leaderCard4P3.setIcon(leaderCardBack);
				leaderCard5P3.setIcon(leaderCardBack);
				
				dialog2.add(leaderCard1P3);
				dialog2.add(leaderCard2P3);
				dialog2.add(leaderCard3P3);
				dialog2.add(leaderCard4P3);
				dialog2.add(leaderCard5P3);
				dialog2.add(boardP3);
				dialog2.add(ventureLabelP3);
				dialog2.add(characterLabelP3);
				dialog2.add(labelTile);
				
				boardP3.setIcon(punchboard);
				labelTile.setIcon(personalTile);
				ventureLabelP3.setIcon(slotVentureCards);
				characterLabelP3.setIcon(slotCharacterCards);
				
				TextField numberOfServants = new TextField("number");
				boardP3.add(numberOfServants);
				numberOfServants.setBounds(270, 325, 25, 25);
				numberOfServants.setBackground(Color.white);
				numberOfServants.setVisible(true);
					
				TextField numberOfCoins = new TextField("number");
				boardP3.add(numberOfCoins);
				numberOfCoins.setBounds(40, 325, 25, 25);
				numberOfCoins.setBackground(Color.white);
				numberOfCoins.setVisible(true);
				
				TextField numberOfWoods = new TextField("number");
				boardP3.add(numberOfWoods);
				numberOfWoods.setBounds(110, 325, 25, 25);
				numberOfWoods.setBackground(Color.white);
				numberOfWoods.setVisible(true);
				

				TextField numberOfStones = new TextField("number");
				boardP3.add(numberOfStones);
				numberOfStones.setBounds(185, 325, 25, 25);
				numberOfStones.setBackground(Color.white);
				numberOfStones.setVisible(true);
				ventureLabelP3.setVisible(true);
				characterLabelP3.setVisible(true);
				leaderCard1P3.setVisible(true);
				boardP3.setVisible(true);
				labelTile.setVisible(true);
				dialog2.setVisible(true);
	}
		
			if(e1.getSource()==pBoard4){
				JDialog dialog3 = new JDialog();
				dialog3.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage
						(dialog3.getClass().getResource("/immagini/leaders_b_c_00.jpg")));
				JLabel boardP4 = new JLabel();
				JLabel ventureLabelP4 = new JLabel();
				JLabel characterLabelP4 = new JLabel();
				JLabel labelTile = new JLabel(personalTile);
				JButton leaderCard1P4 = new JButton();
				JButton leaderCard2P4 = new JButton();
				JButton leaderCard3P4 = new JButton();
				JButton leaderCard4P4 = new JButton();
				JButton leaderCard5P4 = new JButton();
				
				dialog3.setTitle("Player4");
				dialog3.setSize(1250,650);
				dialog3.setResizable(true);
				dialog3.setLayout(null);
				dialog3.setLocation(40, 50);
				dialog3.getContentPane().setBackground(Color.green);
				
				punchboard = new ImageIcon(getClass().getResource("/immagini/punchboard_f_c_03.jpg"));
				slotVentureCards = new ImageIcon(getClass().getResource("/immagini/venturePBoard.jpg"));
				slotCharacterCards = new ImageIcon(getClass().getResource("/immagini/characterPBoard.jpg"));
				leaderCardBack = new ImageIcon(getClass().getResource("/LeaderCards/leaders_b_c_00.jpg"));
				personalTile = new ImageIcon(getClass().getResource("/ExcommunicationTiles/personalbonustile_2.png"));
				
				labelTile.setBounds(1, 5, 65, 355);
				boardP4.setBounds(50, 5, 900, 350);
				ventureLabelP4.setBounds(580, 5, 500,125 );
				characterLabelP4.setBounds(580, 148, 500,125 );
				leaderCard1P4.setBounds(560, 375, 130, 200);
				leaderCard2P4.setBounds(690, 375, 130, 200);
				leaderCard3P4.setBounds(820, 375, 130, 200);
				leaderCard4P4.setBounds(950, 375, 130, 200);
				leaderCard5P4.setBounds(1080, 375, 130, 200);
				
				leaderCard1P4.setContentAreaFilled(false);
				leaderCard2P4.setContentAreaFilled(false);
				leaderCard3P4.setContentAreaFilled(false);
				leaderCard4P4.setContentAreaFilled(false);
				leaderCard5P4.setContentAreaFilled(false);
				
				leaderCard1P4.setIcon(leaderCardBack);
				leaderCard2P4.setIcon(leaderCardBack);
				leaderCard3P4.setIcon(leaderCardBack);
				leaderCard4P4.setIcon(leaderCardBack);
				leaderCard5P4.setIcon(leaderCardBack);
				
				dialog3.add(leaderCard1P4);
				dialog3.add(leaderCard2P4);
				dialog3.add(leaderCard3P4);
				dialog3.add(leaderCard4P4);
				dialog3.add(leaderCard5P4);
				dialog3.add(boardP4);
				dialog3.add(labelTile);
				dialog3.add(ventureLabelP4);
				dialog3.add(characterLabelP4);
				
				boardP4.setIcon(punchboard);
				labelTile.setIcon(personalTile);
				ventureLabelP4.setIcon(slotVentureCards);
				characterLabelP4.setIcon(slotCharacterCards);
				
				TextField numberOfServants = new TextField("number");
				boardP4.add(numberOfServants);
				numberOfServants.setBounds(270, 325, 25, 25);
				numberOfServants.setBackground(Color.white);
				numberOfServants.setVisible(true);
					
				TextField numberOfCoins = new TextField("number");
				boardP4.add(numberOfCoins);
				numberOfCoins.setBounds(40, 325, 25, 25);
				numberOfCoins.setBackground(Color.white);
				numberOfCoins.setVisible(true);
				
				TextField numberOfWoods = new TextField("number");
				boardP4.add(numberOfWoods);
				numberOfWoods.setBounds(110, 325, 25, 25);
				numberOfWoods.setBackground(Color.white);
				numberOfWoods.setVisible(true);
				

				TextField numberOfStones = new TextField("number");
				boardP4.add(numberOfStones);
				numberOfStones.setBounds(185, 325, 25, 25);
				numberOfStones.setBackground(Color.white);
				numberOfStones.setVisible(true);
				ventureLabelP4.setVisible(true);
				characterLabelP4.setVisible(true);
				leaderCard1P4.setVisible(true);
				boardP4.setVisible(true);
				labelTile.setVisible(true);
				dialog3.setVisible(true);
			}
			
			
	
	
	
	}
	
			
			
			
			
			
			
	}		
	


