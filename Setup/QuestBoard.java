package Setup;

import java.io.Serializable;

import javax.swing.JComboBox;

import Group.Party;
import Items.Gen;
import Quests.DungeonTypes;
import Quests.Dungeons;
import Quests.Locations;
import Quests.QuestList;
import Quests.QuestNames;

public class QuestBoard implements Serializable{
	private static final long serialVersionUID = 6955602939807084210L;
	private static QuestList boardjobs = new QuestList();
	private static boolean diffrences;
	public QuestBoard(){
		createQuests();
	}

	public static void createQuests() {
		for(Locations a: Locations.values()){
			diffrences = Gen.gen.nextBoolean();
			if(diffrences){
				for(DungeonTypes b: DungeonTypes.values()){
					diffrences = Gen.gen.nextBoolean();				
					if(diffrences){
						for(QuestNames c: QuestNames.values()){	
							diffrences = Gen.gen.nextBoolean();
							String location = a + " " + b;
							if(diffrences){
								boardjobs.add((Dungeons)Dungeons.generateQuest(c.questName(), c.questReward(), location, c.questType()));
							}
						}
					}
				}
			}
		}		
	}
	public QuestList getJobs() {
		return boardjobs;
	}

	public void listAll(JComboBox task){
		boardjobs.listAll(task);
	}

}
