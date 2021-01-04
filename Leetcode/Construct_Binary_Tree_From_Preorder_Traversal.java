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
    
    public TreeNode bstFromPreorder(int[] preorder) {
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode root = new TreeNode (preorder[0]);
        st.push (root);
        TreeNode prev = null;
        for (int  i=1 ; i< preorder.length;i+=1)
        {
            if (preorder[i] < st.peek().val)
            {
                TreeNode curr = new TreeNode (preorder[i]);
                st.peek().left = curr;
                st.push (curr);
            //    prev = curr;
            }
            else
            {
            while (!st.isEmpty() && preorder[i] > st.peek().val){
             prev =  st.pop();
            }
                TreeNode curr = new TreeNode (preorder[i]);
                prev.right = curr;
                st.push (curr);
            }
        }
        return root;
    }
}
