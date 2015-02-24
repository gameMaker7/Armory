package Items;


public class Potion extends Items {
	private static final long serialVersionUID = -5640447394046202906L;
	static String type = "Potion";
	public Potion(String s, boolean loot) {
		super(s, type, loot);
		rename("Lv: " + getRank() + " Potion");
	}

}
