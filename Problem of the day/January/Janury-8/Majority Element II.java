import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) 
    {
        // Write your code here.
        int n = arr.size();
        int floor = (int)(Math.floor(n/3));

        if(n < 3)  return arr;

        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(Integer i : arr){
            if(mp.containsKey(i)){
                int val = mp.get(i);
                if(val+1 > floor)
                    if(!ans.contains(i))    ans.add(i);  
                mp.put(i,val+1);
            }else{
                mp.put(i,1);
            }
        }

        return ans;
    }
}
