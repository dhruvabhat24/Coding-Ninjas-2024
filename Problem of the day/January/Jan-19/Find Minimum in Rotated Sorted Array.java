public class Solution {
    public static int findMin(int []arr) {
        int n=arr.length;
        int low=0;int high=n-1;int ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[low]<=arr[mid]){
           ans=Math.min(ans, arr[low]);
               low=mid+1;
            }
            else{
           ans=Math.min(ans, arr[mid]);
                high=mid-1;
            }
        }
        return ans;
    }
}
