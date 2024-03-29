package Quests;

import Items.Gen;
import Items.Items;
import Swing.Akatar;
import Swing.BasicWindow;
import Swing.QuestWindow;

public class Forest extends Dungeons {
	private static final long serialVersionUID = -4842543061331281394L;
	private boolean guessingGame = false;
	private boolean questionGame = false;
	private boolean pain = false;

	public Forest(String name, int level, Items reward, String type) {
		super(name, level, reward, type);
		getLocations()[0] = "Inner Forest";
		getLocations()[1] = "Outer Forest";
		getLocations()[2] = "lake";
		getLocations()[3] = "Dark Zone";
		getLocations()[4] = "Elven Lands";
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
			BasicWindow quest = new BasicWindow("Kevin says his cat is stuck in a tree. It turns out to be a tiger.");
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
		System.out.println("Next to a tree you find fred. He is asleep.");

	}

}
