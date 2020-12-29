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
    Set<Integer> set;
    TreeNode ans;
    
    public int dfs (TreeNode curr)
    {
        if (ans != null)
            return 0;
        int self = set.contains(curr.val) ? 1 : 0;
        int left =0, right =0;
        if (curr.left != null)
           left = dfs (curr.left);
        if (curr.right != null)
           right = dfs (curr.right);
       
        if (self + left + right ==  set.size())
        {
            ans = curr;
            return 0;
        } 
        return left + right + self;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        set = new HashSet<Integer>();
        ans = null;
        for (int i =0 ; i< nodes.length;i+=1)
            set.add (nodes[i].val);
        dfs (root);
        return ans;
    }
}
