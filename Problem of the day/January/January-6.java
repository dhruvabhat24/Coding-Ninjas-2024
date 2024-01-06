import java.util.ArrayList;

public class Solution {
	public static int ninjaGarden (ArrayList<Integer> flowers, int n, int k) {
		// Array for stoing days when flower is blooming
        ArrayList<Integer> dayOfFlowerBloomed = new ArrayList<Integer>(n);
        for(int i = 0; i < n; i++) {
            dayOfFlowerBloomed.add(i, 0);
        }
        // Iterating through the flower array
        for (int i = 0; i < n; i++) {
            int p = flowers.get(i) - 1;
            dayOfFlowerBloomed.set(p, i + 1);
        }

        int left = 0;
        int right = k + 1;
        int ans = n + 1;

        for (int i = 0; right < n; i++) {
            // Checking if flower is bloomed on left or right side
            if (dayOfFlowerBloomed.get(i) < dayOfFlowerBloomed.get(left) || dayOfFlowerBloomed.get(i) <= dayOfFlowerBloomed.get(right)) {
                if (i == right) {
                    // Storing maximum value of day
                    ans = Math.min(ans, Math.max(dayOfFlowerBloomed.get(left), dayOfFlowerBloomed.get(right)));
                }
                left = i;
                right = k + 1 + i;
            }
        }

        // If no window is found
        if (ans == n + 1) {
            return -1;
        }

        else {
            return ans;
        }
	}
}

// Question 2
// Find the maximum element in the array after update operations.
import java.util.ArrayList;

public class Solution {
    public static int findMaxElement(ArrayList < ArrayList < Integer >> arr, int n, int m) {
        int[] a = new int[n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = arr.get(i).get(0); j <= arr.get(i).get(1); j++) {
                a[j]++;
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, a[i]);
        }

        return ans;
    }
}


// Question 3
// Expanse Of Subsequences
import java.util.* ;
import java.io.*; 


public class Solution 
{
    public static int expanseOfSubsequences(int[] arr) 
    {
        // Size of array 'arr'.
        int n = arr.length;

        long result = 0;

        int mod = 1000000007;

        // Find all subsequence using bitmasking and add its expanse.
        for (int mask = 1; mask < (1 << n); mask++) 
        {
            int maxEle = 0, minEle = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) 
            {
                // If ith bit is set in 'mask'.
                if ((mask & (1 << i)) > 0) 
                {
                    maxEle = Math.max(maxEle, arr[i]);
                    minEle = Math.min(minEle, arr[i]);
                }
            }
   
            // Add expanse of subsequence represented by current 'mask'.
            result = result + (maxEle - minEle) % mod;
        }

        return (int)result;
    }
}
