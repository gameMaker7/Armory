package Swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Group.Hclasses;
import Items.Book;
import Items.Dagger;
import Items.Gen;
import Items.Potion;
import Items.Relic;
import Items.Staff;
import Items.Sword;
import Items.Types;
import Quests.Dungeons;
import Quests.JabarsQuestions;
import Setup.Game;

public class QuestWindow extends JFrame implements ActionListener{

	private static ArrayList<JabarsQuestions> questions = new ArrayList<JabarsQuestions>();
	private JLabel alert;
	private JPanel alertWindow;
	private JTextField answer = new JTextField("", 5);
	private JTextField number = new JTextField("", 5);
	private int x;
	private JButton result;
	private static int countQuestions = 1;
	private Dungeons dungeon;
	public QuestWindow(boolean b, Dungeons d) {
		super("Jabar's Number Game");
		dungeon = d;
		build();
		content("I m thinking of a number between 1 and 10. What is it.");
		x = Gen.gen.nextInt(10) + 1;
		alertWindow.add(number);
		finalStuff();
	}
	public QuestWindow(int i, Dungeons d) {
		super("Jabar's Question Game");
		dungeon = d;
		build();
		x = Gen.gen.nextInt(questions.size());
		content(questions.get(x).question());
		alertWindow.add(answer);
		finalStuff();
	}

	private void finalStuff() {
		alertWindow.add(result);
		this.add(alertWindow);		
		this.pack();
		this.setLocation(1920/2 -(this.getWidth()), 1080/2 - (this.getHeight()));
		this.setVisible(true);		
	}
	private void content(String label) {
		alert = new JLabel(label);		
		result = new JButton("Answer");
		result.addActionListener(this);		
		alertWindow.add(alert);
	}
	private void build() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = new Dimension(400, 400);
		this.setPreferredSize(d);
		alertWindow = new JPanel();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == result){
			if(questions.isEmpty()){
				int a = Integer.parseInt(number.getText());
				if(a == x){
					dungeon.questComplete();
					dungeon.fame(Akatar.getParty());
				}else{
					BasicWindow alert = new BasicWindow("Quest Failed");
				}
			}else{
				if(answer.getText().equalsIgnoreCase(questions.get(x).answer())){
					countQuestions--;
					questions.remove(x);
					if(countQuestions == 0){
						dungeon.questComplete();
						dungeon.fame(Akatar.getParty());

					}else{
						QuestWindow quest = new QuestWindow(0, dungeon);
					}
				}else{
					BasicWindow alert = new BasicWindow("Quest Failed. Correct Answer: " + questions.get(x).answer());
				}
			}
			this.dispose();
		}
	}
	public static void jabar() {
		for(JabarsQuestions a: JabarsQuestions.values()){
			questions.add(a);
		}
	}

}
