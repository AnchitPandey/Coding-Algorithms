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
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        
        HashMap<TreeNode, Integer> mapper = new HashMap<TreeNode, Integer>();
        mapper.put (root,0);
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add (root);
        HashMap<Integer, ArrayList<TreeNode>> ls = new HashMap<Integer, ArrayList<TreeNode>>();
        while (!qu.isEmpty())
        {
            TreeNode curr = qu.poll();
            if (curr.left != null)
            {
                mapper.put (curr.left, mapper.get(curr)+1);
                qu.add (curr.left);
            }
            if (curr.right != null)
            {
                mapper.put (curr.right, mapper.get(curr)+1);
                qu.add (curr.right);
            }
            if (!ls.containsKey (mapper.get(curr)))
            {
                ArrayList<TreeNode> lister= new ArrayList<TreeNode>();
                lister.add (curr);
                ls.put (mapper.get(curr), lister);
            }
            else
            {
                ArrayList<TreeNode> lister = ls.get(mapper.get(curr));
                lister.add (curr);
            }    
        }
        ArrayList<TreeNode> getter = ls.get(mapper.get(u));
        for (int i =0 ; i< getter.size();i+=1)
        {
            if (getter.get(i).val == u.val)
            {
                if (i == getter.size()-1)
                    return null;
                return getter.get(i+1);
            }
        }
        return null;
    }
}
