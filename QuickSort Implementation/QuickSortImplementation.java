import java.util.Arrays;

public class QuickSortImplementation {

	public static void QuickSort(int arr[], int low, int high) {
		// Checking if the array is empty or only contains one element
		// If so, then no need to sort
		if (arr == null || arr.length <= 1)
			return;

		int i = low;
		int j = high;

		// Setting the middle index as pivot
		int pivot = arr[low + (high - low) / 2];

		// In each iteration, we will identify a number from left side which is greater then the pivot value,
		// and * a number from right side which is less then the pivot value.
		// Once the search is complete, we can swap both numbers.
		while (i <= j) {
			while (arr[i] < pivot)
				i++;

			while (arr[j] > pivot)
				j--;

			if (i <= j) {
				// Swap the elements
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				// Move index to the next position on both sides
				i++;
				j--;
			}
		}

		// Call QuickSort recursively for both partitions
		if (i < high)
			QuickSort(arr, i, high);
		if (j > low)
			QuickSort(arr, low, j);
	}

	// Main method to run the program
	public static void main(String[] args) {
		// Sample array for sorting
		int arr[] = { 1, 0, 5, 9, 5 };

		// Printing the unsorted array
		System.out.println("Unsorted array: " + Arrays.toString(arr));

		// Calling the QuickSort method
		QuickSort(arr, 0, arr.length - 1);

		// Printing the sorted array
		System.out.println("Sorted array: " + Arrays.toString(arr));
	}

}
