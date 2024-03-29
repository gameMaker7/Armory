package Quests;

import Items.Gen;
import Items.Items;
import Swing.Akatar;
import Swing.BasicWindow;
import Swing.QuestWindow;

public class Ruins extends Dungeons {
	private static final long serialVersionUID = 9040242818754332567L;

	private boolean guessingGame = false;
	private boolean questionGame = false;
	private boolean pain = false;

	public Ruins(String name, int level, Items reward, String type) {
		super(name, level, reward, type);
		getLocations()[0] = "Graveyard";
		getLocations()[1] = "Hag's Hut";
		getLocations()[2] = "Wolves Den";
		getLocations()[3] = "Goblin Camp";
		getLocations()[4] = "Tavern";
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
			BasicWindow quest = new BasicWindow("Kevin is sitting on an old pillar however when you try to sit next to him you discover it is a witch disguised as him.");
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
		System.out.println("Beneath a crumling pillar you find fred");

	}

}
