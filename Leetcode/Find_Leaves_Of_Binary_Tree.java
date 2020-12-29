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
    
    List<List<Integer>> ans;
    
    public int dfs (TreeNode curr)
    {
        int leftHeight =0, rightHeight =0;
        if (curr.left != null)        
            leftHeight = dfs (curr.left);
        
        if (curr.right != null)
            rightHeight = dfs(curr.right);
        
        int currentHeight = Integer.max (leftHeight, rightHeight) +1;        
        if (ans.size() < currentHeight)
        {
            List<Integer> ls = new ArrayList();
            ls.add (curr.val);
            ans.add (ls);
        }   
        else
        {
            List<Integer> ls = ans.get(currentHeight -1);
            ls.add (curr.val);
        }
        return currentHeight;        
    }
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        ans = new ArrayList();
        if (root == null)
            return ans;
        dfs (root);
        return ans;
    }
}
