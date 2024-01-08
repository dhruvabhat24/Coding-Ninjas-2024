import java.util.HashSet;

 

public class Solution {

    public static boolean isGoodNumber(int n) {

        // Write your code here.

        HashSet<Integer> hs=new HashSet<>();

        while(n!=1)

        {

            if(hs.contains(n))

            {

                return false;

            }

            hs.add(n);

        int ans=0;

        while(n>=1)

        {

            int res=n%10;

            ans+=res*res;

            n=n/10;

        }

        n=ans;

    }

    return true;

    }

}   
