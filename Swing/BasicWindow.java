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
import Items.Book;
import Items.Dagger;
import Items.Potion;
import Items.Relic;
import Items.Staff;
import Items.Sword;
import Items.Types;
import Setup.Game;

public class BasicWindow extends JFrame implements ActionListener{

	private JButton exit;
	private JLabel alert;
	private JPanel alertWindow;
	public BasicWindow(String label){
		super("Alert");
		build();
		content(label);
		finalStuff();

	}
	private void finalStuff() {
		this.pack();
		this.setLocation(1920/2 -(this.getWidth()), 1080/2 - (this.getHeight()));
		this.setVisible(true);		
	}
	private void content(String label) {
		exit = new JButton("Exit");
		alert = new JLabel(label);		
		exit.addActionListener(this);
		
		alertWindow.add(alert);
		alertWindow.add(exit);
		this.add(alertWindow);		
	}
	private void build() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		alertWindow = new JPanel();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit){
			this.dispose();
		}
	}

}
