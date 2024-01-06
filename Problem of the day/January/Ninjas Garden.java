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
