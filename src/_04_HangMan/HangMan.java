package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.xml.stream.events.Characters;

public class HangMan implements KeyListener{
	
	Stack<String> wordlibrary = new Stack<String>();
	Stack<Character> charlibrary = new Stack<Character>();
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	
	String chosenword = "";
	int lives = 0;
	int indexofchar = 0;
	
	StringBuilder sb;
	
	public void createUI() {
		frame.add(panel);
		panel.add(label);
		frame.setTitle("Hangman");
		frame.setSize(300, 55);
		frame.addKeyListener(this);
	}
	
	
	public static void main(String[] args) {
		HangMan hm1 = new HangMan();
		hm1.createUI();
		hm1.step1();
		hm1.step2();
	}
	
	public void step1() {
		String wordguessnumS = JOptionPane.showInputDialog("Welcome to Hangman!\nEnter the number of words you want to guess from 1 to 266.");
		int wordguessnumI = Integer.parseInt(wordguessnumS);
		
		wordlibrary.push(""); //extraword
		for (int i = 0; i < wordguessnumI; i++) {
			System.out.println("getting word");
			wordlibrary.push(Utilities.readRandomLineFromFile("dictionary.txt"));
		}
	}
	
	public void step2() {
		frame.setVisible(true);
		chosenword = wordlibrary.pop();
		System.out.println(chosenword);
		for (int i = 0; i < chosenword.length(); i++) {
			label.setText(label.getText() + "_");
		}
		lives = chosenword.length()+5;
		label.setText(label.getText() + "   Lives Remaining: " + lives);
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		Character c = e.getKeyChar();
		
		sb = new StringBuilder(label.getText());
		
		for (int i = 0; i < chosenword.length(); i++) {
			if (c.equals(chosenword.charAt(i))) {
				sb.setCharAt(i, c);
			} 
		}
		label.setText(sb.toString());
		
		if (!label.getText().contains("_")) {
			JOptionPane.showMessageDialog(null, "Good job! Next word.");
			label.setText("");
			chosenword = wordlibrary.pop();
			System.out.println(chosenword);
			for (int i = 0; i < chosenword.length(); i++) {
				label.setText(label.getText() + "_");
			}
			lives = chosenword.length()+5;
			label.setText(label.getText() + "   Lives Remaining: " + lives);
			
			if (wordlibrary.isEmpty()) {
				label.setText("");
				frame.setVisible(false);
				JOptionPane.showMessageDialog(null, "Good job, you win!");
			}
		}
		
		if (lives == 0) {
			JOptionPane.showInputDialog("GAME OVER! \n You ran out of lives! Play again?");
		}
	}
	
}
