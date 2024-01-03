import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import javafx.util.Pair;

class MyComp implements Comparator<Pair<Integer, Integer>> {

	public int compare(Pair<Integer, Integer> p, Pair<Integer, Integer> p2) {

		if(p.getValue() == p2.getValue())
			return p.getKey() - p2.getKey();
		return p2.getValue() - p.getValue();
	}
}
public class Solution {
	public static int internshipExp(int d, int k, int n, ArrayList<Integer> minExp, ArrayList<Integer> expGained) {
		// Write your code here
		ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();

		for(int i = 0; i < n; i++) {
			list.add(new Pair<>(minExp.get(i), expGained.get(i)));
		}

		Collections.sort(list, new MyComp());
		int i = 0;

		while(i < n) {
			if(k == 0) {
				break;
			}

			Pair<Integer, Integer> p = list.get(i);

			if(p.getKey() <= d) {
				d += p.getValue();
				k--;
				list.remove(i);
				i = 0;
			} else {
				i++;
			}
		}

		return d;
	}
}
