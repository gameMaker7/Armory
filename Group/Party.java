package Group;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Items.Items;
import Setup.Game;


public class Party implements Serializable{
	private static final long serialVersionUID = 7112025627906110126L;
	public HeroList heroes = new HeroList();
	private int fame = 0;
	public HeroList adventure = new HeroList();
	private Bag bagOfHolding = new Bag();
	public void createHero(String name, Hclasses hero){
		String s = name;
		Hclasses a = hero;
		switch(a){
		case Mage:
			heroes.add(new Mage(s, a));
			break;
		case Assassin:
			heroes.add(new Assassin(s, a));
			break;
		case Warrior:
			heroes.add(new Warrior(s, a));
			break;
		default:
			break;
		}
	}


	public Bag getBagOfHolding() {
		return bagOfHolding;
	}
	public void heroLevel(){
		for(int i = 0; i< heroes.length(); i ++){
			Hero s = (Hero) heroes.scry(i);
			System.out.print(s.getName() + " Level: ");
			System.out.println(s.effectiveRank());
		}
	}
	public Hero showHeros(){
		System.out.println("Choose Hero (Enter name)");
		for(Hero x: heroes.list){
			System.out.println("Lv." + x.effectiveRank() + " " + x.getType() + " " + x.getName() + " Gold: " + x.getGold());
		}
		String x = Game.input.nextLine();
		for(Hero a: heroes.list){
			if(a.getName().equalsIgnoreCase(x)){
				return a;
			}
		}
		System.out.println("Incorrect Input");
		return null;
	}

	public void buildTeam(Party party) {
		adventure.list.clear();
		while(heroes.list.size() < 4){
			System.out.println("Add Hero?");
			String x = Game.input.nextLine();
			if(x.equalsIgnoreCase("yes")){
				Hero hero = showHeros();
				adventure.add(hero);
				heroes.remove(hero);
			}
			if(x.equalsIgnoreCase("no")){
				return;
			}
		}	


	}

	public int getFame() {
		return fame;
	}

	public int lowestLevel() {		
		int lv = 100;
		for(Hero h: adventure.getList()){
			if(h.effectiveRank() < lv){
				lv = h.effectiveRank();
			}
		}
		return lv;
	}

	public void returnHeroes() {
		ArrayList<Hero> clone = adventure.list;
		for(Hero hero: clone){
			heroes.add(hero);
		}
	}

	public void dismiss() {
		heroes.remove(showHeros());		
	}


	public void setFame(int fame2) {
		fame = fame + fame2;		
	}
}
