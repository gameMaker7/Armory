package Quests;

import Items.Gen;
import Items.Items;
import Swing.Akatar;
import Swing.BasicWindow;
import Swing.CombatWindow;
import Swing.QuestWindow;

public class Castle extends Dungeons {
	private static final long serialVersionUID = -5475907832250522174L;
	private boolean guessingGame = false;
	private boolean questionGame = false;
	private boolean pain = false;
	

	public Castle(String name, int level, Items reward, String type) {
		super(name, level, reward, type);
		getLocations()[0] = "Library";
		getLocations()[1] = "Throne Room";
		getLocations()[2] = "Ramparts";
		getLocations()[3] = "Dining Hall";
		getLocations()[4] = "Armory";
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
			BasicWindow quest = new BasicWindow("Kevin tries to break into the throne room but trips an alarm.\nThe guards arrest you by mistake.");
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

		CombatWindow fight = new CombatWindow(this);
	}


}
