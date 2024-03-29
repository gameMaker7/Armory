package Swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Group.Hclasses;
import Items.Book;
import Items.Dagger;
import Items.Gen;
import Items.Potion;
import Items.Relic;
import Items.Staff;
import Items.Sword;
import Items.Types;
import Quests.Dungeons;
import Quests.JabarsQuestions;
import Setup.Game;

public class CombatWindow extends JFrame implements ActionListener{

	private JLabel alert;
	private JPanel alertWindow;
	private int x;
	private JButton result;
	private Dungeons dungeon;
	private JButton[] locations = new JButton[5];


	public CombatWindow(Dungeons d) {
		super("Combat Quest");
		dungeon = d;
		build();
		x = Gen.gen.nextInt(dungeon.getLocations().length);
		content();
		finalStuff();
	}

	private void finalStuff() {
		alertWindow.add(result);
		this.add(alertWindow);		
		this.pack();
		this.setLocation(1920/2 -(this.getWidth()), 1080/2 - (this.getHeight()));
		this.setVisible(true);		
	}
	private void content() {
		for(int i = 0; i<dungeon.getLocations().length; i++){
			locations[i] = new JButton(dungeon.getLocations()[i]);
			locations[i].addActionListener(this);
			alertWindow.add(locations[i]);
		}
		result.addActionListener(this);		
		alertWindow.add(alert);
	}
	private void build() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = new Dimension(400, 400);
		this.setPreferredSize(d);
		alertWindow = new JPanel();

	}
	@Override
	public void actionPerformed(ActionEvent e) {

	}
}


