package Swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	private static final long serialVersionUID = 5167107731232726472L;
	private JButton exit;
	private JLabel user;
	private JTextField name;
	private JButton login;
	private JPanel logIn;
	private JButton delete;
	private FileInputStream load;
	private FileOutputStream create;
	public Login(){
		super("Login Window");
		build();
		content();
		finalStuff();
	}

	private void build() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		logIn = new JPanel();		
	}
	private void content() {
		exit = new JButton("Exit");
		login = new JButton("Login");
		delete = new JButton("Delete");
		user = new JLabel("Username");		
		name = new JTextField(5);
		exit.addActionListener(this);
		login.addActionListener(this);
		name.addActionListener(this);
		delete.addActionListener(this);

		logIn.add(user);
		logIn.add(name);
		logIn.add(login);		
		logIn.add(delete);		
	}
	private void finalStuff() {
		exit.addActionListener(this);
		logIn.add(exit);
		this.add(logIn);
		this.pack();
		this.setLocation(1920/2 -(this.getWidth()), 1080/2 - (this.getHeight()));
		this.setVisible(true);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit){
			this.dispose();
		}
		if(e.getSource() == delete){
			String text = name.getText() + ".txt";
			File f = new File(text);
			Path p = f.toPath();
			try {
				if(Files.deleteIfExists(p)){
					BasicWindow alert = new BasicWindow("Save Deleted");
				}else{
					BasicWindow alert = new BasicWindow("User Invalid");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == login){
			if(name.getText().equalsIgnoreCase("")){
				BasicWindow alert = new BasicWindow("User requires at least one character");
			}
			else{
				fileCheck(name.getText());
			}
		}
	}
	public static void main(String[] args) {
		Login log = new Login();
	}
	private boolean fileCheck(String text) {
		File f = new File(text + ".txt");
		if(!f.exists()){
			try {
				create = new FileOutputStream(f);
				ObjectOutputStream output = new ObjectOutputStream(create);
				Akatar game = new Akatar();	
				Akatar.game = game;
				Akatar.f = f;
				output.writeObject(game);
				game.create();
				output.close();
				this.dispose();
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				load = new FileInputStream(f);
				ObjectInputStream output = new ObjectInputStream(load);
				Akatar game = (Akatar)output.readObject();
				Akatar.game = game;
				System.out.println(2);
				game.create();
				output.close();
				this.dispose();

			} catch (FileNotFoundException e1) {
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			return false;
		
	}
}

