package Group;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import Setup.Game;
import Swing.Akatar;

public class HeroList implements Serializable{
	private static final long serialVersionUID = 8595377636720334342L;
	public static Random gen = new Random();
	protected ArrayList<Hero> list  = new ArrayList<Hero>();
	
	public void add(Hero obj){
		list.add(obj);
	}
	public void addFromParty(Hero obj){
		obj.inTeam = false;
	}
	public void addToTeam(Hero obj){
		list.add(obj);
		obj.inTeam = true;
	}
	public void remove(Hero hero){
		list.remove(hero);
	}
	public Hero scry(int i){
		return list.get(i);
	}
	public int teamLevel(){
		int i = 0;
		for(Hero hero: list){
			i += hero.effectiveRank();
		}
		i = i/list.size();
		return i;
	}
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		for(Object c: list){
			result.append(c + "\n");
		}
		return result.toString();
	}
	public void shuffle(){
		for(int i = 0; i<list.size(); i++){

			int grab = gen.nextInt(list.size());
			int place = gen.nextInt(list.size());
			Hero temp = list.get(grab);

			list.set(grab, list.get(place));
			list.set(place, temp);
		}
	}
	public int length(){
		return list.size();
	}
	public ArrayList<Hero> getList() {
		return list;
	
	}

}
