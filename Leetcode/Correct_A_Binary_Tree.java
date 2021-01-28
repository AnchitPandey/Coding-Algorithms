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
 
    boolean flag = false;   
    public void calldfs (TreeNode curr, TreeNode parent, HashMap<TreeNode,Integer> dm, char dir)
    {
        if (flag)
            return;
        if (curr.left == null && curr.right == null)
            return;
        //System.out.println("current node is "+curr.val);
        int currHeight = dm.get(curr);
        if (curr.right != null)
        {
            int rightHeight = dm.get(curr.right);
            if (currHeight == rightHeight)
            {
                //System.out.println("this happened at node " + curr.val);
                if (dir =='L')
                    parent.left = null;
                else
                    parent.right = null;
                flag = true;
                return;
            }           
        }
        if (curr.left != null)
            calldfs (curr.left,curr,dm,'L');
        if (curr.right != null)
            calldfs (curr.right, curr, dm, 'R');
        return;
    }
    
    public void dfs (TreeNode curr, HashMap<TreeNode, Integer> dm, int level)
    {
        if (curr == null)
            return;
        dm.put (curr,level);
        dfs (curr.left, dm,level+1);
        dfs (curr.right, dm, level+1);
    }
    
    public TreeNode correctBinaryTree(TreeNode root) {
       flag = false;
       HashMap<TreeNode, Integer> dm = new HashMap();
       dfs (root, dm, 0);
       calldfs (root,root,dm,'L');
       return root; 
    }
}
