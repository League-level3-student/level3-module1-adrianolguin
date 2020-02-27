package _01_IntroToArrayLists;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class _05_LongChipCompetition {
	/**
	 * The Beatles are eating lunch and playing a game to see who has the longest
	 * chip. (In England, french fries are called "chips".) * Find the Beatle with
	 * the longest chip. You may not edit the Chip or Beatle classes. Make sure to
	 * initialize The Beatles before you start your search. *
	 **/
	private ArrayList<Beatle> theBeatles = new ArrayList<Beatle>();

	public static void main(String[] args) {
		_05_LongChipCompetition lcc = new _05_LongChipCompetition();
		lcc.initializeBeatles();

		ArrayList<Beatle> theBeatlesAvailable = lcc.getTheBand();

		// go through the band members
		double longestChip = 0;
		Beatle temp = null;

		for (int i = 0; i < theBeatlesAvailable.size(); i++) {
			System.out.println(theBeatlesAvailable.get(i).getName());
			for (int j = 0; j < theBeatlesAvailable.get(i).getChips().size(); j++) {
				System.out.println(theBeatlesAvailable.get(i).getChips().get(j).getLength());
			}
		}

		for (int i = 0; i < theBeatlesAvailable.size(); i++) {

			// check if any of the band members chips are longer than the longest chip
			for (int j = 0; j < theBeatlesAvailable.get(i).getChips().size(); j++) {
				if (theBeatlesAvailable.get(i).getChips().get(i).getLength() > longestChip) {
					// if true the make the longest chip equal to that new longest chip
					longestChip = theBeatlesAvailable.get(i).getChips().get(i).getLength();
					temp = theBeatlesAvailable.get(i);
				}
				// else nothing
			}
			// once you found the longest chip then check to see whose chip it is and say
			// thats who has the
			// longest chip
		}

		for (int i = 0; i < theBeatlesAvailable.size(); i++) {
			if (temp == theBeatlesAvailable.get(i)) {
				System.out.println(theBeatlesAvailable.get(i).getName());
			}
		}

	}

	private void initializeBeatles() {
		Beatle george = new Beatle("George");
		Beatle john = new Beatle("John");
		Beatle paul = new Beatle("Paul");
		Beatle ringo = new Beatle("Ringo");
		theBeatles.add(george);
		theBeatles.add(john);
		theBeatles.add(paul);
		theBeatles.add(ringo);
	}

	public ArrayList<Beatle> getTheBand() {
		return theBeatles;
	}
}

class Beatle {
	private String name;
	private ArrayList<Chip> chips = new ArrayList<Chip>();

	public Beatle(String name) {
		this.name = name;
		initializePlateOfChips();
	}

	private void initializePlateOfChips() {
		int numberOfChips = new Random().nextInt(100);
		for (int i = 0; i < numberOfChips; i++) {
			chips.add(new Chip(new Random().nextDouble() * 10));
		}
	}

	public ArrayList<Chip> getChips() {
		return this.chips;
	}

	public String getName() {
		return this.name;
	}
}

class Chip {
	private double length;

	public double getLength() {
		return length;
	}

	Chip(double d) {
		this.length = d;
	}
}
