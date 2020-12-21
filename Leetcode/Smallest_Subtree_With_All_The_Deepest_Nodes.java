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
    

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        
        HashMap<TreeNode, Integer> dm = new HashMap<TreeNode, Integer>();
        HashMap <TreeNode, TreeNode> parent = new HashMap<TreeNode, TreeNode>();
        parent.put (root, null);
        int max =-1;
        HashMap<TreeNode, Integer> counterMap = new HashMap<TreeNode, Integer>();
        ArrayList<TreeNode> ls = new ArrayList<TreeNode>();
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add (root);
        dm.put (root, 0);
        while (!qu.isEmpty())
        {
            TreeNode curr = qu.poll();
            if (curr.left == null && curr.right == null)
            {
                max = Integer.max (max, dm.get(curr));
                ls.add (curr);
                continue;
            }            
            if (curr.left != null)
            {
                parent.put (curr.left, curr);
                qu.add (curr.left);
                dm.put (curr.left, dm.get(curr)+1);
            }
            if (curr.right != null)
            {
                parent.put (curr.right, curr);
                qu.add (curr.right);
                dm.put (curr.right, dm.get(curr)+1);
            }
        }
        int num =0;
        for (int i =0 ; i< ls.size();i+=1)
        {
            TreeNode curr = ls.get(i);
            if (dm.get(curr) == max)
            {
                num +=1;
                while (curr != null)
                {
                    counterMap.put (curr, counterMap.getOrDefault(curr,0)+1);
                    curr = parent.get(curr);
                }
            }            
        }
        TreeNode ans=null;
        qu.add (root);
        while (!qu.isEmpty())
        {
            TreeNode curr = qu.poll();
            if (counterMap.containsKey (curr) && counterMap.get(curr) == num )   
                ans = curr;
            if (curr.left != null)
                qu.add (curr.left);
            
            if (curr.right != null)
                qu.add (curr.right);   
        }
        return ans;
    }
}
