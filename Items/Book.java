package Items;


public class Book extends Items{
	private static final long serialVersionUID = -8369835730573240445L;
	static String type = "Book";
	public Book(String s, Boolean loot) {
		super(s, type, loot);

	}

}
