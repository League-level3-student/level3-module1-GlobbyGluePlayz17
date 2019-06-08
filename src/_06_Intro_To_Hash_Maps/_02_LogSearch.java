package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/* 
 * Crate a HashMap of Integers for the keys and Strings for the values.
 * Create a GUI with three buttons. 
 * Button 1: Add Entry
 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
 * 				Add this information as a new entry to your HashMap.
 * 
 * Button 2: Search by ID
 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
 * 				If that ID exists, display that name to the user.
 * 				Otherwise, tell the user that that entry does not exist.
 * 
 * Button 3: View List
 * 				When this button is clicked, display the entire list in a message dialog in the following format:
 * 				ID: 123  Name: Harry Howard
 * 				ID: 245  Name: Polly Powers
 * 				ID: 433  Name: Oliver Ortega
 * 				etc...
 * 
 * When this is complete, add a fourth button to your window.
 * Button 4: Remove Entry
 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
 * 				is not in the list. 
 *
 * */

public class _02_LogSearch implements ActionListener {
	HashMap<Integer, String> keysnvalues = new HashMap<Integer, String>();
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	
	String messagedialog = "";
	String list = "";
	
	public static void main(String[] args) {
		_02_LogSearch ls1 = new _02_LogSearch();
		ls1.createUI();
	}

	public void createUI () {
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button1.setText("Add an Entry");
		button2.setText("Search by ID");
		button3.setText("View List");
		frame.setSize(400, 60);
		frame.setTitle("LogSearcher");
		frame.setVisible(true);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button1) {
			String keysstring = JOptionPane.showInputDialog("Please enter in the ID number you want to add.");
			Integer key = Integer.parseInt(keysstring);
			String value = JOptionPane.showInputDialog("Please enter in a name for that ID number.");
			keysnvalues.put(key, value);
		}
		
		if (e.getSource() == button2) { 
			if (keysnvalues.isEmpty()) {
				JOptionPane.showMessageDialog(null, "There are currently no entries available.");
			} 
			if (!keysnvalues.isEmpty()) {
				//S = String; I = Integer
				String inputkeyS = JOptionPane.showInputDialog("Please enter in the ID number for the name you want to find.");
				Integer inputkeyI = Integer.parseInt(inputkeyS);
			
				for (Integer i : keysnvalues.keySet()) {
					if (i.equals(inputkeyI)) {
						messagedialog = "exists";
						JOptionPane.showMessageDialog(null, "The matching name to the ID number entered is: " + keysnvalues.get(i) + "");
						break;
					} else {
						messagedialog = "inexistent";
					}
				}
				
				if (messagedialog.equals("inexistent")) {
					JOptionPane.showMessageDialog(null, "Sorry. The ID number you entered does not exist.");
				}
			}
		}
		
		if (e.getSource() == button3) {
			if (keysnvalues.isEmpty()) {
				JOptionPane.showMessageDialog(null, "There are currently no entries available.");
			} else {
			//if (!keysnvalues.isEmpty()) {
				list = "";
				for (Integer i: keysnvalues.keySet()) {
					list += "ID: " + i + "    Name: " + keysnvalues.get(i) + "\n";
				}
				JOptionPane.showMessageDialog(null, list);
			}
		}
	}
	
}
