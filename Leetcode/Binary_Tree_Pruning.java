/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public boolean dfs (TreeNode curr)
    {
        if (curr.left == null && curr.right == null)
        {
            if (curr.val ==0)
                return true;
            return false;
        }  
        boolean left =true, right = true;
        if (curr.left != null)
            left = dfs (curr.left);
        if (curr.right != null)
            right = dfs (curr.right);
        if (left)
            curr.left = null;
        if (right)
            curr.right = null;
        return left && right && curr.val ==0;
    }
    
    public TreeNode pruneTree(TreeNode root) {
        if (root ==null)
            return null;
       boolean ans = dfs (root);
       if (ans)
           return null;
        return root;
    }
}
