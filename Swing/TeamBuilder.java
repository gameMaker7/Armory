package Swing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Group.Hero;

public class TeamBuilder extends JFrame implements ActionListener{
	private static final long serialVersionUID = 3379562373624676995L;
	private JButton exit;
	private JButton team;
	private JComboBox<Hero> member1;
	private JPanel TeamContruct;
	private JComboBox<Hero> member2;
	private JComboBox<Hero> member3;
	private JComboBox<Hero> member4;
	public TeamBuilder(){
		super("Adventurer's Tavern");
		build();
		content();
		finalStuff();
	}

	private void finalStuff() {
		this.add(TeamContruct);
		this.pack();
		this.setLocation(1920/2 -(this.getWidth()), 1080/2 - (this.getHeight()));
		this.setVisible(true);		
	}

	private void content() {
		exit = new JButton("Exit");
		team = new JButton("Set Team");
		member1 = new JComboBox<Hero>();
		member2 = new JComboBox<Hero>();
		member3 = new JComboBox<Hero>();
		member4 = new JComboBox<Hero>();
		for(Hero hero: Akatar.getParty().adventure.getList()){
			Akatar.getParty().heroes.addFromParty(hero);
		}
		Akatar.getParty().adventure.getList().clear();

		for(Hero hero: Akatar.getParty().heroes.getList()){
			member1.addItem(hero);
		}
		for(Hero hero: Akatar.getParty().heroes.getList()){
			member2.addItem(hero);
		}
		for(Hero hero: Akatar.getParty().heroes.getList()){
			member3.addItem(hero);
		}
		for(Hero hero: Akatar.getParty().heroes.getList()){
			member4.addItem(hero);
		}

		exit.addActionListener(this);
		team.addActionListener(this);

		TeamContruct.add(exit);
		TeamContruct.add(member1);
		if(Akatar.getParty().heroes.length() != 1){
		TeamContruct.add(member2);
		}
		if(Akatar.getParty().heroes.length() > 2){
		TeamContruct.add(member3);
		}
		if(Akatar.getParty().heroes.length() > 3){
		TeamContruct.add(member4);
		}
		TeamContruct.add(team);		
	}

	private void build() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = new Dimension(300, 400);
		this.setPreferredSize(d);

		TeamContruct = new JPanel();		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit){
			this.dispose();
		}
		if(e.getSource() == team){
			buildTeam();
			this.dispose();
		}

	}		


	private void buildTeam() {
		Akatar.getParty().adventure.addToTeam((Hero)member1.getSelectedItem());
		if(member2.getSelectedItem() != member1.getSelectedItem()){
			Akatar.getParty().adventure.addToTeam((Hero)member2.getSelectedItem());
		}
		if(member3.getSelectedItem() != member1.getSelectedItem() && member3.getSelectedItem() != member1.getSelectedItem()){
			Akatar.getParty().adventure.addToTeam((Hero)member3.getSelectedItem());
		}
		if(member4.getSelectedItem() != member1.getSelectedItem() && member4.getSelectedItem() != member1.getSelectedItem() && member4.getSelectedItem() != member3.getSelectedItem()){
			Akatar.getParty().adventure.addToTeam((Hero)member4.getSelectedItem());
		}
		Akatar.getTavern().updatesheroes();
	}

}
