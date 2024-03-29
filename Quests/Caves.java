package Quests;

import Items.Gen;
import Items.Items;
import Swing.Akatar;
import Swing.BasicWindow;
import Swing.QuestWindow;

public class Caves extends Dungeons {
	private static final long serialVersionUID = -7842759033199408207L;
	private boolean guessingGame = false;
	private boolean questionGame = false;
	private boolean pain = false;

	public Caves(String name, int level, Items reward, String type) {
		super(name, level, reward, type);
		getLocations()[0] = "Mushroom Cave";
		getLocations()[1] = "Underground Lake";
		getLocations()[2] = "Large Chamber";
		getLocations()[3] = "Dangerous Cliff";
		getLocations()[4] = "bottomless Pit";
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
			BasicWindow quest = new BasicWindow("Kevin asks you to go find some mushrooms.\nYou find a dragon's cave instead. All heroes evacuated.");
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
		System.out.println("Inside the cave you find fred");
	}

}
