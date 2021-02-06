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
    int max =1 ;
    
    public int[] dfs (TreeNode curr)
    {
        if (curr.right== null && curr.left == null)
        {
            return new int[] {curr.val,1};
        }
        int[] leftChild = new int[] {-1,0},rightChild = new int[] {-1,0};
        if (curr.left != null)
            leftChild = dfs (curr.left);
        if (curr.right != null)
            rightChild = dfs (curr.right);
        if (curr.left != null && curr.right != null && curr.left.val == curr.right.val && curr.left.val == curr.val)
        {
            max = Integer.max(max, leftChild[1] + rightChild[1] +1);  
        }
        
        int maxi  = 0;
        if (curr.left != null)
        {
            if (curr.left.val == curr.val)
            {
                maxi = leftChild[1]+1;
            }
            else
                maxi = Integer.max (maxi, 1);
        }
        if (curr.right != null)
        {
            if (curr.right.val == curr.val)
            {
                maxi = Integer.max (maxi, rightChild[1]+1);
            }
            else
                maxi = Integer.max (maxi,1);
        }
        max = Integer.max (max, maxi);
        return new int[] {curr.val, maxi};
    }
        
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        max = 1;
        dfs (root);
        return max-1;
    }
}
