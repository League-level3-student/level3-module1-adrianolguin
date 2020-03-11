package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
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
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addEntryButton = new JButton("Add Entry");
	JButton searchIDButton = new JButton("Search by ID");
	JButton viewButton = new JButton("View List");
	JButton removeButton = new JButton("Remove Entry");
	
	HashMap<Integer, String> personIdentification = new HashMap<Integer, String>();
	
	void createGUI() {
		frame.setVisible(true);
		frame.add(panel);
		panel.add(addEntryButton);
		addEntryButton.addActionListener(this);
		panel.add(searchIDButton);
		searchIDButton.addActionListener(this);
		panel.add(viewButton);
		viewButton.addActionListener(this);
		panel.add(removeButton);
		removeButton.addActionListener(this);
		frame.pack();
	}
	public static void main(String[] args) {
		_02_LogSearch main = new _02_LogSearch();
		main.createGUI();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == addEntryButton) {
			int ID = Integer.parseInt(JOptionPane.showInputDialog("Enter ID"));
			String name = JOptionPane.showInputDialog("Enter Name");
			personIdentification.put(ID, name);
		} else if(arg0.getSource() == searchIDButton) {
			int ID = Integer.parseInt(JOptionPane.showInputDialog("Enter ID"));
			if(personIdentification.containsKey(ID)) {
				JOptionPane.showMessageDialog(null, "Name: " + personIdentification.get(ID));
			} else {
				JOptionPane.showMessageDialog(null, "Entry does not exist");
			}
		} else if(arg0.getSource() == viewButton) {
			String list = "";
			for(Integer ID : personIdentification.keySet()) {
				list = list + "ID: " + ID + "  Name: " + personIdentification.get(ID) + "\n";
			}
			JOptionPane.showMessageDialog(null, list);
		} else if(arg0.getSource() == removeButton) {
			int ID = Integer.parseInt(JOptionPane.showInputDialog("Enter ID"));
			if(personIdentification.containsKey(ID)) {
				JOptionPane.showMessageDialog(null, "Removed\nID: " + ID + "  Name: " + personIdentification.get(ID));
				personIdentification.remove(ID);
			} else {
				JOptionPane.showMessageDialog(null, "Entry does not exist");
			}
		}
	}
}
