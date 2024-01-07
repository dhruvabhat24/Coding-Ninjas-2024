import java.util.*;

public class NumArray {
    private ArrayList<Integer> arr;

    NumArray(int[] arr) {
        this.arr = new ArrayList<>();
        for (int num : arr) {
            this.arr.add(num);
        }
    }

    public void update(int l, int r, int val) {
        int x = 0;
        for (int i = l - 1; i < r; i++) {
            arr.set(i, arr.get(i) + (x + val));
            x++;
        }
    }

    public long rangeSum(int l, int r) {
        long s = 0;
        for (int i = l - 1; i < r; i++) {
            s += arr.get(i);
        }
        return s;
    }
}
