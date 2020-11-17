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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
       TreeNode a1 =null , a2 = null;
       Queue<TreeNode> qu = new LinkedList<TreeNode>();
       qu.add (root);
    while (!qu.isEmpty())
    {
        TreeNode curr = qu.poll();
        if (curr.val == p.val)
        {
            a1 =curr;   
        }       
        
        if (curr.val == q.val)
        {
            a2 =curr;   
        } 
        if (curr.left != null)
            qu.add(curr.left);
        
          if (curr.right != null)
            qu.add(curr.right);
        
        
    }
    if (a1 == null || a2 == null)
        return null;
    
    HashMap<TreeNode, TreeNode> par = new HashMap<TreeNode, TreeNode>();
        par.put (root, null);
        qu.add (root);
        
        while (!qu.isEmpty())
        {
            TreeNode curr = qu.poll();
            if (curr.left != null)
            {
                par.put (curr.left, curr);
                qu.add (curr.left);
            }
            if (curr.right != null)
            {
                par.put (curr.right, curr);
                qu.add (curr.right);
            }
        }
        HashMap<TreeNode, Integer> dt1 = new HashMap<TreeNode, Integer>();
        TreeNode tr = a1;
        while (tr != null)
        {
            dt1.put (tr,1);
            tr = par.get(tr);
        }
        TreeNode fa= null;
         tr = a2;
        while (tr != null)
        {
            if (dt1.containsKey (tr))
            {
                fa = tr;
                break;
            }
            tr = par.get(tr);
        }
        
    return fa;       
        
        
    }
}
