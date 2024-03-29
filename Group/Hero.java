package Group;
import java.io.Serializable;

import Items.Gen;
import Items.Items;
import Items.Scroll;
import Setup.Game;
import Swing.BasicWindow;
import Swing.LootWindow;


public abstract class Hero implements Serializable{
	private static final long serialVersionUID = -8908983528025025888L;
	protected Bag bag = new Bag();
	private int gold = 0;
	protected int slots = 0;
	private Hclasses type;
	private int rank = 0;
	private String name = "";
	private Items mainEquip;
	private Items offEquip;
	private Items extra;
	private int exp = 0;
	private int lvUp;
	boolean inTeam = false;


	public Hero(String s, Hclasses a){
		type = a;
		stats();
		rename(s);
		lvUp = (250 * rank);
	}

	public void upgradeBag(int slots) {
		this.slots += slots;
	}

	@Override
	public String toString() {
		return "Lv. " + rank + " " + name + " Gold: " + gold + " XP: " + exp + "/" + lvUp + " In Party: " + inTeam;
	}
	/**
	 * determines gold and bag size
	 */
	protected void stats() {
		rank = Gen.gen.nextInt(10) + 1;
		if(type == Hclasses.Warrior){
			gold += 300 * rank;
			slots += rank + 10;
		}
		if(type == Hclasses.Mage){
			gold += 200 * rank;
			slots += rank + 5;
		}
		if(type == Hclasses.Assassin){
			gold += 500 * rank;
			slots += rank;
		}
	}
	/**
	 * checks if name of hero is same as input
	 */
	public boolean call(String input){
		if(input.endsWith(name)){
			return true;
		}
		else{
			return false;
		}
	}

	public Bag getBag() {
		return bag;
	}
	protected void rename(String s){
		name = s;
	}

	public int getSlots() {
		return slots;
	}
	public Hclasses getType() {
		return type;
	}
	public int getRank() {
		return rank;
	}
	public String getName() {
		return name;
	}
	public void setRank(int rank2) {
		rank += rank2;
	}	
	public int getGold() {
		return gold;
	}
	public void levelUp(){
		if(getExp() >=getLvUp()){
			rank ++;
			lvUp = (int) (getLvUp() + getLvUp() *1.5);
			setExp(0);
			System.out.println("Level Up.");
		}
		else{
			System.out.println("Need more XP.");
		}
	}
	public void setGold(int gold, int cost) {
		this.gold += gold;
		this.gold -= cost;
	}

	public int effectiveRank(){
		int x = 0;
		for(int i = 0; i<bag.length(); i ++){
			Items a = (Items) bag.scry(i);
			if(a.isUseable()){
				x += a.getRank();
			}
		}
		return x + this.getRank();
	}


	public boolean setMainEquip(Items mainEquip) {
		if(slots < mainEquip.getWieght()){
			BasicWindow alert = new BasicWindow("Cannot carry bag capacity reached");
			return false;
		}else{
			this.mainEquip = mainEquip;
			mainEquip.setUseable(true);
			slots -= mainEquip.getWieght();
			bag.add(mainEquip);
			return true;
		}
	}
	public boolean setOffEquip(Items offEquip) {
		if(slots < offEquip.getWieght()){
			BasicWindow alert = new BasicWindow("Cannot carry bag capacity reached");
			return false;
		}else{
			slots -= offEquip.getWieght();
			this.offEquip = offEquip;
			offEquip.setUseable(true);
			bag.add(offEquip);
			return true;		
		}
	}
	public boolean setExtra(Items extra) {
		if(slots < extra.getWieght()){
			BasicWindow alert = new BasicWindow("Cannot carry bag capacity reached");
			return false;
		}else{
			slots -= extra.getWieght();
			extra.setUseable(true);
			this.extra = extra;
			bag.add(extra);
			return true;
		}
	}
	public Items getMainEquip() {
		return mainEquip;
	}
	public Items getOffEquip() {
		return offEquip;
	}
	public Items getExtra() {
		return extra;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp += exp;
	}
	public int getLvUp() {
		return lvUp;
	}
}

