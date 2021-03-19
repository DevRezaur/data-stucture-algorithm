/* In this program we are going to see how we can find the first non repeating character
 * of a given string. Here we are going to see to method to determine the first non
 * repeating character. Any one of them will do the trick just fine.
 */

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class NonRepeatChar {

	// Method 1:
	public static void firstNonRepeat1(String str) {
		// Here LinkedHashMap is used instead of regular HashMap to maintain insertion order
		Map<Character, Integer> map = new LinkedHashMap<>();

		// Iterate over the whole string and store each character with their count in the map
		for (char ch : str.toCharArray()) {
			// If the LinkedHashMap already contains the character
			// Then get its previous count and increase it
			// Else just add 1 to the LinkedHashMap
			if (map.containsKey(ch)) {
				int count = map.get(ch);
				count++;
				map.put(ch, count);
			} else {
				map.put(ch, 1);
			}
		}

		// Iterate over the LinkedHashMap and print the first character that has count 1
		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println("First non repeating character: " + entry.getKey());
				break;
			}
		}
	}

	// Method 2:
	public static void firstNonRepeat2(String str) {
		// ArrayList for storing non repeating characters and repeating characters
		List<Character> nonRepeat = new ArrayList<>();
		List<Character> repeat = new ArrayList<>();

		// Iterate over the whole string and find whether a character is repeating or non repeating
		// And store them in the corresponding ArrayList
		for (char ch : str.toCharArray()) {
			if (repeat.contains(ch)) {
				continue;
			} else if (nonRepeat.contains(ch)) {
				nonRepeat.remove((Character) ch);
				repeat.add(ch);
			} else {
				nonRepeat.add(ch);
			}
		}

		// Print the first non repeating character from the ArrayList of non repeating characters
		if (nonRepeat.size() != 0) {
			System.out.println("First non repeating character: " + nonRepeat.get(0));
		}
	}

	// Main method to run the program
	public static void main(String[] args) {
		// Scanner object to take input
		Scanner sc = new Scanner(System.in);

		// Asking user for a sample string
		System.out.println("Enter a sample string: ");
		String str = sc.nextLine();

		// Calling the 1st method to find first non repeated character
		System.out.println("Using 1st Method: ");
		firstNonRepeat1(str);

		// Calling the 2nd method to find first non repeated character
		System.out.println("Using 2nd Method: ");
		firstNonRepeat2(str);

		// Closing the scanner object
		sc.close();
	}

}
