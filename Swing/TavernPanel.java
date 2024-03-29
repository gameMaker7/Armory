package Swing;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Group.Hero;
import Setup.Game;

public class TavernPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = -2687357554675536626L;
	JButton recruit = new JButton("Recruit");
	JButton dismiss = new JButton("Dismiss");
	JComboBox<Hero> heroes = new JComboBox<Hero>();
	private JButton team = new JButton("Team");
	private JButton save = new JButton("Save");
	private JButton info = new JButton("Hero Info");
	private JButton fame = new JButton("Current Fame");

	public TavernPanel(){
		heroList();
		buttons();
	}
	private void buttons() {
		recruit.addActionListener(this);
		dismiss.addActionListener(this);
		info.addActionListener(this);
		team.addActionListener(this);
		fame .addActionListener(this);
		save .addActionListener(this);
		this.add(team);
		this.add(dismiss);
		this.add(recruit);
		this.add(info);
		this.add(fame);
		this.add(save);

	}
	private void heroList(){
		this.add(heroes);
	}
	public void updatesheroes(){
		for(Hero remove: Akatar.getParty().heroes.getList()){
			heroes.removeItem(remove);
		}

		for(int i =0; i< heroes.getItemCount(); i++){
			heroes.removeItemAt(i);
		}

		for(Hero hero: Akatar.getParty().heroes.getList()){

			heroes.addItem(hero);
		}		
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//DO THE STUFF
		if(e.getSource() == recruit){
			CharacterBuilder character = new CharacterBuilder();

		}
		if(e.getSource() == fame){
			BasicWindow alert = new BasicWindow("Current Fame: " + Akatar.getParty().getFame());
		}
		if(e.getSource() == team){
			if(Akatar.getParty().heroes.length() != 0){
			TeamBuilder teambuild = new TeamBuilder();
			}else{
				BasicWindow alert = new BasicWindow("need Heroes to form a team.");
			}

		}
		if(e.getSource() == info){
			if(Akatar.getParty().heroes.length() != 0){
				HeroInfo HeroInfo = new HeroInfo((Hero)heroes.getSelectedItem());
			}else{
				BasicWindow alert = new BasicWindow("No heroes in tavern.");
			}
		}
		if(e.getSource() == save){
			Akatar.game.save();
		}
		if(e.getSource() == dismiss){
			if(Akatar.getParty().heroes.length() == 0){
				BasicWindow alert = new BasicWindow("No heroes in tavern.");	
			}else{
				Dismissal leave = new Dismissal();
				updatesheroes();
				//			heroes.remove(comp);
			}
		}
	}

	class Dismissal extends JFrame implements ActionListener{
		private static final long serialVersionUID = -1285278787960887147L;
		private JButton exit;
		private JButton create;
		private JComboBox<Hero> heroes;
		private JPanel dismiss;
		public Dismissal(){
			super("Dissmal");
			build();
			content();
			finalStuff();

		}

		private void finalStuff() {
			this.add(dismiss);

			this.pack();
			this.setLocation(1920/2 -(this.getWidth()), 1080/2 - (this.getHeight()));
			this.setVisible(true);			
		}

		private void content() {
			exit = new JButton("Exit");
			create = new JButton("Dismiss");
			heroes = new JComboBox<Hero>();

			for(Hero hero: Akatar.getParty().heroes.getList()){
				heroes.addItem(hero);
			}	

			exit.addActionListener(this);
			create.addActionListener(this);

			dismiss.add(exit);
			dismiss.add(create);
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
			if(e.getSource() == create){
				if(Akatar.getParty().heroes.length() == 1){
					BasicWindow alert = new BasicWindow("Cannot Dismiss Heroes at this time.");
				}else{
					Akatar.getParty().heroes.remove((Hero)heroes.getSelectedItem());
				}
				Akatar.getTavern().updatesheroes();
				this.dispose();
			}

		}

	}


}
