import java.util.* ;
import java.io.*; 
public class Solution
{
public static int minSubarraySum(ArrayList<Integer> arr, int n, int k)
   {
       // Write your code here.
         int sum = 0, j = 0;
         while(j < k)
             sum += arr.get(j++);
         int minSum = sum;
         for(int i = 0; i < n - k; i++){
             sum = sum - arr.get(i) + arr.get(j++);
             minSum = Math.min(minSum, sum);
         }
         return minSum;
   }
   
}
