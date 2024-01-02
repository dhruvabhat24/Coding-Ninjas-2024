
/*

	Time Complexity : O(N)
	Space Complexity : O(1)
	
	where N is the length of the array arr.
*/
public class Solution {

	public static int minimumSwap(int[] arr, int n) {

		// We will maintain two answer, and return the minimum of them.
		int right = 0, left = 0, ans1 = 0, ans2 = 0;

		// Firstly we will try to push all the 1s towards the left side.
		for (int i = right; i < n; i++) {
			// If there is no one at the left side then we dont need to do anything.
			if (arr[i] == 0) {
				continue;
			}

			// Count the number of zeros behind.
			ans1 += i - left;
			left++;
		}

		// Now we will start from the end.
		right = n - 1;
		left = n - 1;

		// Now we will try to push all the 1s towards the right side.
		for (int i = right; i >= 0; i--) {
			// If there is no one at the right side then we dont need to do anything.
			if (arr[i] == 0) {
				continue;
			}

			// Count the number of zeros ahead.
			ans2 += left - i;
			left--;
		}

		// Minimum of both the answer will be our final answer.
		return Math.min(ans1, ans2);
	}

}
