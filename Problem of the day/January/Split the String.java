public class Solution {
    public static int splitString(String s) {
        // Initialize 'ans' to 0
        int ans = 0;

        // Run a for loop from 0 to s.length-2
        for (int i = 0; i <= (s.length() - 2); i++) {

            // Initialize frequency arrays for X & Y substrings   
            int[] freqX = new int[26];
            int[] freqY = new int[26];
            for (int j = 0; j < 26; j++) {
                freqX[j] = 0;
                freqY[j] = 0;
            }

            // Initialize variable to store count of distinct characters in X & Y substrings   
            int cntX = 0, cntY = 0;

            // Iterate all the string elements
            for (int j = 0; j < s.length(); j++) {

                // Substring 0....i
                if (j <= i) {

                    // Found a distinct character
                    if (freqX[s.charAt(j) - 'a'] == 0) {

                        // Set the frequency as 1 so that it is not recounted
                        freqX[s.charAt(j) - 'a'] = 1;

                        // Increment the value of cntX
                        cntX++;
                    }

                }

                // Substring (i+1).....(s.length-1)
                else {

                    // Found a distinct character
                    if (freqY[s.charAt(j) - 'a'] == 0) {

                        // // Set the frequency as 1 so that it is not recounted
                        freqY[s.charAt(j) - 'a'] = 1;

                        // Increment the value of cntY
                        cntY++;
                    }

                }

            }

            // Current splitting in good
            if (cntX == cntY) {

                ans++;

            }

        }

        return ans;
    }
}
