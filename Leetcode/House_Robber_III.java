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
    
    HashMap<TreeNode,Integer> mapper;
    public void dfs (TreeNode curr, HashMap<TreeNode, Integer> opt)
    {
        if (curr.left == null && curr.right == null)
        {
            opt.put (curr, curr.val);
            return;
        }
        if (curr.left != null)
            dfs (curr.left, opt);
        if (curr.right != null)
            dfs (curr.right,opt);
        
        int left1 =0, left2 = 0, right1 =0, right2 =0, leftChild =0, rightChild =0;
        
        if(curr.left != null)
        {
            leftChild = opt.get(curr.left);
            if (opt.containsKey (curr.left.left))
                left1 = opt.get(curr.left.left);
            
            if (opt.containsKey (curr.left.right))
                left2 = opt.get(curr.left.right);
        }

        if (curr.right !=null)
        {
            rightChild = opt.get(curr.right);
            if (opt.containsKey (curr.right.left))
                right1 = opt.get(curr.right.left);
            
            if (opt.containsKey (curr.right.right))
                right2 = opt.get(curr.right.right);
        }
        
        int putter = Integer.max (curr.val + left1 + left2 + right1 + right2, leftChild + rightChild);
        opt.put (curr, putter);
        return;
    }
    
    public int rob(TreeNode root) {
        
        if (root == null)
            return 0;
        mapper = new HashMap<TreeNode, Integer>();
        dfs (root, mapper);    
        return mapper.get(root);
    }
}
