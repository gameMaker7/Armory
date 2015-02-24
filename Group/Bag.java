package Group;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import Items.Items;

public class Bag implements Serializable{
	private static final long serialVersionUID = 8822984028969971646L;
	public static Random gen = new Random();
	protected ArrayList<Items> list  = new ArrayList<Items>();

	public void add(Items obj){
		list.add(obj);
	}

	public Items scry(int i){
		return list.get(i);
	}
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		for(Items c: list){
			result.append(c + "\n");
		}
		return result.toString();
	}
	public void shuffle(){
		for(int i = 0; i<list.size(); i++){

			int grab = gen.nextInt(list.size());
			int place = gen.nextInt(list.size());
			Items temp = list.get(grab);

			list.set(grab, list.get(place));
			list.set(place, temp);
		}
	}
	public int length(){
		return list.size();
	}
	public Items pull(Items item){
		for(Items x: list){
			if(list.contains(x)){
				list.remove(x);
				return x;
			}
		}
		System.out.println("invalid item.");
		return null;
	}
	public void unequip(){
		for(Items i: list){
			i.setUseable(false);
		}
	}

	public ArrayList<Items> getList() {
		return list;
	}

}
