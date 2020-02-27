package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other
	// button reads "View Names"
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton("Add name");
	JButton button2 = new JButton("View names");

	ArrayList<String> names = new ArrayList<String>();

	void createGUI() {
		frame.setVisible(true);
		frame.add(panel);
		panel.add(button1);
		button1.addActionListener(this);
		panel.add(button2);
		button2.addActionListener(this);
		frame.pack();
	}

	public static void main(String[] args) {
		_02_GuestBook main = new _02_GuestBook();
		main.createGUI();

		// When the add name button is clicked, display an input dialog that asks the
		// user to enter a name. Add
		// that name to an ArrayList. When the "View Names" button is clicked, display a
		// message dialog that displays
		// all the names added to the list. Format the list as follows:
		// Guest #1: Bob Banders
		// Guest #2: Sandy Summers
		// Guest #3: Greg Ganders
		// Guest #4: Donny Doners
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button1) {
			String nameInput = JOptionPane.showInputDialog("Enter a name.");
			names.add(nameInput);
		} else if (e.getSource() == button2) {
			String list = "";
			for (int i = 0; i < names.size(); i++) {
				list = list + "Guest #" + (i + 1) + ": " + names.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, list);
		}
	}

}
