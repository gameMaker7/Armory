package Swing;

import java.awt.Component;
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
import Items.Items;
import Setup.Game;

public class SellWindow extends JFrame implements ActionListener{

	private JButton exit;
	private JButton sellButton;
	private JComboBox<Items> items;
	private JPanel sell;
	private Hero hero;
	private JLabel label;
	public SellWindow(Hero hero2){
		super("Merchant");
		hero = hero2;
		build();
		content();
		finalStuff();
	}

	private void finalStuff(){
		this.add(sell);
		this.pack();
		this.setLocation(1920/2 -(this.getWidth()), 1080/2 - (this.getHeight()));
		this.setVisible(true);		
	}

	private void content() {
		label = new JLabel("Current hero: " + hero);
		exit = new JButton("Exit");
		sellButton = new JButton("Sell");
		items = new JComboBox<Items>();
	
		for(Items item: hero.getBag().getList()){
			items.addItem(item);
		}	
		exit.addActionListener(this);
		sellButton.addActionListener(this);
		sell.add(label);
		sell.add(exit);
		sell.add(sellButton);
		sell.add(items);
	}

	private void build() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = new Dimension(300, 400);
		this.setPreferredSize(d);

		sell = new JPanel();		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit){
			this.dispose();
		}
		if(e.getSource() == sellButton){
			Items item =  (Items) items.getSelectedItem();
			hero.setGold(item.getValue(), 0);
			hero.getBag().pull(item);
			Akatar.getShop().add(item);
			this.dispose();
		}

	}

}
