package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
// all the names added to the list. Format the list as follows:
// Guest #1: Bob Banders
// Guest #2: Sandy Summers
// Guest #3: Greg Ganders
// Guest #4: Donny Doners

public class _02_GuestBook implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addname = new JButton();
	JButton viewnames = new JButton();
	
	ArrayList<String> names = new ArrayList<String>();
	
	public static void main(String[] args) {
		_02_GuestBook gb1 = new _02_GuestBook();
		gb1.createUI();
	}
	
	public void createUI() {
		frame.add(panel);
		panel.add(addname);
		panel.add(viewnames);
		frame.setVisible(true);
		addname.setText("Add Name");
		viewnames.setText("View Names");
		addname.addActionListener(this);
		viewnames.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(addname)) {
			String inputname = JOptionPane.showInputDialog("Please enter a name.");
			names.add(inputname);
		}
		
		if (e.getSource().equals(viewnames)) {
			String qwerty = "";
			for (int i = 0; i < names.size(); i++) {
				qwerty = qwerty + "Guest #" + (i+1) + ": " + names.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, qwerty);
		}
	}
	
	
}
