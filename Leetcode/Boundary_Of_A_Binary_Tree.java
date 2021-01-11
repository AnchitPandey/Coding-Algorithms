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
    List<Integer> ans;
    
    public void findLeftBoundary (TreeNode curr) {
        if (curr.left == null && curr.right == null)
            return;
        ans.add (curr.val);
        if (curr.left != null)
            findLeftBoundary(curr.left);
        else {
            findLeftBoundary (curr.right);
        }        
    }
    
    public void findLeaf (TreeNode curr) {
        
        if (curr.left == null && curr.right == null)
        {
            ans.add (curr.val);
            //System.out.println("in here");
            return;
        }
        
        if (curr.left != null)
            findLeaf (curr.left);
        if (curr.right != null) 
            findLeaf (curr.right);
        return;     
    }

    public void findRightBoundary (TreeNode curr) {
        if (curr.left == null && curr.right == null) {
            return;
        }
        if (curr.right != null)
            findRightBoundary(curr.right);
        else 
            findRightBoundary(curr.left);
        ans.add (curr.val);
    }
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ans = new ArrayList();
        if (root == null)
            return ans;
        boolean rightb = false;
        //ans.add (root.val);
        if (root.left != null)
        {
            findLeftBoundary(root);
       //     leftb = true;
        }
        else
            ans.add(root.val);
       
        if (root.left != null || root.right != null)
        findLeaf(root);
        if (root.right != null)
        {
            findRightBoundary(root);       
            rightb =true;
        }
        //System.out.println(ans);
        if (rightb)
        ans.remove (ans.size()-1);
        return ans;
    }
}
