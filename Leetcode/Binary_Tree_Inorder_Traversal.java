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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> ls = new ArrayList<Integer>();
        if (root == null)
            return ls;
        Stack<TreeNode> st  = new Stack<TreeNode>();
        st.push (root);
        Set<TreeNode> visited = new HashSet<TreeNode>();
         Set<TreeNode> inStack = new HashSet<TreeNode>();    
        
        while (!st.isEmpty())
        {
            TreeNode curr = st.peek();
    
            if (curr.left != null && !visited.contains(curr.left))
            {
                 st.add (curr.left);
                 continue;
            }
            if (!inStack.contains(curr))
            {
                ls.add (curr.val);
                inStack.add (curr);
            }    
            if (curr.right != null && !visited.contains (curr.right))
            {
    
                 st.add (curr.right);
                 continue;
            }
            visited.add (curr);   
            st.pop();
        }       
        return ls;
    }
}
