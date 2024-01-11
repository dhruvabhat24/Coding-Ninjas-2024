import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static boolean isPeriodic(String s) {
        if (s.length() == 1) {
            return false;
        }
    
        // To check for strings of type 'aaaaa', 'bbbbb'.
        int flag = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            return true;
        }
    
        // For all other string.
        int n = s.length();
        ArrayList<Integer> factor = new ArrayList<Integer>();
        // Making a factor array.
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                factor.add(i);
            }
        }
        int len, k;
        for (int i = 0; i < factor.size(); i++) {
            len = factor.get(i);
            String part = s.substring(0, len);
    
            // Finding 'K'.
            k = n / len;
            String check = "";
            while (k != 0) {
                check += part;
                k--;
            }
            if (check.equals(s)) {
                return true;
            }
        }
        return false;
    }
}
