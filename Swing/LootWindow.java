package Swing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Group.Hclasses;
import Group.Hero;
import Items.Book;
import Items.Dagger;
import Items.Items;
import Items.Potion;
import Items.Relic;
import Items.Staff;
import Items.Sword;
import Items.Types;
import Setup.Game;

public class LootWindow extends JFrame implements ActionListener{

	private Items reward;
	private JLabel item;
	private JPanel alertWindow;
	private JComboBox<Hero> heroes;
	private JButton give;
	public LootWindow(Items reward){
		super("Loot");
		build();
		content(reward);
		finalStuff();

	}
	private void finalStuff() {
		this.pack();
		this.setLocation(1920/2 -(this.getWidth()), 1080/2 - (this.getHeight()));
		this.setVisible(true);		
	}
	private void content(Items reward) {
		this.reward = reward;
		item = new JLabel("" + reward);		
		give = new JButton("Give Item");		
		heroes = new JComboBox<Hero>(); 
		give.addActionListener(this);
		heroes.addActionListener(this);
		addTeam();
		alertWindow.add(item);
		alertWindow.add(heroes);
		alertWindow.add(give);
		this.add(alertWindow);		
	}
	private void addTeam() {
		for(Hero hero: Akatar.getAdventure().getList()){
			heroes.addItem(hero);
		}
	}
	private void build() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		alertWindow = new JPanel();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == give){
			Hero h = (Hero)heroes.getSelectedItem();
			if(h.getSlots()>reward.getWieght()){
				h.getBag().add(reward);
				this.dispose();
			}else{
				BasicWindow alert = new BasicWindow("Bag Capacity to low.");
			}
		}
	}

}
