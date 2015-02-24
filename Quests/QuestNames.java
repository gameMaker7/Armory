package Quests;

import Items.Dagger;
import Items.Gen;
import Items.Items;
import Items.Scroll;
import Swing.Akatar;

public enum QuestNames {
	QuestOne, QuestTwo;
	public String questName(){
		String name = null;
		
		switch(this){
		case QuestOne:
			name = "Clear Zone";
			break;
		case QuestTwo:
			name = "Kevin Jabar";
			break;
		default:
			break;

		}
		return name;

	}
	public String questType(){
		String name = null;
		switch(this){
		case QuestOne:
			name = "rescue";
			break;
		case QuestTwo:
			name = "Kevin Jabar";
		default:
			break;

		}
		return name;

	}
	public Items questReward(){
		Items item = null;
		switch(this){
		case QuestOne:
			item = Akatar.getLoot().getList().get(0);
			Akatar.getLoot().getList().remove(0);
			break;
		case QuestTwo:
			item = new Scroll("Compensation", true);
		default:
			break;
		}
		return item;
	}
}
