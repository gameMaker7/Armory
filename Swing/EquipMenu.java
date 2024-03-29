package Swing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Group.Hclasses;
import Group.Hero;
import Items.Items;
import Setup.Game;

public class EquipMenu extends JFrame implements ActionListener{

	private JButton exit;
	private JButton equipM;
	private JPanel dress;
	private JLabel mainHand = new JLabel();
	private JLabel offHand = new JLabel();
	private JLabel extra = new JLabel();
	private JLabel items;
	private JButton equipO;
	private JButton equipE;
	private JButton store;
	private Hero hero;
	private Items item;
	private JComboBox<Items> main;
	private JComboBox<Items> off;
	private JComboBox<Items> ex;

	public EquipMenu(Hero hero2, Items items2){
		super("Dressing Room");
		dress = new JPanel();
		buildMenu(hero2);
		boughtEquip(items2);	
		finalStuff();
	}

	private void finalStuff() {
		exit.addActionListener(this);

		dress.add(exit);
		this.add(dress);

		this.pack();
		this.setLocation(1920/2 -(this.getWidth()), 1080/2 - (this.getHeight()));
		this.setVisible(true);		
	}

	private void boughtEquip(Items items2) {
		item = items2;
		itemCheck(hero);
		items = new JLabel("" + item);
		exit = new JButton("Exit");
		equipM = new JButton("Equip To Main Hand");
		equipO = new JButton("Equip To Off Hand");
		equipE = new JButton("Equip To Extra Weapon");
		store = new JButton("Store in bag.");

		equipM.addActionListener(this);
		equipO.addActionListener(this);
		equipE.addActionListener(this);

		dress.add(items);
		dress.add(mainHand);
		dress.add(equipM);
		dress.add(offHand);
		dress.add(equipO);
		dress.add(extra);
		dress.add(equipE);
		dress.add(store);

	}

	public EquipMenu(Hero hero2) {
		dress = new JPanel();
		buildMenu(hero2);
		hero.getBag().unequip();
		resetItems();
		buildOtherMenu();
		finalStuff();

	}

	private void buildOtherMenu() {
		dress.add(main);
		dress.add(off);
		dress.add(ex);

	}

	private void resetItems() {
		main = new JComboBox<Items>();
		off = new JComboBox<Items>();
		ex = new JComboBox<Items>();
		for(Items item: hero.getBag().getList()){
			main.addItem(item);
		}
		for(Items item: hero.getBag().getList()){
			if(item != main.getSelectedItem()){
				off.addItem(item);
			}
		}
		for(Items item: hero.getBag().getList()){
			if(item != main.getSelectedItem() && item != off.getSelectedItem()){
				ex.addItem(item);
			}
		}
	}

	public  void buildMenu(Hero hero2){
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = new Dimension(600, 400);
		this.setPreferredSize(d);
		hero = hero2;
	}
	private void itemCheck(Hero hero) {

		if(hero.getMainEquip() == null){
			mainHand = new JLabel("Main Hand Item: None");
		}else{
			mainHand = new JLabel("Main Hand Item: " + hero.getMainEquip());
		}
		if(hero.getOffEquip() == null){
			offHand = new JLabel("Off Hand Item: None");
		}else{
			offHand = new JLabel("Off Hand Item: " + hero.getOffEquip());
		}
		if(hero.getExtra() == null){
			extra = new JLabel("Extra Weapon: None");
		}else{
			extra = new JLabel("Extra Weapon: " + hero.getExtra());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit){
			this.dispose();
		}
		if(e.getSource() == store){
			if(hero.getSlots() < item.getWieght()){
				BasicWindow alert = new BasicWindow("Cannot carry bag capacity reached");
				return;
			}else{
			hero.getBag().add(item);
			}
			this.dispose();
		}
		
		if(e.getSource() == equipM){
			if(hero.setMainEquip(item)){
				hero.setGold(0, item.getValue());
				Akatar.getShop().remove(item);
			}
			this.dispose();
		}
		if(e.getSource() == equipO){
			if(hero.setOffEquip(item)){
				hero.setGold(0, item.getValue());
				Akatar.getShop().remove(item);
			}
			this.dispose();
		}
		if(e.getSource() == equipE){
			if(hero.setExtra(item)){
				hero.setGold(0, item.getValue());
				Akatar.getShop().remove(item);
			}
			this.dispose();
		}

	}

}
