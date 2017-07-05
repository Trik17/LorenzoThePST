
package it.polimi.ingsw.GC_04.client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


public class Buttons extends JFrame implements ActionListener{
	
	private JLabel labelCard;
	private JLabel label;
	public ImageIcon Card;
	public ImageIcon Card1;
	public JButton button1;
	private JButton button2;
	private ButtonGroup group;
	private JRadioButton NeutralFMember;
	private JRadioButton BlackFMember;
	private JRadioButton WhiteFMember;
	private JRadioButton OrangeFMember;
	private TextField textField;
	private TextField textFMember;
	public  Buttons(){	
		
		super("Selected Card");
		setLocation(500,100);
		setResizable(true);
		
		this.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage
				(this.getClass().getResource("/immagini/leaders_b_c_00.jpg")));
		
		setLayout(new FlowLayout());//setLocation(150,0);
		labelCard = new JLabel(Card);
		labelCard.setLayout(null);
		Card = new ImageIcon(getClass().getResource("/TerritoryCard/devcards_f_en_c_6.png"));
		Card1= new ImageIcon(getClass().getResource(("/TerritoryCard/devcards_f_en_c_6.png")));
	
		add(labelCard);
		labelCard.setIcon(Card);
		
		labelCard.setLayout(null);
		label = new JLabel("Do you want to take this card?");
		label.setForeground(Color.darkGray);
		
		button1 = new JButton("Yes");
		button2 = new JButton("No");
		button1.setContentAreaFilled(true);
		button1.setBounds(45, 400, 100, 30);
		button2.setContentAreaFilled(true);
		button2.setBounds(150, 400, 100, 30);
		labelCard.add(button1);
		labelCard.add(button2);
		
		add(label);
		button1.addActionListener(this);
		button2.addActionListener(this);
	
 		pack();
		setVisible(true);
		
		
	}
	public static void main(String[] args){
		Buttons b = new Buttons();
			
	}

	
	
	
	
	
	
	

	public void actionPerformed(ActionEvent e) {
		//if(e.getSource()==button1){
		//textField.setText("I want to take this card");
		//}
		//if(e.getSource()==button2){
			//textField.setText("I want another card");
		//}
		
		if(e.getSource()==button1){
			Buttons buttons = new Buttons();
			buttons.setVisible(false);			 
			JDialog dialog = new JDialog();
			dialog.setTitle("Family Member");
			dialog.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage
					(dialog.getClass().getResource("/immagini/leaders_b_c_00.jpg")));
			TextField textField = new TextField("Which Family Member do you want to use?");
			textField.setEditable(false);
			ButtonGroup group = new ButtonGroup();
			JRadioButton BlackFMember = new JRadioButton("Black");
			JRadioButton WhiteFMember = new JRadioButton("White");
			JRadioButton OrangeFMember = new JRadioButton("Orange");
			JRadioButton NeutralFMember = new JRadioButton("Neutral");
			JButton buttonConfirm = new JButton("OK");
			BlackFMember.setBackground(Color.BLACK);
			BlackFMember.setForeground(Color.white);
			NeutralFMember.setBackground(Color.LIGHT_GRAY);
			WhiteFMember.setBackground(Color.white);
			OrangeFMember.setBackground(Color.orange);
			group.add(NeutralFMember);
			group.add(BlackFMember);
			group.add(WhiteFMember);
			group.add(OrangeFMember);
			dialog.setLayout(null);
			dialog.setLocation(500, 250);
			dialog.setSize(500, 300);
			dialog.add(textField);
			textField.setBounds(10, 10, 300, 30);
			dialog.add(NeutralFMember);
			dialog.add(BlackFMember);
			dialog.add(WhiteFMember);
			dialog.add(OrangeFMember);
			dialog.add(buttonConfirm);
			
			NeutralFMember.setBounds(50, 100, 80, 20);
			BlackFMember.setBounds(150, 100, 80, 20);
			OrangeFMember.setBounds(250, 100, 80, 20);
			WhiteFMember.setBounds(350, 100, 80, 20);
			buttonConfirm.setBounds(210, 180, 60, 35);
			
			NeutralFMember.setVisible(true);
			BlackFMember.setVisible(true);
			WhiteFMember.setVisible(true);
			OrangeFMember.setVisible(true);
			buttonConfirm.setVisible(true);
			buttonConfirm.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==buttonConfirm)
						dialog.dispose();
					
				}
			});			
			NeutralFMember.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(NeutralFMember.isSelected()){
						NeutralFMember.setVisible(false);
					}
					
				}
			});
			

			
			BlackFMember.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(BlackFMember.isSelected()){
						BlackFMember.setVisible(false);
					}
					
				}
			});
			WhiteFMember.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(WhiteFMember.isSelected()){
						WhiteFMember.setVisible(false);
					}
					
				}
			});
			OrangeFMember.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(OrangeFMember.isSelected()){
						//OrangeFMember.setEnabled(false);
						OrangeFMember.setVisible(false);
					}
					
				}
			});
			
			dialog.setVisible(true);
			dialog.getContentPane().setBackground(Color.red);
			dispose();
			
		
		if(e.getSource()==button2){
			dispose();
		}
		
		
	}
		
}
	
		
}

