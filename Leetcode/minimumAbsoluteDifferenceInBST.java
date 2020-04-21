/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class minimumAbsoluteDifferenceInBST {
    
    public int getMinimumDifference(TreeNode root) {
    ArrayList<Integer> ls = new ArrayList<Integer>();
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add (root);
        ls.add (root.val);
        
        while (!qu.isEmpty())
        {
            TreeNode curr = qu.poll();
            if (curr.left != null)
            {
                ls.add (curr.left.val);
                qu.add (curr.left);
            }
            if (curr.right != null)
            {
                ls.add (curr.right.val);
                qu.add (curr.right);
            }
        }
        
        Collections.sort (ls);
        int min = Integer.MAX_VALUE;
        for (int i=1; i< ls.size();i+=1)
        {         
            if (ls.get(i) - ls.get(i-1) <min) 
                min = ls.get(i) - ls.get(i-1);
        }
        return min;
    }
}
