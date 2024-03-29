package Quests;

import java.io.Serializable;

import Group.Hero;
import Group.HeroList;
import Group.Party;
import Items.Gen;
import Items.Items;
import Setup.Game;
import Swing.Akatar;
import Swing.BasicWindow;
import Swing.LootWindow;

public abstract class Dungeons implements Serializable{
	private static final long serialVersionUID = -4718436442586569560L;
	private static int maxLevel = 10;
	private int fame;
	private static int low = 1;
	private String name;
	private int minLevel;
	private Items reward;
	protected String type;
	private String[] locations = new String[5];
	public Dungeons(String name, int level, Items reward, String type){
		this.name = name;
		minLevel = level;
		this.type = type;
		this.reward = reward;
	}

	@Override
	public String toString() {
		return name + " Lv: " + minLevel;
	}

	public void addReward(){
		if(reward.getType().equalsIgnoreCase("Scroll")){
			reward.setRank((reward.getRank()/2) + 1);
		}
		LootWindow equip = new LootWindow(reward);
		Akatar.getParty().setFame(this.fame);
	}
	public Items getReward() {
		return reward;
	}
	public int fame(Party party){
		fame += minLevel * 25;
		fame -= party.adventure.length() * 10;
		party.setFame(fame);
		for(Hero h: party.adventure.getList()){
			h.setExp(25*minLevel);
			if(minLevel == maxLevel){
				maxLevel += 5;
				low ++;
			}
		}
		return fame;
	}
	public static int getMaxLevel() {
		return maxLevel;
	}
	public String getName() {
		return name;
	}
	public int getMinLevel() {
		return minLevel;
	}
	public static Object generateQuest(String questName, Items questReward, String location, String type) {
		Object dungeon = null;
		questName = questName + " Location: " + location;
		if(location.contains("Forest")){
			dungeon = new Forest(questName, Gen.gen.nextInt(maxLevel) + low, questReward, type);
		}
		else if(location.contains("Castle")){
			dungeon = new Castle(questName, Gen.gen.nextInt(maxLevel) + low, questReward, type);
		}
		else if(location.contains("Ruins")){
			dungeon = new Ruins(questName, Gen.gen.nextInt(maxLevel) + low, questReward, type);
		}
		else if(location.contains("Swamp")){
			dungeon = new Swamp(questName, Gen.gen.nextInt(maxLevel) + low, questReward, type);
		}
		else if(location.contains("Caves")){
			dungeon = new Caves(questName, Gen.gen.nextInt(maxLevel) + low, questReward, type);
		}
		else if(location.contains("Mountains")){
			dungeon = new Mountains(questName, Gen.gen.nextInt(maxLevel) + low, questReward, type);
		}
		else if(location.contains("Crypt")){
			dungeon = new Crypt(questName, Gen.gen.nextInt(maxLevel) + low, questReward, type);
		}
		return dungeon;

	}
	public abstract void run();

	public void questComplete() {
		BasicWindow alert = new BasicWindow("Quest Complete");
		addReward(); 
	}

	public String[] getLocations() {
		return locations;
	}
}
