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
class FindElements {
      
    Set<Integer> visited;
    public FindElements(TreeNode root) {  
        visited = new HashSet<Integer>();
        visited.add (0);
        root.val =0;
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add (root);
        while (!qu.isEmpty())
        {
            TreeNode curr =  qu.poll();
            if (curr.left != null)
            {
                curr.left.val = 2 * curr.val +1;
                visited.add (curr.left.val);
                qu.add (curr.left);
            }            
             if (curr.right != null)
            {
                curr.right.val = 2 * curr.val + 2;
                visited.add (curr.right.val);
                qu.add (curr.right);
            }                        
        }
    }
    
    public boolean find(int target) {
        return visited.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
