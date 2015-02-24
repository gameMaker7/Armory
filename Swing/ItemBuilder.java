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
import Items.Book;
import Items.Dagger;
import Items.Potion;
import Items.Relic;
import Items.Staff;
import Items.Sword;
import Items.Types;
import Setup.Game;

public class ItemBuilder extends JFrame implements ActionListener{

	private JButton exit;
	private JButton create;
	private JTextField typeSpace;
	private JComboBox<Types> items;
	private JPanel itemBuilder;
	public ItemBuilder(){
		super("BlackSmith");
		build();
		content();
		finalStuff();
	}
	
	
	private void finalStuff() {
		this.add(itemBuilder);

		this.pack();
		this.setLocation(1920/2 -(this.getWidth()), 1080/2 - (this.getHeight()));
		this.setVisible(true);		
	}
	private void content() {
		exit = new JButton("Exit");
		create = new JButton("Create");
		typeSpace = new JTextField("", 5);
		items = new JComboBox<Types>();

		for(Types s: Types.values()){
			items.addItem(s);
		}

		exit.addActionListener(this);
		create.addActionListener(this);
		typeSpace.addActionListener(this);

		itemBuilder.add(exit);
		itemBuilder.add(create);
		itemBuilder.add(typeSpace);
		itemBuilder.add(items);		
	}
	private void build() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = new Dimension(300, 400);
		this.setPreferredSize(d);
		itemBuilder = new JPanel();		
	}
	public void createItem(String name, Types types){
		String s = name;
		Types a = types;
		switch(a){
		case Potion:
			Akatar.getShop().add(new Potion(s, false));
			break;
		case Book:
			Akatar.getShop().add(new Book(s, false));
			break;
		case Relic:
			Akatar.getShop().add(new Relic(s, false));	
			break;
		case Dagger:
			Akatar.getShop().add(new Dagger(s, false));
			break;
		case Staff:
			Akatar.getShop().add(new Staff(s, false));	
			break;
		case Sword:
			Akatar.getShop().add(new Sword(s, false));
			break;
		default:
			System.err.println("What the Hell did you do. createitems");
			break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit){
			this.dispose();
		}
		if(e.getSource() == create){
			createItem(typeSpace.getText(), (Types)items.getSelectedItem());
			this.dispose();
		}

	}

}
