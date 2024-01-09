import java.util.PriorityQueue;
import javafx.util.Pair;
import java.util.Collections;
import java.util.Comparator;

class customComparator implements Comparator<Pair<Integer, Pair<Integer, Integer>>> {
    public int compare(Pair<Integer, Pair<Integer, Integer>> o1,
        Pair<Integer, Pair<Integer, Integer>> o2) {
        if (o1.getKey().equals(o2.getKey())) {
            Pair<Integer, Integer> o1pair = o1.getValue();
            Pair<Integer, Integer> o2pair = o2.getValue();
            if (o1pair.getKey().equals(o2pair.getKey())) {
                return o1pair.getValue() - o2pair.getValue();
            }
            return o1pair.getKey() - o2pair.getKey();
        }
        return o1.getKey() - o2.getKey();
    }
}

public class Solution {
    public static int trappingWater(int[][] matrix) {
        // Storing dimensions of matrix.
        int m = matrix.length;
        int n = matrix[0].length;

        // Initialise the visited vector.
        int[][] visited = new int[m][n];

        // Initialise priority queue.
        customComparator comp = new customComparator();
        PriorityQueue<Pair<Integer, Pair<Integer,Integer> > > q = new PriorityQueue<>(comp);

        // Initialise variable to store result.
        int res = 0;

        // Start traversing.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {

                    // Push border cells into priority queue.
                    Pair<Integer, Integer> temp = new Pair<Integer, Integer>(i, j);
                    Pair<Integer, Pair<Integer,Integer> > temp2 = 
                        new Pair<Integer, Pair<Integer,Integer> >(matrix[i][j], temp);
                    q.add(temp2);

                    // Mark them visited.
                    visited[i][j] = 1;
                }
            }
        }

        // Initialise variable to store minimum border height. 
        int minBH = 0;

        // Start traversing while priority queue is not empty.
        while (q.size() > 0) {

            // Store height of top cell in queue.
            int currentH = q.peek().getKey();

            // Initialise coordinates of top cell.
            int currentX = q.peek().getValue().getKey();
            int currentY = q.peek().getValue().getValue();

            // Update minimum border height.
            minBH = Math.max(minBH, currentH);

            // Pop the top element.
            q.remove();

            // Initialise vector to store directions.
            int[][] directions = new int[4][2];
            directions[0][0] = 0;
            directions[0][1] = 1;
            directions[1][0] = 0;
            directions[1][1] = -1;
            directions[2][0] = 1;
            directions[2][1] = 0;
            directions[3][0] = -1;
            directions[3][1] = 0;

            // Visit allthe neighbours of current cell.       
            for (int i = 0; i < 4; i++) {

                // Storing coordinates of neighbour cells.
                int newX = currentX + directions[i][0];
                int newY = currentY + directions[i][1];

                // If new coordinates point to valid cell and is not previously visited. 
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && visited[newX][newY] == 0) {

                    // Push into the priority queue.
                    Pair<Integer, Integer> temp = new Pair<Integer, Integer>(newX, newY);
                    Pair<Integer, Pair<Integer,Integer> > temp2 = 
                        new Pair<Integer, Pair<Integer,Integer> >(matrix[newX][newY], temp);
                    q.add(temp2);

                    // Mark as visited.
                    visited[newX][newY] = 1;

                    // If height less than minimum border height.  
                    if (matrix[newX][newY] < minBH) {

                        // Update res.
                        res = res + (minBH - matrix[newX][newY]);
                    }
                }
            }
        }

        // Return res.
        return res;
    }
}
