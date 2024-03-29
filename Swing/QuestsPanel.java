package Swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import Group.Hero;
import Quests.Dungeons;

public class QuestsPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1047957538174397409L;
	private JButton begin = new JButton("Begin Quest!");
	JComboBox<Dungeons> quests = new JComboBox<Dungeons>();

	public QuestsPanel(){
		content();

	}

	private void content() {

		this.add(quests);
		this.add(begin);
		questAdd();
		quests.addActionListener(this);
		begin.addActionListener(this);

	}

	private void questAdd() {
		Akatar.getJobs().getJobs().listAll(quests);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == begin){
			enter((Dungeons)quests.getSelectedItem());
			questAdd();

		}
	}

	private void enter(Dungeons dungeon) {
		if(Akatar.getAdventure().length() == 0){
			BasicWindow alert = new BasicWindow("No Heroes in party cannot leave town.");
			return;
		}
		if(Akatar.getAdventure().teamLevel() >= dungeon.getMinLevel()){
			dungeon.run();
			Akatar.getJobs().getJobs().remove(dungeon);
		}else{
			BasicWindow alert = new BasicWindow("Party Level to low.");
		}
	}

}
