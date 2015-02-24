package Setup;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Group.Party;
import Items.Items;
import Items.Scroll;
//import Items.Shop;
import Treasure.Loot;


public class Game {
	public static Scanner input  = new Scanner(System.in);
	Party tavern = new Party();
	Loot loot = new Loot();
	//Shop shop = new Shop();
	QuestBoard jobs = new QuestBoard();
	private int baseLoot = 3;

	static String action = "";
	public static Game x = new Game();


	public static void main(String[] args) {
		try{
		//	x.loot();
//			x.dungeons();
			x.play();
		}
		catch(NoSuchElementException e){
			System.out.println("Failure");
		}
	}


	public Party getTavern() {
		return tavern;
	}


//	public Shop getShop() {
//		return shop;
//	}


	public QuestBoard getJobs() {
		return jobs;
	}


	private void dungeons() {
		//jobs.listAll();		
	}


	private void play() {
		
		System.out.println("You are the god of .... crap I forgot your godood was revoked.\nTo reacquire your title as a god you must build an adventurer's guild.\nEstalish it as a high ranking guild with fame that spreads to all the world.");
		System.out.println("Welcome to Akatar. (do not use caps)");
		while(true){
			System.out.println("\nChoose an action.");
			for(AIT a: AIT.values()){
				System.out.println(a);
			}
			action = input.nextLine();
			switch(action){
			case "fame":
				fame();
				break;
			case "quests":
				if(tavern.heroes.length() != 0){
					System.out.println("Assemble your Team");
					tavern.buildTeam(tavern);
					//jobs.enter(tavern);
				}else{
					System.out.println("You are not allowed to leave this city, send heroes to do your bidding.");
				}
				break;
			case "dismiss":
				tavern.dismiss();
				break;
			case "shop":
				System.out.println("Choose a Hero.");
				break;
			case "quit":
				System.exit(0);
				break;
			case "inventory":
				if(tavern.heroes.length() != 0){
					System.out.println("Heroes or Loot Bag");
					String decision = Game.input.nextLine();
//					if(decision.equalsIgnoreCase("heroes")){
//						tavern.inventory(tavern.showHeros());
//					}else if(decision.equalsIgnoreCase("Loot Bag")){
//						tavern.useLootBag();
//					}
				}
				else{
					System.out.println("No Heroes.");
				}
				break;
//			case "save":
//				Save.saveGame(tavern, shop.getShop(), jobs);
//				break;
//			case "load": 
//				Load.load();
//				tavern = Load.getParty();
//				shop.setShop(Load.getShop());
//				jobs = Load.getJobs();
//				System.out.println("Load Complete");
//				break;
			default:
				System.out.println("Invalid Command.");
				break;
			}
		}
	}

	private void fame() {
		System.out.println("Current Fame: " + tavern.getFame());		
	}


	public void scroll(Scroll scroll) {
		System.out.println(scroll.getName() + " Activated!");
		tavern.showHeros().setRank(scroll.getRank());
		loot.getList().remove(scroll);

	}
	



}
