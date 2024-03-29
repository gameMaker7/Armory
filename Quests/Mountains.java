package Quests;

import Items.Gen;
import Items.Items;
import Swing.Akatar;
import Swing.BasicWindow;
import Swing.QuestWindow;

public class Mountains extends Dungeons {
	private static final long serialVersionUID = -2095052731681432742L;
	private boolean guessingGame = false;
	private boolean questionGame = false;
	private boolean pain = false;
	
	public Mountains(String name, int level, Items reward, String type) {
		super(name, level, reward, type);
		getLocations()[0] = "Peak";
		getLocations()[1] = "Valley";
		getLocations()[2] = "Bridge";
		getLocations()[3] = "Cavern";
		getLocations()[4] = "Dwarven Village";
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
			BasicWindow quest = new BasicWindow("kevin wants you to go rock climbing. He forgot to back a map or compass.");
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
		System.out.println("At the top of the mountain you find fred.");
		
	}

}
