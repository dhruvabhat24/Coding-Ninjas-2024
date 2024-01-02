import java.util.* ;
import java.io.*; 
public class Solution 
{
  public static Stack<Integer> pushAtBottom(Stack <Integer> st, int x) 
  {
    // Write your code here
    if(st.isEmpty()){
      st.push(x);
      return st;
    }
    int top = st.pop();
    pushAtBottom(st,x);
    st.push(top);
    return st;
  }
}
