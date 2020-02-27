package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {

	public static void main(String[] args) {
		Random r = new Random();
		// 1. Create a Stack of Doubles
		// Don't forget to import the Stack class
		Stack<Double> doubles = new Stack<Double>();
		// 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		for (int i = 0; i < 100; i++) {
			Double randomDouble = r.nextDouble() * 100;
			doubles.add(randomDouble);
		}

		// 3. Ask the user to enter in two numbers between 0 and 100, inclusive.
		String input1 = JOptionPane.showInputDialog("Give me a number between 0 and 100");
		String input2 = JOptionPane.showInputDialog("Give me another number between 0 and 100");
		int int1 = Integer.parseInt(input1);
		int int2 = Integer.parseInt(input2);
		// 4. Pop all the elements off of the Stack. Every time a double is popped that
		// is
		// between the two numbers entered by the user, print it to the screen.

		int lower = -1;
		int upper = -1;
		
		if(int1 > int2) {
			upper = int1;
			lower = int2;
		} else {
			upper = int2;
			lower = int1;
		}
		
		System.out.println("Popping elements off stack..." + "\nElements between " + int1 + " and " + int2 +":");
		
		for (int i = 0; i < doubles.size(); i++) {
			if(doubles.get(i) > lower && doubles.get(i) < upper) {
				System.out.println(doubles.get(i));
			}
		}
		
		// EXAMPLE:
		// NUM 1: 65
		// NUM 2: 75

		// Popping elements off stack...
		// Elements between 65 and 75:
		// 66.66876846
		// 74.51651681
		// 70.05110654
		// 69.21350456
		// 71.54506465
		// 66.47984807
		// 74.12121224
	}
}
