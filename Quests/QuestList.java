package Quests;


import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;

import javax.swing.JComboBox;

import Group.Party;
import Items.Items;
import Setup.QuestBoard;

public class QuestList implements Serializable{
	private static final long serialVersionUID = 8703797230313621609L;
	public static Random gen = new Random();
	protected Hashtable<Dungeons, Items> list  = new Hashtable<Dungeons, Items>();
	private Enumeration<Dungeons> el = list.keys();
	public QuestList(){

	}
	public void add(Dungeons obj){
		list.put(obj, obj.getReward());
	}
	public Object draw(int i){	
		el = list.keys();
		return list.remove(i);
	}
	public void listAll(JComboBox task) {
		task.removeAllItems();
		el = list.keys();
		if(list.size() <= 1){
			QuestBoard.createQuests();
			el = list.keys();
		}
		while(el.hasMoreElements()){
			Dungeons dungeon = el.nextElement();
			String name = dungeon.getName();
			int level = dungeon.getMinLevel();
			task.addItem((Dungeons)dungeon);
			//			System.err.println("QuestList listAll Ran in loop");
		}
		//		System.err.println("QuestList listAll Ran out of loop");
	}
	public void enter(String quest, Party adventure){
		el = list.keys();
		do{
			Dungeons dungeon = el.nextElement();
			if(quest.equalsIgnoreCase(dungeon.getName())){
				if(adventure.lowestLevel() < dungeon.getMinLevel()){
					System.out.println("Level to low. Lowest Level allowed: " + dungeon.getMinLevel());
					adventure.returnHeroes();
					return;
				}
				dungeon.run();
				dungeon.fame(adventure);
				list.remove(dungeon);
				adventure.returnHeroes();
				return;
			}
		}while(el.hasMoreElements());
		System.out.println("No quests fit that description.");
		adventure.returnHeroes();
	}
	public void remove(Dungeons dungeon) {
		list.remove(dungeon);
	}
}
