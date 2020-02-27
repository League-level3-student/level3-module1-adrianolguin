package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener {
	ArrayList<Song> songs = new ArrayList<Song>();
	int currentSongIndex = -1;
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton("Suprise Me!");
	JButton button2 = new JButton("Stop For the Love of god");

	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		songs.add(new Song("demo.mp3"));
		songs.add(new Song("demo.mp3"));

		/*
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */

	}

	public static void main(String[] args) {
		_06_IPodShuffle main = new _06_IPodShuffle();

		main.createGUI();
	}

	void createGUI() {
		frame.setVisible(true);
		button1.addActionListener(this);
		button2.addActionListener(this);

		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		frame.pack();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == button1) {
			Random r = new Random();
			currentSongIndex = r.nextInt(songs.size());
			songs.get(currentSongIndex).play();
			System.out.println(currentSongIndex);
		} else if(e.getSource() == button2) {
			songs.get(currentSongIndex).stop();
			System.out.println(currentSongIndex);
		}
	}
}
