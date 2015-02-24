package Setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import Group.Party;
import Items.Store;

public class Load {
	static FileInputStream save;
	static ObjectInputStream output;
	private static Party party;
	private static Store shop;
	private static QuestBoard jobs;

	public static Party getParty() {
		return party;
	}
	public static QuestBoard getJobs() {
		return jobs;
	}

	public static Store getShop() {
		return shop;
	}

	public static void load(){
		try{
			save = new FileInputStream("RPG Game.txt");
			output = new ObjectInputStream(save);
			party = (Party) output.readObject();
			shop = (Store) output.readObject();
			jobs = (QuestBoard) output.readObject();
			output.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
