import java.util.Arrays;

/* In this program we are going to see how we can remove duplicate values
 * From a given array. Without using any collection framework like Set or HashMap
 */

public class RemoveDuplicate {

	// Method to remove duplicates
	public static int[] removeDuplicate(int array[]) {
		// We need to sort the array first in order to the find duplicates
		Arrays.sort(array);

		// Counter variable for counting the number of duplicates
		int dupCount = 0;

		// Determining the array size
		int size = array.length;

		// Counting the number of duplicates available in the given array
		for (int i = 0; i < size - 1; i++) {
			// If adjacent element matches to the current element
			// Then it is duplicate
			if (array[i] == array[i + 1]) {
				dupCount++;
			}
		}

		// Declaring a new array to store the unique values without duplicates
		int newArray[] = new int[size - dupCount];

		// Inserting unique values in the new array
		int index = 0;
		for (int i = 0; i < size - 1; i++) {
			// Checking if adjacent element matches to current element
			// If it does not matches, then include it in the new array
			if (array[i] != array[i + 1]) {
				newArray[index++] = array[i];
			}

			// Special case for the last element in the array
			// Without this line of code, the program will not be able to
			// Copy the last element in the new array
			if (i + 1 == size - 1) {
				newArray[index++] = array[i + 1];
			}
		}

		// Return the new array
		return newArray;
	}

	// Main method to run and test the program
	public static void main(String[] args) {
		// Sample array with duplicate
		int array[] = { 1, 2, 3, 1, 3, 4, 5, 6 };

		// Calling a method to remove duplicates and return a new array with no duplicates
		int newArray[] = removeDuplicate(array);

		// Printing the new array without duplicate value
		System.out.print("Array Without Any Duplicates:");
		for (int i = 0; i < newArray.length; i++) {
			System.out.print(" " + newArray[i]);
		}
	}

}
