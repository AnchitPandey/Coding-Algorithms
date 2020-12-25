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
     int sum; 
    public int dfs (TreeNode curr)
    {
        if (curr.left == null && curr.right == null){
            return curr.val;
        }   
        int leftsum =0, rightsum =0;
        if (curr.left != null)
            leftsum = dfs (curr.left);
        if (curr.right != null)
            rightsum = dfs (curr.right);
        sum += Math.abs (leftsum - rightsum);
        return curr.val + leftsum + rightsum;
    }
    public int findTilt(TreeNode root) {
                  
        sum =0 ;       
        if (root == null)
            return sum;
        dfs (root);
        return sum;      
    }
}
