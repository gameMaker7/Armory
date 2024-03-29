package Quests;

import Items.Gen;
import Items.Items;
import Swing.Akatar;
import Swing.BasicWindow;
import Swing.QuestWindow;

public class Swamp extends Dungeons {
	private static final long serialVersionUID = -7993201328601941899L;
	private boolean guessingGame = false;
	private boolean questionGame = false;
	private boolean pain = false;

	public Swamp(String name, int level, Items reward, String type) {
		super(name, level, reward, type);
		getLocations()[0] = "Marsh";
		getLocations()[1] = "Ancient Monolith";
		getLocations()[2] = "Bog";
		getLocations()[3] = "plauged Village";
		getLocations()[4] = "ThornWall";
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
			BasicWindow quest = new BasicWindow("You find Kevin swimming in the lake.\nHe seems to be missing his robe.");
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
		System.out.println("Fred's corpse floats in the swampy lake.");
	}
}
