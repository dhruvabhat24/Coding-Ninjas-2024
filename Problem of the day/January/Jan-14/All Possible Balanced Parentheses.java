import java.util.*;
import java.lang.*;

public class Solution 
{
	public static boolean isBalanced(String str, int n) 
	{
		int open = 0, close = 0;
		for (int i = 0; i < str.length(); i++) 
		{
			if (str.charAt(i) == '(') 
			{
				open++;
			} 
			else 
			{
				close++;
			}
			if (close > open || open > n) 
			{
				return false;
			}
		}
		return true;
	}

	public static void balancedParenthesesHelper(int i, String str, int n, ArrayList<String> ans) 
	{
		// Base case
		if (i == 2 * n) 
		{
			// Check if it is balanced or not
			if (isBalanced(str, n) == true) 
			{
				ans.add(str);
			}
			return;
		}
		// Include an open parenthesis
		str = str + '(';

		balancedParenthesesHelper(i + 1, str, n, ans);

		str = str.substring(0, str.length() - 1);

		// Include a close parenthesis
		str = str + ')';

		balancedParenthesesHelper(i + 1, str, n, ans);

		str = str.substring(0, str.length() - 1);
	}

	public static ArrayList<String> balancedParentheses(int n) 
	{
		// Stores the sequence of balanced parentheses
		ArrayList<String> ans = new ArrayList<String>();
		String str = "";
		balancedParenthesesHelper(0, str, n, ans);
		return ans;
	}
}
