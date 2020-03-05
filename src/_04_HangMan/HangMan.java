package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Utilities utilityAccess = new Utilities();

	public Stack<String> words = new Stack<String>();
	int maxWords = 0;
	int lives = 6;
	String currentWord = null;

	public static void main(String[] args) {
		HangMan main = new HangMan();
		main.initializeWordStack();
		main.createGUI();
		main.selectNewWord();
		main.lifeMonitor();

	}

	void initializeWordStack() {
		String wordAmount = JOptionPane.showInputDialog("what is a number");
		maxWords = Integer.parseInt(wordAmount);
		for (int i = 0; i < maxWords; i++) {
			words.push(utilityAccess.readRandomLineFromFile("dictionary.txt"));
		}
	}

	void createGUI() {
		frame.addKeyListener(this);
		frame.setVisible(true);
		frame.add(panel);
		frame.add(label);
	}

	void selectNewWord() {
		currentWord = words.pop();
		System.out.println(currentWord);
		while (label.getText().length() != currentWord.length()) {
			label.setText(label.getText() + "-");
		}
		frame.pack();

	}
	
	void lifeMonitor() {
		if(lives == 0) {
			JOptionPane.showMessageDialog(null, "Game Over \n You have lost");
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		char keyPressed = arg0.getKeyChar();
		for (int i = 0; i < currentWord.length(); i++) {
			if (keyPressed == currentWord.charAt(i)) {
				String temp = label.getText();
				temp = temp.substring(0, i) + keyPressed + temp.substring(i + 1);
				label.setText(temp);
			} else {
				lives--;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
