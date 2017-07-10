package it.polimi.ingsw.GC_04.client.view.gui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


public class TowerButtons extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 846399119848604553L;

	GameBoardGUI gui;

	private JLabel label;
	private JLabel labelCard;
	private ButtonGroup group;
	private JRadioButton black;
	private JRadioButton orange;
	private JRadioButton white;
	private JRadioButton neutral;
	private TextField text;
	public JButton confirm;
	private JButton decline;
	private ImageIcon blackFMember;
	private ImageIcon whiteFMember;
	private ImageIcon orangeFMember;
	private ImageIcon neutralFMember;
	
	public TowerButtons(GameBoardGUI gui, String text, ImageIcon card) {
		super("Selected card");
		this.gui = gui;
	
		setLocation(500,100);
		setResizable(true);
		this.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/immagini/leaders_b_c_00.jpg")));
		
		setLayout(new FlowLayout());
		this.text = new TextField(text);
		this.labelCard = new JLabel(card);
		this.labelCard.setLayout(null);
		add(labelCard);
		this.labelCard.setIcon(card);
		
		label = new JLabel(text);
		label.setForeground(Color.BLACK);
		
		confirm = new JButton("YES");
		decline = new JButton("NO");
		
		confirm.setContentAreaFilled(true);
		decline.setContentAreaFilled(true);
		
		confirm.setBounds(45,400,100,30);
		decline.setBounds(150,400,100,30);
		
		labelCard.add(confirm);
		labelCard.add(decline);
		
		add(label);
		
		confirm.addActionListener(this);
		decline.addActionListener(this);
		
		pack();
		setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == confirm) {

			
			//confirm.setVisible(false);
			//decline.setVisible(false);
			
			JDialog dialog = new JDialog();
			TextField textField = new TextField("Which Family Member do you want to use?");
			textField.setEditable(false);
			ButtonGroup group = new ButtonGroup();
			blackFMember = new ImageIcon(getClass().getResource("/immagini/BlackFamilyMember.png"));
			whiteFMember = new ImageIcon(getClass().getResource("/immagini/WhiteFamilyMember.png"));
			orangeFMember = new ImageIcon(getClass().getResource("/immagini/OrangeFamilyMember.png"));
			neutralFMember = new ImageIcon(getClass().getResource("/immagini/NeutralFamilyMember.png"));
			JRadioButton black = new JRadioButton(blackFMember);
			JRadioButton white = new JRadioButton(whiteFMember);
			JRadioButton orange= new JRadioButton(orangeFMember);
			JRadioButton neutral = new JRadioButton(neutralFMember);
			JButton buttonConfirm = new JButton("OK");
			black.setBackground(Color.BLACK);
			black.setForeground(Color.white);
			neutral.setBackground(Color.LIGHT_GRAY);
			white.setBackground(Color.white);
			orange.setBackground(Color.getHSBColor(100, 1200, 5000));
			group.add(neutral);
			group.add(black);
			group.add(white);
			group.add(orange);
			dialog.setLayout(null);
			dialog.setLocation(500, 250);
			dialog.setSize(500, 300);
			dialog.add(textField);
			textField.setBounds(10, 10, 300, 30);
			dialog.add(neutral);
			dialog.add(black);
			dialog.add(white);
			dialog.add(orange);
			dialog.add(buttonConfirm);
			
			neutral.setBounds(50, 100, 45, 60);
			black.setBounds(150, 100, 45, 60);
			orange.setBounds(250, 100, 45, 60);
			white.setBounds(350, 100, 45, 60);
			buttonConfirm.setBounds(210, 180, 60, 35);
			
			neutral.setVisible(true);
			black.setVisible(true);
			white.setVisible(true);
			orange.setVisible(true);
			buttonConfirm.setVisible(true);
			buttonConfirm.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == buttonConfirm)
						dialog.dispose();
					
				}
			});
		
	
			dialog.setVisible(true);
			dialog.getContentPane().setBackground(Color.red);
			dispose();
		}
		if ( e.getSource() == decline) {
			dispose();
		}
		
	}
	
	public JButton getConfirm() {
		return confirm;
		
	}
	public JButton getDecline() {
		return decline;
	}
	
	
}
