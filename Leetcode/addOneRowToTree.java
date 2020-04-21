/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class addOneRowToTree {
    public void dfs (TreeNode curr, int d, int v, int currd)
    { 
        if (currd == d-1)
        {
            TreeNode newnode = new TreeNode(v);
                newnode.left = curr.left;
                newnode.right = null;
                curr.left = newnode;
              
            
                TreeNode newnode1 = new TreeNode(v);
                newnode1.right = curr.right;
                newnode1.left = null;
                curr.right = newnode1;
                     
        return;
        }
        if (curr.left != null)
            dfs (curr.left,d,v, currd+1);
            
        if (curr.right != null)
            dfs (curr.right, d, v, currd+1);
    }
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d ==1)
        {
            TreeNode newnode = new TreeNode(v);
            newnode.left  = root;
            return newnode;            
        }
        dfs (root, d,v,1);
        return root;
    }
}
