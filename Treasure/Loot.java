package Treasure;

import java.util.ArrayList;

import Items.Book;
import Items.Dagger;
import Items.Gen;
import Items.Items;
import Items.Potion;
import Items.Relic;
import Items.Scroll;
import Items.Staff;
import Items.Sword;
import Items.Types;

public class Loot {

	private ArrayList<Items> list  = new ArrayList<Items>();

	public Loot(){
		for(NamesLoot1 x: NamesLoot1.values()){
			for(NamesLoot2 a: NamesLoot2.values()){
				if(!a.equals(x)){
					generate(x, a);
				}
			}
		}
		shuffle();
	}
	public void shuffle(){
		for(int i = 0; i<list.size(); i++){

			int grab = Gen.gen.nextInt(list.size());
			int place = Gen.gen.nextInt(list.size());
			Items temp = list.get(grab);

			list.set(grab, list.get(place));
			list.set(place, temp);
		}
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
	public ArrayList<Items> getList() {
		return list;
	}
	public void setList(ArrayList<Items> list) {
		this.list = list;
	}
	public Items generate(NamesLoot1 x, NamesLoot2 a){
		String s = x + "-" + a;
		int c = Gen.gen.nextInt(7);
		switch(c){
		case 0:
			list.add(new Potion("Potion", true));
			break;

		case 1:
			list.add(new Book("Book of " + s, true));
			break;

		case 2:
			list.add(new Relic("Relic of " + s, true));			
			break;

		case 3:
			list.add(new Dagger("Dagger of " + s, true));
			break;

		case 4:
			list.add(new Staff("Staff of " + s, true));
			break;
		case 5:
			list.add(new Sword("Sword of " + s, true));
			break;
		case 6:
			list.add(new Scroll("Scroll", true));	
			break;
		default:
			System.out.println("This shop only has items of the following types");
			for(Types obj: Types.values()){
				System.out.println(obj);
			}
			break;
		}
		return null;

	}
}

