import java.util.Scanner;

public class BinarySearch {

	// Method to perform binary search
	public static int binarySearch(int array[], int key, int arrSize) {

		// Declaring three variables for binary search operation
		int first, last, mid;

		// This indicates the starting index of the array
		first = 0;
		// This indicates the last index of the array
		last = arrSize - 1;
		// This indicates the mid index of the array
		mid = (first + last) / 2;

		// The operation will continue till low index becomes greater than the high index
		while (first <= last) {
			// If middle index of the array contains the key, then break the loop and return mid;
			if (array[mid] == key) {
				break;
			}
			// If the value of middle index of the array is less than the key
			// Then move the lower index to mid+1 index
			else if (array[mid] < key) {
				first = mid + 1;
			}
			// If the value of middle index of the array is grater than the key
			// Then move the higher index to to mid-1 index
			else if (array[mid] > key) {
				last = mid - 1;
			}

			// Generate new mid
			mid = (first + last) / 2;
		}

		// If first>last then the key/value is not found, thus we return -1
		if (first > last) {
			return -1;
		}
		// Else the key/value is found and we return the index that contains the value
		else
			return mid;
	}

	// Main method to run and test the program
	public static void main(String args[]) {
		// Scanner class object to take input
		Scanner scanner = new Scanner(System.in);

		// Variables for storing array size and searching key
		int arrSize, key;

		// Asking user for array size and taking array size as input
		System.out.print("Enter array size: ");
		arrSize = scanner.nextInt();

		// If array size is greater than 0, only then the below code will execute
		if (arrSize > 0) {
			// Creating the array
			int array[] = new int[arrSize];

			// Inputting the array from user
			// Array must be sorted to perform binary search properly
			System.out.println("Enter the numbers to the array in sorted manner:");

			for (int i = 0; i < arrSize; i++) {
				array[i] = scanner.nextInt();
			}

			// Taking key/value from user to perform search
			System.out.print("Enter a value/key to search: ");
			key = scanner.nextInt();

			// Calling binary search method
			int index = binarySearch(array, key, arrSize);

			// If the method returns -1, then the value/key is not found
			// Otherwise the method will return the index of the value/key
			if (index == -1) {
				System.out.println("The value/key is not found");
			} else {
				System.out.println("The value/key is found at index no: " + index);
			}

		}

		// Closing the scanner object
		scanner.close();
	}

}
