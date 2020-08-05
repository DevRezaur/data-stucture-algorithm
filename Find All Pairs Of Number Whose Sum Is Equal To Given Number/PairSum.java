/* How do you find all pairs of an integer array whose sum is equal to a given number?
 * Here we are going to use to popular method to do that. Use what ever you prefer. 
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

import java.util.Set;

public class PairSum {

	// Method 1: Using HashSet
	public static void printPairSum1(int arr[], int target) {
		// If there are less than two numbers, we can not form any pair
		if (arr.length < 2) {
			System.out.println("Not enough numbers to make pairs");
			return;
		}

		// Declaring a HashSet
		Set<Integer> set = new HashSet<Integer>();

		// Iterating over the full array to find pairs that add up to the given target value
		for (int num : arr) {
			int remaining = target - num;
			if (!set.contains(remaining)) {
				set.add(num);
			} else {
				System.out.println(num + " " + remaining);
			}
		}
	}

	// Method 2:
	public static void printPairSum2(int arr[], int target) {
		// If there are less than two numbers, we can not form any pair
		if (arr.length < 2) {
			System.out.println("Not enough numbers to make pairs");
			return;
		}

		// Sorting the array in ascending order
		Arrays.sort(arr);

		// Finding every pair of number whose sum is equal to the target number
		int left = 0;
		int right = arr.length - 1;
		int sum;

		while (left < right) {
			sum = arr[left] + arr[right];

			if (sum == target) {
				System.out.println(arr[left] + " " + arr[right]);
				left++;
				right--;
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
	}

	// Main method to run the program
	public static void main(String[] args) {
		// Scanner object to take inputs
		Scanner sc = new Scanner(System.in);

		// Sample array to test the program
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		int target = 4;

		// Calling the first method
		System.out.println("Using 1st method:");
		printPairSum1(arr, target);
		
		// Calling the second method
		System.out.println("Using 2nd method:");
		printPairSum2(arr, target);

		// Closing the scanner object
		sc.close();
	}

}
