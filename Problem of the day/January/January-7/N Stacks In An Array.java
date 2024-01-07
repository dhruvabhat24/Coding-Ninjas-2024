import java.util.*;
public class NStack {
    // Initialize your data structure.
    int[] arr;
    int[] top;
    int[] next;
    int n;
    int s;
    int freespot;
    public NStack(int N, int S) {
        // Write your code here.
        n=N;
        s=S;
        arr=new int[s];
        top=new int[n];
        next=new int[s];
        
        // top initialize
        Arrays.fill(top,-1);
        // next initialize
        for(int i=0;i<s;i++)
        {
            next[i]=i+1;
        }
        next[s-1]=-1;
        //free spot intialize
        freespot=0;
    }

    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack, and false otherwise.
    public boolean push(int x, int m) {
        // Write your code here.
        //Overflow
        if(freespot==-1)
            
        {
            return false;
        }
        // Step 1
        int index=freespot;
        //Step 2
        freespot=next[index];
        //Step 3
        arr[index]=x;
        //Step 4
        next[index]=top[m-1];
        //Step 5
        top[m-1]=index;
        
        return true;
        
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
    public int pop(int m) {
        // Write your code here.
        //Underflow
        if(top[m-1]==-1)
        {
            return -1;
        }
        
        int index=top[m-1];
        top[m-1]=next[index];
        next[index]=freespot;
        freespot=index;
        return arr[index];
        
    }
}
