import java.util.* ;
import java.io.*; 
public class Solution {

	public static int[] findCost(int n, String str, int m, int[][] queries) {

		// Store all possible combinations.
		char[][] possibleComb = { { 'a', 'b', 'c' }, { 'a', 'c', 'b' }, { 'b', 'c', 'a' }, { 'b', 'a', 'c' },
				{ 'c', 'b', 'a' }, { 'c', 'a', 'b' } };

		// To store pre-computed data.
		int[][] dp = new int[6][n + 1];

		//
		for (int i = 0; i < 6; i++) {

			int count = 0;
			for (int j = 1; j <= n; j++) {

				// If there is a mismatch between the current pretty string's character
				// and the input string's character:
				if (possibleComb[i][(j - 1) % 3] != str.charAt(j - 1)) {

					count++;
				}

				dp[i][j] = count;
			}
		}

		// To store the answer to each query.
		int[] ans = new int[m];

		// Start solving the queries.
		for (int i = 0; i < m; i++) {

			int l = queries[i][0];
			int r = queries[i][1];

			int min = Integer.MAX_VALUE;

			// Cost will be MINIMUM('DP['J']['R'] - 'DP'['J']['L] - 1])
			for (int j = 0; j < 6; j++) {

				min = Math.min(min, dp[j][r] - dp[j][l - 1]);
			}

			ans[i] = min;

		}

		return ans;
	}

}
