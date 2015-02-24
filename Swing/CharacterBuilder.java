package Swing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Group.Hclasses;
import Setup.Game;

public class CharacterBuilder extends JFrame implements ActionListener{

	private JButton exit;
	private JButton create;
	private JTextField typeSpace;
	private JComboBox<Hclasses> classes;
	private JPanel recruit;
	public CharacterBuilder(){
		super("Recrutment Office");
		build();
		content();
		finalStuff();
		
	}
	
	private void finalStuff() {
		this.add(recruit);
		this.pack();
		this.setLocation(1920/2 -(this.getWidth()), 1080/2 - (this.getHeight()));
		this.setVisible(true);		
	}

	private void content() {
		exit = new JButton("Exit");
		create = new JButton("Create");
		typeSpace = new JTextField("", 5);
		classes = new JComboBox<Hclasses>();
		
		for(Hclasses s: Hclasses.values()){
			classes.addItem(s);
		}
		
		exit.addActionListener(this);
		create.addActionListener(this);
		typeSpace.addActionListener(this);
		
		recruit.add(exit);
		recruit.add(create);
		recruit.add(typeSpace);
		recruit.add(classes);
		
	}

	private void build() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = new Dimension(300, 400);
		this.setPreferredSize(d);
		recruit = new JPanel();		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit){
			this.dispose();
		}
		if(e.getSource() == create){
			Akatar.getParty().createHero(typeSpace.getText(), (Hclasses)classes.getSelectedItem());
			Akatar.getTavern().updatesheroes();
			this.dispose();
		}
		
	}

}
