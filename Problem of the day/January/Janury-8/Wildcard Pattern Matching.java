public class Solution {
    public static Boolean dp[][];
    public static boolean rec(int i,int j, String s,String p){
       if(dp[i][j]!=null) return dp[i][j];
       boolean b=false;
       if(i==s.length() && j==p.length()) b=true;
       else if(j==p.length()) b=false;
       else if(i==s.length()) b=p.charAt(j)=='*' && rec(i,j+1,s,p);
       else if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') b=rec(i+1,j+1,s,p);
       else if(p.charAt(j)=='*') b=rec(i+1,j,s,p) || rec(i,j+1,s,p);
       return dp[i][j]=b;
    }
	public static boolean wildcardMatching(String pattern, String text) {
		// Write your code here.
        int m=pattern.length(), n=text.length();
        dp=new Boolean[n+1][m+1];
        return rec(0,0,text,pattern);
	}
}
