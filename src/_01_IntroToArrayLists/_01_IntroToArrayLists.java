package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		// 1. Create an array list of Strings
		// Don't forget to import the ArrayList class
		ArrayList<String> strings = new ArrayList<String>();

		// 2. Add five Strings to your list
		for (int i = 0; i < 5; i++) {
			strings.add("hello " + i);
			System.out.println(strings.get(i));
		}

		// 3. Print all the Strings using a standard for-loop

		// 4. Print all the Strings using a for-each loop

		for (String string : strings) {
			System.out.println(string);
		}

		// 5. Print only the even numbered elements in the list.
		for (int i = 0; i < strings.size(); i += 2) {
			System.out.println(strings.get(i));
		}
		// 6. Print all the Strings in reverse order.
		for (int i = strings.size() - 1; i > 0; i--) {
			System.out.println(strings.get(i));
		}
		// 7. Print only the Strings that have the letter 'e' in them.
		strings.add("nam");

		for (int i = 0; i < strings.size(); i++) {
			if (strings.get(i).contains("e")) {
				System.out.println(strings.get(i));
			}
		}
	}
}
