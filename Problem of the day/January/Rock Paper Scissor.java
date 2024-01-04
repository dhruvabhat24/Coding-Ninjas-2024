public class Solution {

    public static int[] rockPaperScissor(int k, String nezuko, String zenitsu) {
        // Initialize size of both the strings.
        int n = nezuko.length();
        int z = zenitsu.length();

        // Initialize count for both the player.
        int nezukoCount = 0;
        int zenitsuCount = 0;

        // Play all the games.
        for (int i = 0; i < k; i++) {

            // Store the move of zenitsu and nezuko.
            char nezukoMove = nezuko.charAt(i % n);
            char zenitsuMove = zenitsu.charAt(i % z);

            // If nezuko make 'Rock'.
            if (nezukoMove == 'R') {
                // If zenitsu make 'Paper' then zenitsu wins.
                if (zenitsuMove == 'P') {
                    zenitsuCount++;
                }
                // If zenitsu make 'Scissor' then nezuko wins.
                else if (zenitsuMove == 'S') {
                    nezukoCount++;
                }
            }
            // If nezuko make 'Paper'.
            else if (nezukoMove == 'P') {
                // If zenitsu make 'Scissor' then zenitsu wins.
                if (zenitsuMove == 'S') {
                    zenitsuCount++;
                }
                // If zenitsu make 'Rock' then nezuko wins.
                else if (zenitsuMove == 'R') {
                    nezukoCount++;
                }
            }
            // If nezuko make 'Scissor'.
            else {
                // If zenitsu make 'Rock' then zenitsu wins.
                if (zenitsuMove == 'R') {
                    zenitsuCount++;
                }
                // If zenitsu make 'Paper' then nezuko wins.
                else if (zenitsuMove == 'P') {
                    nezukoCount++;
                }
            }
        }
        int[] ans = new int[] {
            nezukoCount,
            zenitsuCount
        };
        return ans;
    }

}
