package Items;


import java.io.Serializable;
import java.util.ArrayList;

import Group.Hero;
import Swing.BasicWindow;
import Swing.LootWindow;

public class Store implements Serializable{
	private static final long serialVersionUID = 7174045396018797906L;
	private ArrayList<Items> list  = new ArrayList<Items>();

	public void add(Items obj){
		getList().add(obj);
	}
	public boolean buy(Hero hero, Items item){
		if(item.getValue()>hero.getGold()){
			BasicWindow alert = new BasicWindow("Not Enough Gold");
			return false;
		}
		return true;
	}
	public Items scry(int i){
		return getList().get(i);
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		for(Items c: getList()){
			result.append(c + "\n");
		}
		return result.toString();
	}

	public int length(){
		return getList().size();
	}
	public Items inventory(String s){
		for(Items x: getList()){
			if(x.getName().equals((s))){
				return x;
			}
		}
		return null;
	}
	public void sell(Hero hero, Items item) {
		int value = item.getValue();
		hero.setGold(value, 0);
		hero.getBag().pull(item);
		getList().add(item);


	}
	public ArrayList<Items> getList() {
		return list;
	}
	public void remove(Items item) {
		list.remove(item);
	}
}
