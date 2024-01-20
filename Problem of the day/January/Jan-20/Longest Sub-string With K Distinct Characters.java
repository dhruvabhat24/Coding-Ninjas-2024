public class Solution {

    // Returns the number of distinct characters in the array 'freq'.
    public static int countDistinct(int[] freq) {
        int distinct = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                distinct++;
            }
        }

        return distinct;
    }

    public static int getLengthofLongestSubstring(String s, int k) {

        int longestLength = 0;
        int n = s.length();

        int freq[] = new int[26];

        // Starting index of the window.
        int start = 0;

        // Traverse for ending index of the window.
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;

            while (countDistinct(freq) > k) {
                freq[s.charAt(start) - 'a']--;
                start++;
            }

            longestLength = Math.max(longestLength, i - start + 1);
        }

        return longestLength;
    }
}
