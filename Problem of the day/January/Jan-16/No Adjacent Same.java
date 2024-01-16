import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean checkBits(int n) {
        // Write your code here.
    int flag1 =0;

    int flag0 =0;
    if((n & 1) ==1)
    {
     flag1=1;
     n=n>>1;
    }
    else{
        flag0=1;
        n=n>>1;
    }
    while(n>0)
    {
    if(((n & 1) ==1) && flag0==1 && flag1==0)
    {
    flag1=1;
    flag0=0;
    }
    else if(((n & 1) ==0) && flag1==1 && flag0==0)
    {
    flag0=1;
    flag1 =0;
    }
    else
    {
    return false;
    }
    n=n>>1;
    }
    return true;
    }
}
