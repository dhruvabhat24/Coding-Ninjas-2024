import java.util.HashMap;

public class Solution {

	public static int[] specialSubarray(int n, int[] arr) {

		// Initialize a map 'LEFT' to store left most occurrence of every element.
		HashMap<Integer, Integer> left = new HashMap<Integer, Integer>();

		// Initialize a map 'FREQMAP' to store frequency of every element.
		HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();

		// Initialize a variable 'MAXFREQ' to store maximum frequency.
		int maxFreq = 0;

		// Initialize a variable 'MINLEN' to store length of smallest result subarray.
		int minLen = -1;

		// Initialize a variable 'STARTIDX' to store starting index of smallest result subarray
		int startIdx = -1;

		// Iterate 'I' in 0 to 'N':
		for (int i = 0; i < n; i++) {

			// Set 'X' as 'ARR[I]'.
			int x = arr[i];

			// If current element is not present in 'FREQMAP':
			if (!freqMap.containsKey(x)) {

				// Put ('X', 'I') key-value pair in 'LEFT'.
				left.put(x, i);

				// Put ('X', 1) key-value pair in 'FREQMAP'.
				freqMap.put(x, 1);
			}

			// Otherwise, increase the frequency of current element in 'FREQMAP'.
			else {

				freqMap.put(x, freqMap.get(x) + 1);
			}

			// If frequency of current element is greater than 'MAXFREQ':
			if (freqMap.get(x) > maxFreq) {

				// Set 'MAXFREQ' as 'FREQMAP.GET(X)'.
				maxFreq = freqMap.get(x);

				// Set 'MINLEN' as ('I' - 'LEFT.GET(X)' + 1).
				minLen = i - left.get(x) + 1;

				// Set 'STARTIDX' as 'LEFT.GET(X)'
				startIdx = left.get(x);
			}

			// select subsegment of smallest size

			// If frequency of current element is equal to 'MAXFREQ' and ('I' - 'LEFT.GET(X)' + 1) is less than 'MINLENGTH':
			else if ((freqMap.get(x) == maxFreq) && (i - left.get(x) + 1 < minLen)) {

				// Set 'MINLEN' as ('I' - 'LEFT.GET(X)' + 1).
				minLen = i - left.get(x) + 1;

				// Set 'STARTIDX' as 'LEFT.GET(X)'
				startIdx = left.get(x);
			}
		}

		// Initialize an integer array 'ANS' to store the output.
		int ans[] = new int[minLen];

		// Initialize a variable 'IDX' to iterate through 'ANS'.
		int idx = 0;

		// Iterate 'I' in 'STARTIDX' to 'STARTIDX' + 'MINLEN':
		for (int i = startIdx; i < startIdx + minLen; i++) {

			// Set 'ANS[IDX]' as 'ARR[I]' and increment 'IDX' by 1.
			ans[idx++] = arr[i];
		}

		// Return 'ANS'.
		return ans;
	}

}
