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
import Group.Hero;
import Items.Items;
import Setup.Game;

public class Buyer extends JFrame implements ActionListener{

	private JButton exit;
	private JButton buy;
	private JComboBox<Items> items;
	private JPanel dismiss;
	private JComboBox<Hero> heroes;
	public Buyer(){
		super("Merchant");
		build();
		content();
		finalStuff();
	}

	private void finalStuff(){
		this.add(dismiss);
		this.pack();
		this.setLocation(1920/2 -(this.getWidth()), 1080/2 - (this.getHeight()));
		this.setVisible(true);		
	}

	private void content() {
		exit = new JButton("Exit");
		buy = new JButton("Buy");
		items = new JComboBox<Items>();
		heroes = new JComboBox<Hero>();
		for(Hero hero: Akatar.getParty().adventure.getList()){
			heroes.addItem(hero);
		}	
		for(Items item: Akatar.getShop().getList()){
			items.addItem(item);
		}	
		exit.addActionListener(this);
		buy.addActionListener(this);
		dismiss.add(exit);
		dismiss.add(buy);
		dismiss.add(items);
		dismiss.add(heroes);		
	}

	private void build() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = new Dimension(300, 400);
		this.setPreferredSize(d);

		dismiss = new JPanel();		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit){
			this.dispose();
		}
		if(e.getSource() == buy){
			if(Akatar.getShop().buy((Hero)heroes.getSelectedItem(), (Items)items.getSelectedItem())){
			EquipMenu equip = new EquipMenu((Hero)heroes.getSelectedItem(), (Items)items.getSelectedItem());
			}
			this.dispose();
		}

	}

}
