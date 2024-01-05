import java.util.*;

public class Solution {
    public static int compare(ArrayList<Integer> i1, ArrayList<Integer> i2){
        if(i1.get(0) < i2.get(0)){
            return 1;
        }
        return 0;
    }
    
    public static int find(int ds[], int i){
         if(ds[i] < 0){
             return i;
         }
         return ds[i] = find(ds, ds[i]);
    }
    public static void process(ArrayList<ArrayList<Integer>> mm, ArrayList<ArrayList<Integer>> crds, int cols[], int rows[]){
        int ds[] = new int[mm.size() + mm.get(0).size()];
        
        for(int i = 0; i < ds.length; i++){
            ds[i] = -1;
        }
        
        for(int x = 0; x < crds.size(); x++){
            int i = crds.get(x).get(0);
            int j = crds.get(x).get(1);
            int pi = find(ds, i);
            int pj = find(ds, rows.length + j);

            if (pi != pj)
            {
                ds[pi] = Math.min(ds[pi], Math.min(ds[pj], -Math.max(rows[i], cols[j]) - 1));
                ds[pj] = pi;
            }
        }

        for(int x = 0; x < crds.size(); x++){
            int i = crds.get(x).get(0), j = crds.get(x).get(1);
            rows[i] = cols[j] = -ds[find(ds, i)];
            mm.get(i).set(j,rows[i]);
        }
    }

    public static ArrayList<ArrayList<Integer>> ninjaTransformation(ArrayList<ArrayList<Integer>> matrix) {
        int si = matrix.size(), sj = matrix.get(0).size(), lastVal = Integer.MIN_VALUE;
        ArrayList<ArrayList<Integer>> mm = new ArrayList<ArrayList<Integer>>();
        int rows[] = new int[si];
        int cols[] = new int[sj];

        for (int i = 0; i < si; ++i){
            for (int j = 0; j < sj; ++j){
                ArrayList<Integer> new_array = new ArrayList<Integer>();
                new_array.add(matrix.get(i).get(j));
                new_array.add(i);
                new_array.add(j);
                mm.add(new_array);
            }
        }

        	mm.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        ArrayList<ArrayList<Integer>> crds = new ArrayList<ArrayList<Integer>>();

        for(int x = 0; x < mm.size(); x++){
            int val = mm.get(x).get(0), i = mm.get(x).get(1), j = mm.get(x).get(2);
            if (val != lastVal){
                process(matrix, crds, cols, rows);
                lastVal = val;
                crds.clear();
            }
            ArrayList<Integer> new_array = new ArrayList<Integer>();
            new_array.add(i);
            new_array.add(j);
            crds.add(new_array);
        }

        process(matrix, crds, cols, rows);
        return matrix;
    }
}
