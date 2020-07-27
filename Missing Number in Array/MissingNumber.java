import java.util.BitSet;

/* In this program we are going to learn how to find missing number/numbers
 * In a given integer array of 1 to 10. 
 */

/* There might be two separate cases. In first case, only one number might be missing.
 * And in the other case, more than one number might be missing from the array. 
 */

public class MissingNumber {

	// Method to find only one missing number
	public static void missingOne(int array_1[]) {
		// Determining the array size (without the missing number)
		int size = array_1.length;

		// Calculate the actual array size (including 1 missing number)
		int actualSize = size + 1;

		// Calculating the expected sum with no missing value
		// Using n*(n+1)/2 formula
		int expectedSum = (actualSize * (actualSize + 1)) / 2;

		// Calculating the actual sum, the sum without the missing number
		int actualSum = 0;
		for (int i = 0; i < size; i++) {
			actualSum += array_1[i];
		}

		// From the difference between expected sum and actual sum
		// We can find out exactly which number is missing
		int missingNum = expectedSum - actualSum;

		// Printing the missing number
		System.out.println("The missing number is: " + missingNum);
	}

	// Method to find multiple missing numbers
	public static void missingMultiple(int array_2[], int missingCount) {
		// Determine the array size (without missing numbers)
		int size = array_2.length;

		// Calculating the actual array size (including missing numbers)
		int actualSize = size + missingCount;

		// Creating a BitSet with the actual array size (including missing numbers)
		BitSet bit = new BitSet(actualSize);

		// Loop over all the items in the array and set their equivalent index bit in BitSet
		for (int i = 0; i < size; i++) {
			int index = array_2[i] - 1;
			bit.set(index);
		}

		// Printing the missing numbers according to the missing bits in BitSet
		int lastMissingIndex = 0;
		System.out.print("The missing numbers are: ");
		for (int i = 1; i <= missingCount; i++) {
			lastMissingIndex = bit.nextClearBit(lastMissingIndex);
			System.out.print(++lastMissingIndex + " ");
		}
	}

	// Main method to test and run the program
	public static void main(String[] args) {
		// First case:
		// Only one number is missing from the below array (number 4 is missing).
		int array_1[] = { 1, 2, 3, 5, 6, 7, 8, 9, 10 };

		// Calling a method that can only find single missing number
		missingOne(array_1);

		// Second case:
		// More than one number is missing (number 3, 7 & 9 is missing).
		int array_2[] = { 1, 2, 4, 5, 6, 8, 10 };
		// The number of element missing from the array
		int missingCount = 3;

		// Calling a method that can find out multiple missing numbers
		missingMultiple(array_2, missingCount);
	}

}
