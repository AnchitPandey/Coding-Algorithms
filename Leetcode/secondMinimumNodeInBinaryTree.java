/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class secondMinimumNodeInBinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return -1;
        Queue<TreeNode> qu =new LinkedList<TreeNode>();
        TreeMap<Integer, Integer> mapper = new TreeMap<Integer, Integer>();
        qu.add (root);
        mapper.put (root.val,1);
        while (!qu.isEmpty())
        {
            TreeNode curr = qu.poll();

            if (curr.left != null)
            {
                mapper.put (curr.left.val,1);
                qu.add (curr.left);
            }
            if (curr.right != null)
            {
                mapper.put (curr.right.val,1);
                qu.add (curr.right);
            }
        }
        if(mapper.size() ==1)
            return -1;
        
        ArrayList<Integer> map = new ArrayList<Integer>(mapper.keySet());
        return map.get(1);
    }
}
