/* In this program we are going to learn how to simply and efficiently calculate
 * sieve for prime numbers using sieve of Eratosthenes method
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SieveOfEratosthenes {

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
		for (int i = 1; i <= n; i++) {
			if (isPrime[i] == true) {
				primes.add(i);
			}
		}

		// Returning the list containing all the primes
		return primes;
	}

	// Main method to run and test the program
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Taking input from the user about sieve size
		int n;
		System.out.println("Enter the limit: ");
		n = sc.nextInt();

		// Calling sieve of Eratosthenes method to calculate prime numbers
		// Up to limit n
		List<Integer> p = sieveOfEratosthenes(n);

		// Printing the primes
		System.out.println("The primes are:");
		System.out.println(p);

		// Closing the scanner object
		sc.close();
	}

}
