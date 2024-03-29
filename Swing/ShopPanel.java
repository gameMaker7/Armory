package Swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import Group.Hero;
import Items.Store;
import Setup.Game;

public class ShopPanel extends JPanel implements ActionListener{
	JButton buy = new JButton("Buy");
	JButton sell = new JButton("Sell");
	JButton create = new JButton("Create");


	public ShopPanel(){
		buttons();
	}



	private void buttons() {
		create.addActionListener(this);
		buy.addActionListener(this);
		sell.addActionListener(this);
		this.add(sell);
		this.add(create);
		this.add(buy);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//DO THE STUFF
		if(e.getSource() == create){
			ItemBuilder creation = new ItemBuilder();
		}
		if(e.getSource() == buy){
			if(Akatar.getParty().adventure.length() == 0){
				BasicWindow alert = new BasicWindow("Need Adventure Team.");
			}else{
				Buyer buyer = new Buyer();
			}
		}
		if(e.getSource() == sell){
			SellWindow seller = new SellWindow(Akatar.getAdventure().scry(0));
		}
	}

}

