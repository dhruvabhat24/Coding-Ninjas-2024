import java.util.*;

public class Solution {
    public static BinaryTreeNode<Integer> solve(BinaryTreeNode<Integer> root) {
        if (root.left == null)
            return root.right;

        if (root.right == null)
            return root.left;

        BinaryTreeNode<Integer> lefty = root.left;
        BinaryTreeNode<Integer> righty = root.right;

        while (righty.left != null)
            righty = righty.left;

        righty.left = lefty;
        return root.right;
    }

    public static BinaryTreeNode<Integer> deleteNode(BinaryTreeNode<Integer> root, int key) {
        if (root == null)
            return null;

        if (root.data == key)
            return solve(root);

        BinaryTreeNode<Integer> curr = root;
        while (curr != null) {
            if (key < curr.data) {
                if (curr.left != null && curr.left.data == key)
                    curr.left = solve(curr.left);
                else
                    curr = curr.left;
            } else {
                if (curr.right != null && curr.right.data == key)
                    curr.right = solve(curr.right);
                else
                    curr = curr.right;
            }
        }

        return root;
    }
}
