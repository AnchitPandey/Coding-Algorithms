/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int total =1;
    
    public void dfs (TreeNode curr, int max)
    {
        if (curr.val >= max)
        {
            total+=1;
            max = curr.val;
        }
        if (curr.left != null)
            dfs (curr.left, max);
        if (curr.right != null)
            dfs (curr.right,max);
        return;
    }
    
    public int goodNodes(TreeNode root) {
        total =0;
        int max = root.val;
        dfs (root, max);
        return total;
    }
}
