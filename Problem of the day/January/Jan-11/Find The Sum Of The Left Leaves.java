import java.util.* ;
public class Solution {
    public static int sumOfLeftLeaves(TreeNode<Integer> root) { 
		return rec(root);
    }
	static int rec(TreeNode<Integer> root) {
		if(root==null) return 0;
		if(root.left!=null && root.left.left==null && root.left.right==null) return root.left.data;
		return rec(root.left)+rec(root.right);
	}
}
