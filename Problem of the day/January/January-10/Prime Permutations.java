import java.util.* ;
import java.io.*; 
public class Solution {
	
	// This functions check whether a number is prime or not.
	public static boolean isPrime(int num) {

	    // If a number is not divisible by any number upto its square root,
	    // then it is a prime number.
	    for (int i = 2; i * i <= num; i++) {
	        if (num % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}

	public static int findPrimePermutations(int n) {
		// Define a variable to store the count of prime numbers in the given range.
	    int primeCount = 0;
	    for (int num = 2; num <= n; num++) {
	        if (isPrime(num) == true) {
	            primeCount++;
	        }
	    }

	    long mod = 1000000007;

	    // Define a variable to store the number of different arrangements.
	    long permutationsCount = 1;

	    for (int i = 2; i <= primeCount; i++) {
	        permutationsCount *= i;
	        permutationsCount %= mod;
	    }

	    for (int i = 2; i <= n - primeCount; i++) {
	        permutationsCount *= i;
	        permutationsCount %= mod;
	    }

	    return (int)permutationsCount;
	}

}
