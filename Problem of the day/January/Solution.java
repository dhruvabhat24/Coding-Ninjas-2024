import java .util.*;
public class Solution {

	public static boolean checkEvenPartitioning(int n) {
		int rem = n % 2;

		boolean answer;

		if (rem == 1) {
			answer = false;
		} else {

			if (n == 2) {
				answer = false;
			} else {
				answer = true;
			}
		}

		return answer;
	}

}