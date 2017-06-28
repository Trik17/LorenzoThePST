
package it.polimi.ingsw.GC_04.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import javax.jws.HandlerChain;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;

import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.model.card.TerritoryCard;


public class Buttons extends JFrame implements ActionListener{
	
	private JLabel labelCard;
	private JLabel label;
	public ImageIcon Card;
	public ImageIcon Card1;
	
	public JButton button1;
	private JButton button2;
	
	private TextField textField;
	public  Buttons(){	
		super("Carta Selezionata");
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(500,100);
		setResizable(true);
		

		
		//setLayout(new FlowLayout(10, 10, 10));
		setLayout(new FlowLayout());//setLocation(150,0);
		//textField = new TextField(20);
		labelCard = new JLabel(Card);
		labelCard.setLayout(null);
		Card = new ImageIcon(getClass().getResource("/TerritoryCard/devcards_f_en_c_6.png"));
		Card1= new ImageIcon(getClass().getResource(("/TerritoryCard/devcards_f_en_c_6.png")));
		
		add(labelCard);
		labelCard.setIcon(Card);
		
		labelCard.setLayout(null);
		label = new JLabel("Do you want to take this card?");
		
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
			TextField textField = new TextField("Quale family member vuoi mettere?");
			
			JCheckBox BlackMember = new JCheckBox("Black",false);
			JCheckBox WhiteFMember = new JCheckBox("White",false);
			JCheckBox OrangeFMember = new JCheckBox("Orange",false);
			JCheckBox NeutralFMember = new JCheckBox("Neutral",false);
			dialog.setLayout(null);
			dialog.setLocation(500, 250);
			dialog.setSize(500, 300);
			dialog.add(textField);
			textField.setBounds(10, 10, 300, 30);
			dialog.add(NeutralFMember);
			dialog.add(BlackMember);
			dialog.add(WhiteFMember);
			dialog.add(OrangeFMember);
			NeutralFMember.setBounds(50, 100, 80, 20);
			BlackMember.setBounds(150, 100, 80, 20);
			OrangeFMember.setBounds(250, 100, 80, 20);
			WhiteFMember.setBounds(350, 100, 80, 20);
			NeutralFMember.setVisible(true);
			BlackMember.setVisible(true);
			WhiteFMember.setVisible(true);
			OrangeFMember.setVisible(true);
			dialog.setVisible(true);
			dialog.getContentPane().setBackground(Color.green);
			dispose();
		
		if(e.getSource()==button2){
			dispose();
		}
		}}	
}

