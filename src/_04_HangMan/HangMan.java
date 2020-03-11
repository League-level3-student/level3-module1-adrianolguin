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
	boolean[] visibleLetters;

	public static void main(String[] args) {
		HangMan main = new HangMan();
		main.initializeWordStack();
		main.createGUI();
		main.selectNewWord();
	}

	void startGame() {
		initializeWordStack();
		selectNewWord();
	}

	void initializeWordStack() {
		String wordAmount = JOptionPane.showInputDialog("How many words would you like to guess?");
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
		lives = 6;
		currentWord = words.pop();
		visibleLetters = new boolean[currentWord.length()];
		for (int i = 0; i < visibleLetters.length; i++) {
			visibleLetters[i] = false;
		}
		initializePanelText();
		frame.pack();

	}

	void initializePanelText() {
		label.setText("");
		for (int i = 0; i < currentWord.length(); i++) {
			if (visibleLetters[i] == false) {
				label.setText(label.getText() + "-");
			} else {
				label.setText(label.getText() + currentWord.charAt(i));
			}
		}
	}

	void lifeMonitor() {
		if (lives < 1) {
			JOptionPane.showMessageDialog(null, "Game Over \n You have lost");
			if (JOptionPane.showConfirmDialog(null, "would you like to play again?") == 0) {
				startGame();
			}
		}
	}

	boolean arrayEquals() {
		boolean condition = true;
		for (int i = 0; i < visibleLetters.length; i++) {
			if (visibleLetters[i] != true) {
				condition = false;
			}
		}
		return condition;

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		char keyPressed = arg0.getKeyChar();

		if (currentWord.contains("" + keyPressed)) {
			for (int i = 0; i < currentWord.length(); i++) {
				if (currentWord.charAt(i) == keyPressed) {
					visibleLetters[i] = true;
				}
			}
			initializePanelText();
		} else {
			lives--;
			System.out.println("lives: " + lives);
		}
		lifeMonitor();
		if (arrayEquals()) {
			if (words.size() == 0) {

				if (JOptionPane.showConfirmDialog(null,
						"Wow! You guessed all the words correctly\nWould you like to play again?") == 0) {
					startGame();
				}
			} else {
				selectNewWord();
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
