import java.util.*;
public class Solution {

   
    static ArrayList<Integer> arr = new ArrayList<>();

    // Fix the base case for preorder traversal
    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        preorder(root.left);
        arr.add(root.data);
        preorder(root.right);
    }

    // Fix the return type and return the kth smallest element
    public static int kthSmallest(TreeNode root, int k) {
        preorder(root);
        return arr.get(k-1);
    }

}
