public class Solution {
    public static String doorStatus(int n) {

        // Boolean array to store status of ith door.
        boolean[] status = new boolean[n + 1];
        // Traversing on each multiple of each ID and flipping the status.
        for (int id = 1; id <= n; ++id) {
            for (int j = id; j <= n; j += id) {
                status[j] = !status[j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; ++i) {
            // If final status[i] is open then it means that door is open so we will append '1'.
            if (status[i]) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }

        return sb.toString();
    }
}
