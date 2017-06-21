package it.polimi.ingsw.GC_04.gui;


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
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.plaf.ColorUIResource;
import javax.swing.text.Element;
import javax.swing.text.html.ImageView;

import com.sun.glass.events.WindowEvent;
import com.sun.media.sound.ModelAbstractChannelMixer;

import it.polimi.ingsw.GC_04.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.model.resource.Coins;
import it.polimi.ingsw.GC_04.model.resource.Servants;
import javafx.scene.control.Tab;

/*

public class GameBoardGUI extends JFrame implements ActionListener {
	private ImageIcon gameboard;
	private ImageIcon punchboard;
	private ImageIcon Card1;
	private ImageIcon Card5;
	private ImageIcon[] charachterCards;
	private ImageIcon[] buldingCards;
	private ImageIcon[] ventureCards;
	private JLabel label1;
	private JLabel label2;
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
	private JButton[] territoryBttons = {bT1,bT2,bT3,bT4}; 
	private JButton[] characterBttons = {bT5,bT6,bT7,bT8}; 
	private JButton[] buildingBttons = {bT9,bT10,bT11,bT12}; 
	private JButton[] ventureBttons = {bT13,bT14,bT15,bT16}; 
	
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
	private JTabbedPane tab1;
	private JTabbedPane tab2;
	private JTabbedPane tab3;

	public GameBoardGUI() throws IOException {
		
		setTitle("Lorenzo il Magnifico");
		//setLocation(0,0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout(5));
		getPreferredSize();
		setResizable(true);
		/*
		int numeroCarte = 14;
		ImageIcon[] territoryCards = new ImageIcon[numeroCarte];
	
		for (int i = 0; i < numeroCarte; i++) {
			String nomeCarta = "territoryCard" + i; //così ottieni 'carta0', 'carta1' etc.
					territoryCards[i] = new ImageIcon("/TerritoryCard/devcards_f_en_c_"+i+".png");
			
		territoryCards[0] = new ImageIcon(getClass().getResource("/TerritoryCard/devcards_f_en_c_1.png"));
		territoryCards[1] = new ImageIcon(getClass().getResource("/TerritoryCard/devcards_f_en_c_2.png"));
		territoryCards[2] = new ImageIcon(getClass().getResource("/TerritoryCard/devcards_f_en_c_3.png"));
		territoryCards[3] = new ImageIcon(getClass().getResource("/TerritoryCard/devcards_f_en_c_4.png"));
		territoryCards[4] = new ImageIcon(getClass().getResource("/TerritoryCard/devcards_f_en_c_5.png"));
		territoryCards[5] = new ImageIcon(getClass().getResource("/TerritoryCard/devcards_f_en_c_6.png"));
		territoryCards[6] = new ImageIcon(getClass().getResource("/TerritoryCard/devcards_f_en_c_7.png"));
		territoryCards[7] = new ImageIcon(getClass().getResource("/TerritoryCard/devcards_f_en_c_8.png"));
		territoryCards[8] = new ImageIcon(getClass().getResource("/TerritoryCard/devcards_f_en_c_9.png"));
		territoryCards[9] = new ImageIcon(getClass().getResource("/TerritoryCard/devcards_f_en_c_10.png"));
		territoryCards[10] = new ImageIcon(getClass().getResource("/TerritoryCard/devcards_f_en_c_11.png"));
		territoryCards[11] = new ImageIcon(getClass().getResource("/TerritoryCard/devcards_f_en_c_12.png"));
		territoryCards[12] = new ImageIcon(getClass().getResource("/TerritoryCard/devcards_f_en_c_13.png"));
		territoryCards[13] = new ImageIcon(getClass().getResource("/TerritoryCard/devcards_f_en_c_14.png"));
		
		}
		
		
		gameboard = new ImageIcon(getClass().getResource("/immagini/gameboardRid.png"));	
		Image img = gameboard.getImage();
		Image newimg = img.getScaledInstance(500, 700, Image.SCALE_DEFAULT);
		gameboard = new ImageIcon(newimg);
		label1 = new JLabel(gameboard);
		getContentPane().add(label1);
		label1.setIcon(gameboard);
		this.getContentPane().setBackground(Color.orange);
		tab1 = new JTabbedPane();
		pBoard2 = new JButton(" Player2");
		pBoard3 = new JButton(" Player3");
		pBoard4 = new JButton(" Player4");
		add(tab1);
		tab1.addTab("Player2",pBoard2 );
		tab1.addTab("Player3",pBoard3 );
		tab1.addTab("Player4",pBoard4 );
		tab1.setTabPlacement(JTabbedPane.VERTICAL);
		tab1.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		tab1.setVisible(true);
	
		punchboard = new ImageIcon(getClass().getResource("/immagini/punchboard_f_c_03.jpg"));
		label2 = new JLabel(punchboard);
		getContentPane().add(label2);
		label2.setIcon(punchboard);
		
		label1.setLayout(null);	
		label2.setLayout(null);
		Image img1 = punchboard.getImage();
		Image newimg1 = img.getScaledInstance(300, 400, Image.SCALE_DEFAULT);
		punchboard = new ImageIcon(newimg1);
		
		Random random = new Random();
		int casuale = random.nextInt(territoryCards.length);
//		Card1 = new ImageIcon(getClass().getResource("/TerritoryCard/devcards_f_en_c_6 ridimensionata.png"));
		//bT1 = new JButton(Card1); //usato per far diventare un'immagine un bottone
		//Card5 = new ImageIcon(getClass().getResource("/TerritoryCard/devcards_f_en_c_4 modificata.png"));
		//bT5 = new JButton(Card5);
		bT1 = new JButton();
		bT1.setIcon(territoryCards[casuale]);
		bT5 = new JButton();		
		bT5.setIcon(territoryCards[casuale]);
		bT9 = new JButton();		
		bT9.setIcon(territoryCards[casuale]);
		bT13 = new JButton();		
		bT13.setIcon(territoryCards[casuale]);
		bT2 = new JButton("View");
		bT3 = new JButton("View");
		bT4 = new JButton("View");
		bT6 = new JButton("View");
		bT7 = new JButton("View");
		bT8 = new JButton("View");
		//bT9 = new JButton("View");
		bT10 = new JButton("View");
		bT11 = new JButton("View");
		bT12 = new JButton("View");
		//bT13 = new JButton("View");
		bT14 = new JButton("View");
		bT15 = new JButton("View");
		bT16 = new JButton("View");
		bT17 = new JButton("Council Palace");
		bT18 = new JButton("Run");
		bT19 = new JButton("Run");
		bT20 = new JButton("Run");
		bT21 = new JButton("Servants");
		bT22 = new JButton("Coins");
		bT23 = new JButton("Woods");
		bT24 = new JButton("Stones");
		bT25 = new JButton("VictoryPoints");
		
		
		bT1.setContentAreaFilled(false); //usato per annerire la scritta del bottone
		bT2.setContentAreaFilled(false);
		bT3.setContentAreaFilled(false);
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
		bT17.setContentAreaFilled(false);
		bT18.setContentAreaFilled(true);
		bT19.setContentAreaFilled(true);
		bT20.setContentAreaFilled(true);
		bT21.setContentAreaFilled(false);
		bT22.setContentAreaFilled(false);
		bT23.setContentAreaFilled(false);
		bT24.setContentAreaFilled(false);
		bT25.setContentAreaFilled(false);
		pBoard2.setContentAreaFilled(true);
		pBoard3.setContentAreaFilled(true);
		pBoard4.setContentAreaFilled(true);
		
		
		//bT1.setBounds(35, 50,80 ,90 );
		bT1.setBounds(60, 70,30 ,30 );
		bT2.setBounds(150, 70, 30, 30);
		bT3.setBounds(240, 70, 30, 30);
		bT4.setBounds(330, 70, 30, 30);
		//bT5.setBounds(35, 130, 80, 90);
		bT5.setBounds(60, 150, 30, 30);
		bT6.setBounds(150, 150, 30, 30);
		bT7.setBounds(240, 150, 30, 30);
		bT8.setBounds(330, 150, 30, 30);   //(100, 150, 300, 500) queste dimensioni mi servivano solo per ingrandire l'immagine(poi li dovrò cancellare)
		bT9.setBounds(60, 230, 30, 30);
		bT10.setBounds(150, 230, 30, 30);
		bT11.setBounds(240, 230, 30, 30);
		bT12.setBounds(330, 230, 30, 30);
		bT13.setBounds(60, 310, 30, 30);
		bT14.setBounds(150, 310, 30, 30);
		bT15.setBounds(240, 310, 30, 30);
		bT16.setBounds(330, 310, 30, 30);
		bT17.setBounds(240,400,120,30);
		bT18.setBounds(155, 560, 25, 20);
		bT19.setBounds(50, 530, 25, 20);
		bT20.setBounds(155, 615, 25, 20);
		bT21.setBounds(240, 330, 75, 20);
		bT22.setBounds(25, 330, 35, 20);
		bT23.setBounds(105, 330, 45, 20);
		bT24.setBounds(175, 330, 45, 20);
		bT25.setBounds(50, 5, 85, 20);
		//pBoard2.setBounds(10, 240, 80, 25);
		//pBoard3.setBounds(100, 240, 80, 25);
		//pBoard4.setBounds(190, 240, 80, 25);
		
		
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
		label2.add(bT21);
		label2.add(bT22);
		label2.add(bT23);
		label2.add(bT24);
		label1.add(bT25);
		//label2.add(pBoard2);
		//label2.add(pBoard3);
		//label2.add(pBoard4);
		
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
		bT23.setBorder(null);
		bT24.setBorder(null);
		bT25.setBorder(null);
		
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
		bT21.addActionListener(this);
		bT23.addActionListener(this);
		bT24.addActionListener(this);
		bT25.addActionListener(this);
		pBoard2.addActionListener(this);
		pBoard3.addActionListener(this);
		pBoard4.addActionListener(this);
		
		bT21.setToolTipText("You have x Servants");
		bT22.setToolTipText("You have x Coins");
		bT23.setToolTipText("You have x Woods");
		bT24.setToolTipText("You have x Stones");
		bT25.setToolTipText("You have x Victory Points");
		
		
			
		
		
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
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clip.start();
		
		//add(tab1);
		
		pack();
		setVisible(true);
		}
	
	public void getCards(){
		
	}
		
	public static void main(String[] args) throws IOException  {
		 new GameBoardGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e1) {
			if(e1.getSource()==bT1){
			Buttons b =	new Buttons();
			b.getContentPane().setBackground(Color.GREEN);
			bT1.setVisible(false);
			//label2.add(bT1).setVisible(true);;
			//bT1.setEnabled(true);
			bT1.setLocation(10, 150);
			
			
			}
		
			if(e1.getSource()==bT2){
				Buttons b = new Buttons();
				b.getContentPane().setBackground(Color.BLUE);
				
				
			}
			if(e1.getSource()==bT3){
				Buttons b = new Buttons();
				b.getContentPane().setBackground(Color.yellow);
				
			}
			if(e1.getSource()==bT4){
				Buttons b = new Buttons();
				b.getContentPane().setBackground(Color.magenta);
			}
			if(e1.getSource()==bT5){
				Buttons b =	new Buttons();
				b.getContentPane().setBackground(Color.GREEN);
				
			}
			if(e1.getSource()==bT6){
				Buttons b = new Buttons();
				b.getContentPane().setBackground(Color.BLUE);
				
			}
			if(e1.getSource()==bT7){
				Buttons b = new Buttons();
				b.getContentPane().setBackground(Color.yellow);
			
			}
			if(e1.getSource()==bT8){
				Buttons b = new Buttons();
				b.getContentPane().setBackground(Color.magenta);
			
			}
			if(e1.getSource()==bT9){
				Buttons b =	new Buttons();
				b.getContentPane().setBackground(Color.GREEN);
				
			}
			if(e1.getSource()==bT10){
				Buttons b = new Buttons();
				b.getContentPane().setBackground(Color.BLUE);
				
			}
			if(e1.getSource()==bT11){
				Buttons b = new Buttons();
				b.getContentPane().setBackground(Color.yellow);
			
			}
			if(e1.getSource()==bT12){
				Buttons b = new Buttons();
				b.getContentPane().setBackground(Color.magenta);
			
			}
			if(e1.getSource()==bT13){
				Buttons b =	new Buttons();
				b.getContentPane().setBackground(Color.GREEN);
							}
			if(e1.getSource()==bT14){
				Buttons b = new Buttons();
				b.getContentPane().setBackground(Color.BLUE);
				
			}
			if(e1.getSource()==bT15){
				Buttons b = new Buttons();
				b.getContentPane().setBackground(Color.yellow);
			
			}
			if(e1.getSource()==bT16){
				Buttons b = new Buttons();
				b.getContentPane().setBackground(Color.magenta);
			
			}
			
			if(e1.getSource()==bT17){
				JDialog dialogCouncil = new JDialog();
				dialogCouncil.setTitle("Council Privilege");
				JCheckBox coins = new JCheckBox("Coins ",true);
				//coins.isSelected();
				coins.setSelected(true);
				JCheckBox woodsAndStones = new JCheckBox("Woods and Stones ",false);
				JCheckBox faithpoints = new JCheckBox("Faith Points ",false);
				JCheckBox servants = new JCheckBox("Servants ",false);
				JCheckBox militarypoints = new JCheckBox("Military Points ",false);
				TextField councilprivilege = new TextField("What do you want to take?");
				dialogCouncil.getContentPane().setLayout(null);
				dialogCouncil.setLocation(200,150);
				dialogCouncil.setSize(800,400);
				dialogCouncil.getContentPane().add(coins);
				dialogCouncil.getContentPane().add(woodsAndStones);	
				dialogCouncil.getContentPane().add(faithpoints);   
				dialogCouncil.getContentPane().add(servants);
				dialogCouncil.getContentPane().add(militarypoints);
				dialogCouncil.getContentPane().add(councilprivilege);
				councilprivilege.setBounds(100, 10, 150, 25);
				coins.setBounds(370, 70, 70, 25);
				woodsAndStones.setBounds(470, 70, 150, 25);
				servants.setBounds(370, 170, 80, 25);
				faithpoints.setBounds(470, 170, 100, 25);
				militarypoints.setBounds(580, 170, 120, 25);
				coins.setVisible(true);
				woodsAndStones.setVisible(true);
				servants.setVisible(true);
				faithpoints.setVisible(true);
				militarypoints.setVisible(true);
				dialogCouncil.setVisible(true);
				
				woodsAndStones.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
					/*	woodsAndStones.setVisible(false);// TODO Auto-generated method stub
						servants.setVisible(false);
						faithpoints.setVisible(false);
						militarypoints.setVisible(false);
						coins.setVisible(false);
						TextField confirm = new TextField("You chose coins,woods and stones");
						dialogCouncil.getContentPane().add(confirm);
						confirm.setBounds(50, 100, 200, 25);
						confirm.setVisible(true);
						//dialogCouncil.dispose();
					}	
				});
				faithpoints.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						/*woodsAndStones.setVisible(false);// TODO Auto-generated method stub
						servants.setVisible(false);
						faithpoints.setVisible(false);
						militarypoints.setVisible(false);
						coins.setVisible(false);
						TextField confirm = new TextField("You chose coins and Faith Points");
						dialogCouncil.getContentPane().add(confirm);
						confirm.setBounds(50, 100, 200, 25);
						confirm.setVisible(true);
						//dialogCouncil.dispose();
					}
				});
				servants.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						/*woodsAndStones.setVisible(false);// TODO Auto-generated method stub
						servants.setVisible(false);
						faithpoints.setVisible(false);
						militarypoints.setVisible(false);
						coins.setVisible(false);
						TextField confirm = new TextField("You chose coins and servants");
						dialogCouncil.getContentPane().add(confirm);
						confirm.setBounds(50, 100, 200, 25);
						confirm.setVisible(true);
						//dialogCouncil.dispose();
					}
				});
				militarypoints.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						/*woodsAndStones.setVisible(false);// TODO Auto-generated method stub
						servants.setVisible(false);
						faithpoints.setVisible(false);
						militarypoints.setVisible(false);
						coins.setVisible(false);
						TextField confirm = new TextField("You chose coinsand Military Points");
						dialogCouncil.getContentPane().add(confirm);
						confirm.setBounds(50, 100, 200, 25);
						confirm.setVisible(true);
						//dialogCouncil.dispose();
					}
				});
				coins.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						/*woodsAndStones.setVisible(false);// TODO Auto-generated method stub
						servants.setVisible(false);
						faithpoints.setVisible(false);
						militarypoints.setVisible(false);
						coins.setVisible(false);
						TextField confirm = new TextField("You chose coins");
						dialogCouncil.getContentPane().add(confirm);
						confirm.setBounds(50, 100, 200, 25);
						confirm.setVisible(true);
						//dialogCouncil.dispose();
					}
				});
				
			
			}
			if(e1.getSource()==pBoard2){
				JDialog dialog1 = new JDialog();
				JLabel boardP2 = new JLabel();
				dialog1.setTitle("Player2");
				dialog1.setSize(1000,400);
				dialog1.setLayout(null);
				dialog1.setLocation(200, 200);
				dialog1.getContentPane().setBackground(Color.red);
				punchboard = new ImageIcon(getClass().getResource("/immagini/punchboard_f_c_03.jpg"));
				boardP2.setBounds(0, 5, 900, 350);
				dialog1.add(boardP2);
				boardP2.setIcon(punchboard);
				boardP2.setVisible(true);
				dialog1.setVisible(true);
				}
			
			if(e1.getSource()==pBoard3){
				JDialog dialog2 = new JDialog();
				JLabel boardP3 = new JLabel();
				dialog2.setTitle("Player3");
				dialog2.setSize(1000,400);
				dialog2.setLayout(null);
				dialog2.setLocation(200, 200);
				dialog2.getContentPane().setBackground(Color.red);
				punchboard = new ImageIcon(getClass().getResource("/immagini/punchboard_f_c_03.jpg"));
				boardP3.setBounds(0, 5, 900, 350);
				dialog2.add(boardP3);
				boardP3.setIcon(punchboard);
				boardP3.setVisible(true);
				dialog2.setVisible(true);
				}
		
			if(e1.getSource()==pBoard4){
				JDialog dialog3 = new JDialog();
				JLabel boardP4 = new JLabel();
				dialog3.setTitle("Player4");
				dialog3.setSize(1000,400);
				dialog3.setLayout(null);
				dialog3.setLocation(200, 200);
				dialog3.getContentPane().setBackground(Color.red);
				punchboard = new ImageIcon(getClass().getResource("/immagini/punchboard_f_c_03.jpg"));
				boardP4.setBounds(0, 5, 900, 350);
				dialog3.add(boardP4);
				boardP4.setIcon(punchboard);
				boardP4.setVisible(true);
				dialog3.setVisible(true);
				}
			
			}
			
			
			
			
			
			
			
	}		
	

*/
