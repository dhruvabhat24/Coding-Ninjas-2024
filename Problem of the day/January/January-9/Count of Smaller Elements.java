import java.util.*;
public class Solution {
    public static int binarySearch(List<Integer> d,int tar){
        int l=0,r=d.size()-1,mid=0;
        while(l<=r){
          mid=(l+r)/2;
          if(d.get(mid)<tar) l=mid+1;
          else r=mid-1;
        }
        if(d.get(l)==tar) return l;
        return mid;
    }
    public static int[] countNumber(int n, int[] arr) {
        // Write your code here.
        List<Integer> d=new ArrayList<>();
        int ans[]=new int[n],j=0;
        for(int i:arr) d.add(i);
        Collections.sort(d);
        for(int i:arr){
           int currIdx=binarySearch(d,i);
           ans[j++]=currIdx;
           d.remove(currIdx);
        }
        return ans;
    } 
}
