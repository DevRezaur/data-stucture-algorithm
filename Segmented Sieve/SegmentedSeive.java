/* In this program we are going to learn how to calculate segmented sieve
 * With the help of "Sieve of Eratosthenes" method.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SegmentedSeive {

	// Method to calculate sieve of Eratosthenes
	public static List<Integer> sieveOfEratosthenes(int n) {
		// Declaring a boolean array of size n+1
		// Where true denotes prime and false denotes non prime
		// Initially all the values will be prime
		// After calculation we will update the values
		boolean isPrime[] = new boolean[n + 1];

		// Initializing all the value as true
		for (int i = 0; i <= n; i++) {
			isPrime[i] = true;
		}

		// Declaring 0 and 1 as non prime
		isPrime[0] = isPrime[1] = false;

		// Calculating the primes
		for (int i = 2; i * i <= n; i++) {
			// If isPrime[i] is true then it is prime
			if (isPrime[i] == true) {
				// Then all of its multiples will be non prime
				for (int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}

		// Declaring a list to store all the primes
		List<Integer> primes = new ArrayList<Integer>();

		// Storing all the primes in the list
		for (int i = 0; i <= n; i++) {
			if (isPrime[i] == true) {
				primes.add(i);
			}
		}

		// Returning the list containing all the primes
		return primes;
	}

	// Method to calculate segmented sieve
	public static List<Long> segmentedSieve(long left, long right) {
		// If left limit is less than 1, then make it 1
		if (left < 1) {
			left = 1;
		}

		// Calling the method to calculate regular sieve up to square root of right limit
		int n = (int) Math.sqrt(right);
		List<Integer> primes = sieveOfEratosthenes(n);

		// Declaring a boolean array of size (right-left)+1
		int size = (int) (right - left);
		boolean isPrime[] = new boolean[size + 1];

		// Initializing the array with true
		for (int i = 0; i <= size; i++) {
			isPrime[i] = true;
		}

		// Finding out the multiples of "List<integer> primes" in the range (left to right)
		// And marking them as non prime
		for (int i = 0; i < primes.size(); i++) {
			// Currently selected prime
			int currentPrime = primes.get(i);

			// Base is the lowest value in left to right range, that is a multiple of currently selected prime
			// We used (n/i)*i formula here
			long base = (long) ((left / currentPrime) * currentPrime);

			// If some how base becomes smaller number than the left limit
			// We chose the next number that is a multiple of currently selected prime
			if (base < left) {
				base = base + currentPrime;
			}

			// Mark all the multiples of currently selected prime as non prime
			for (long j = base; j <= right; j += currentPrime) {
				int index = (int) (j - left);
				isPrime[index] = false;
			}

			// In some exceptional cases, currently selected prime will be the base
			// In those cases currently selected prime will be marked as non prime. Which is not true
			// To handle this, we need to ensure that currently selected prime is marked as prime
			if (base == currentPrime) {
				int index = (int) (base - left);
				isPrime[index] = true;
			}
		}

		// Declaring a list to store the segmented sieve
		List<Long> segSieve = new ArrayList<Long>();

		// Storing the primes in between the range left to right (including left & right)
		for (int i = 0; i <= size; i++) {
			if (isPrime[i] == true) {
				long num = i + left;
				// Adding the primes to the list except 1
				if (num != 1) {
					segSieve.add(num);
				}
			}
		}

		// returning the list
		return segSieve;
	}

	// Main method to test and run the program
	public static void main(String[] args) {
		// Scanner object to scan input
		Scanner sc = new Scanner(System.in);

		// Asking user for the range and taking inputs
		long left, right;
		System.out.println("Enter the range (low limit and high limit): ");
		left = sc.nextLong();
		right = sc.nextLong();

		// Calling the method to calculated segmented sieve
		List<Long> segSieve = segmentedSieve(left, right);

		// Printing the segmented sieve
		System.out.println("Primes between " + left + " and " + right + " :");
		System.out.println(segSieve);

		// Closing the scanner object
		sc.close();
	}

}
