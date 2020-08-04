/* In this program we are going to see how to calculate LCM of very large numbers
 * As we will face issue in handling very large integer number and their operations
 * Using regular primitive data type, we will going to use "BigInteger" class.
 * It is a wonderful and very powerful class in JAVA
 */

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerLCM {

	// Main method to run and test the program
	public static void main(String[] args) {
		// Scanner class object to take inputs
		Scanner sc = new Scanner(System.in);

		// Asking user for the total number of element to calculate LCM
		System.out.println("Number of element you want to calculte LCM for: ");
		int N = sc.nextInt();

		// Declaring array of BigIntegers of size N
		BigInteger bigArray[] = new BigInteger[N];

		// Scanning N numbers and storing hen in the BigInteger array
		System.out.println("Enter the numbers one by one: ");
		for (int i = 0; i < N; i++) {
			bigArray[i] = sc.nextBigInteger();
		}

		// Declaring variable of BigInteger type to store the LCM result
		BigInteger lcm;

		// Calculating LCM
		lcm = bigArray[0];
		for (int i = 1; i < N; i++) {
			lcm = (lcm.multiply(bigArray[i])).divide(lcm.gcd(bigArray[i]));
		}

		// Displaying the result
		System.out.println("LCM is: " + lcm);

		// Closing the scanner object
		sc.close();
	}

}
