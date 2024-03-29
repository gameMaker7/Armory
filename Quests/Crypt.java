package Quests;

import Items.Gen;
import Items.Items;
import Swing.Akatar;
import Swing.BasicWindow;
import Swing.QuestWindow;

public class Crypt extends Dungeons {
	private static final long serialVersionUID = 5537721451642611288L;
	private boolean guessingGame = false;
	private boolean questionGame = false;
	private boolean pain = false;
	
	public Crypt(String name, int level, Items reward, String type) {
		super(name, level, reward, type);
		getLocations()[0] = "Graveyard";
		getLocations()[1] = "Tomb";
		getLocations()[2] = "Chamber One";
		getLocations()[3] = "Chamber Two";
		getLocations()[4] = "Pitfall";
	}

	@Override
	public void run() {
		switch(type){
		case "Clear Zone":
			slay();
			break;
		case "Kevin Jabar":
			kevin();
			break;
		}
	}

	private void kevin() {
		gameCheck();
		if(guessingGame){
			QuestWindow quest = new QuestWindow(true, this);
		}else if(questionGame){
			QuestWindow.jabar();
			QuestWindow quest = new QuestWindow(0, this);
		}else if(pain){
			BasicWindow quest = new BasicWindow("Kevin is trapped behind an army of undead, but they decide you look more interesting.");
			this.fame(Akatar.getParty());
		}
	}

	private void gameCheck() {

		int a = Gen.gen.nextInt(3);
		System.out.println(a);
		if(a == 0)pain = true;
		if(a == 1)questionGame = true;
		if(a == 2)guessingGame = true;
	}


	private void slay() {
		System.out.println("Inside the crypt you find fred");

	}

}
