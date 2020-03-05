package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.crypto.dsig.keyinfo.KeyValue;

public class _02_TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();

	Stack<Character> deletedText = new Stack<Character>();

	void createGUI() {
		frame.setVisible(true);
		frame.addKeyListener(this);

		panel.add(label);
		frame.add(panel);
		frame.pack();
	}

	public static void main(String[] args) {
		_02_TextUndoRedo main = new _02_TextUndoRedo();
		main.createGUI();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		char keyPressed = arg0.getKeyChar();

		if (keyPressed == KeyEvent.VK_BACK_SPACE) {
			String temp = label.getText().substring(0, label.getText().length() - 1);
			deletedText.add(label.getText().charAt(label.getText().length() - 1));
			label.setText(temp);
			
		} else if (keyPressed == KeyEvent.VK_0) {
			if (deletedText.size() > 0) {
				label.setText(label.getText() + deletedText.pop());
			}
		} else {
			label.setText(label.getText() + keyPressed);
			frame.pack();

		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
