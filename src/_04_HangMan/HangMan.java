package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	
	Stack<String> wordlibrary = new Stack<String>();
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	
	String chosenword = "";
	int lives = 0;
	int indexofchar = 0;
	
	public void createUI() {
		frame.add(panel);
		panel.add(label);
		frame.setTitle("Hangman");
		frame.pack();
		frame.addKeyListener(this);
	}
	
	
	public static void main(String[] args) {
		HangMan hm1 = new HangMan();
		hm1.createUI();
		hm1.step1();
		hm1.step2();
	}
	
	public void step1() {
		String wordguessnumS = JOptionPane.showInputDialog("Welcome to Hangman! \nEnter the number of words you want to guess from 1 to 266.");
		int wordguessnumI = Integer.parseInt(wordguessnumS);
		
		for (int i = 0; i < wordguessnumI; i++) {
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
		label.setText(label.getText() + " Lives Remaining: " + lives);
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		Character c = e.getKeyChar();
		
		for (int i = 0; i < chosenword.length(); i++) {
			if (c.equals(chosenword.charAt(i))) {
				label.setText(label.getText().substring(0, i) + c + label.getText().substring(i+1));
			} 
		}
//			
//			else if (!c.equals(chosenword.charAt(i))) {
//				lives--;
//				String revisetext1 = label.getText().substring(0, label.getText().length()-1);
//				System.out.println(revisetext1);
//				label.setText(revisetext1 + lives);
//			}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
