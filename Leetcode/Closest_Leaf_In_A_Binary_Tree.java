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
    
    public int findClosestLeaf(TreeNode root, int k) {
    
        HashMap<TreeNode, TreeNode> pm = new HashMap<TreeNode, TreeNode>();
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add (root);
        pm.put (root, null);
        Set<TreeNode> visited = new HashSet<TreeNode>();
        while (!qu.isEmpty())
        {
            TreeNode curr = qu.poll();
            if (curr.val == k)
            {   
                root = curr;
                qu = new LinkedList<TreeNode>();
                visited.add (root);
                qu.add (root);
                break;
            }
            if (curr.left != null)
            {
                pm.put (curr.left, curr);
                qu.add (curr.left);
            }
            if (curr.right != null)
            {
                pm.put (curr.right, curr);
                qu.add (curr.right);
            } 
        }
        int min = Integer.MAX_VALUE;
        TreeNode ans = null;
        while (!qu.isEmpty())
        {
            TreeNode curr = qu.poll();
            if (curr.left == null && curr.right == null)
                return curr.val;
            if (curr.left != null && !visited.contains(curr.left))
            {
                qu.add (curr.left);
                visited.add (curr.left);
            }
            if (curr.right != null && !visited.contains(curr.right))
            {
                qu.add (curr.right);
                visited.add (curr.right);
            }        
            if (pm.get(curr) != null && !visited.contains (pm.get(curr)))
            {
                qu.add (pm.get(curr));
                visited.add (pm.get(curr));        
            }
        }
        return -1;
    }
}
