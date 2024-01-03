import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Comparator;

class Region {
    Set<Integer> infected = new HashSet<>();
    Set<Integer> uninfectedNeighbors = new HashSet<>();
    int wallsRequired = 0;
}

public class Solution {
    
    public static void dfs(ArrayList<ArrayList<Integer>> edges, int row, int col, boolean[][] visited, Region region) {
        int rows = edges.size();
        int cols = edges.get(0).size();

        if (row < 0 || row >= rows || col < 0 || col >= cols || edges.get(row).get(col) == 2) {
            return;
        }

        if (edges.get(row).get(col) == 1) {
            region.infected.add(row * cols + col);
            if (visited[row][col]) {
                return;
            }
        }

        visited[row][col] = true;

        if (edges.get(row).get(col) == 0) {
            region.wallsRequired++;
            region.uninfectedNeighbors.add(row * cols + col);
            return;
        }
        dfs(edges, row + 1, col, visited, region);
        dfs(edges, row - 1, col, visited, region);
        dfs(edges, row, col + 1, visited, region);
        dfs(edges, row, col - 1, visited, region);
    }
	public static int containVirus(ArrayList<ArrayList<Integer>> edges) {
        if (edges.size() == 0 || edges.get(0).size() == 0) {
            return 0;
    	}

        int rows = edges.size();
        int cols = edges.get(0).size();

        int result = 0;

        while (true) {
            List<Region> regions = new ArrayList<>();
            boolean[][] visited = new boolean[rows][cols];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (edges.get(row).get(col) == 1 && !visited[row][col]) {
                        Region region = new Region();
                        dfs(edges, row, col, visited, region);
                        if (region.uninfectedNeighbors.size() > 0) {
                            regions.add(region);
                        }
                    }
                }
            }

            if (regions.size() == 0) {
                break;
            }
            regions.sort(new Comparator<Region>() {
                @Override
                public int compare(Region o1, Region o2) {
                    return o2.uninfectedNeighbors.size() - o1.uninfectedNeighbors.size();
                }
            });
            Region regionThatCauseMostInfection = regions.remove(0);
            result += regionThatCauseMostInfection.wallsRequired;

            for (int neighbor : regionThatCauseMostInfection.infected) {
                int row = neighbor / cols;
                int col = neighbor % cols;
                edges.get(row).set(col, 2);
            }
            for (Region region : regions) {
                for (int neighbor : region.uninfectedNeighbors) {
                    int row = neighbor / cols;
                    int col = neighbor % cols;
                    edges.get(row).set(col, 1);
                }
            }
        }

        return result;
        
    }	
}
