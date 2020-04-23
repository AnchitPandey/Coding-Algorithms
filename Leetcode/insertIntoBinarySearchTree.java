/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class insertIntoBinarySearchTree {
    
    // analogus to binary search in arrays 
    public TreeNode findNext(TreeNode curr, int key)
    {
        if( curr.val > key && curr.left != null)
            return findNext(curr.left, key);
        
        else if (curr.val < key && curr.right != null)
            return findNext (curr.right, key);
        else
            return curr;
        
    }
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
    
        
        if (root ==null)
        {
            TreeNode newNode=  new TreeNode(val);
            return newNode;
        }
    TreeNode found = findNext(root,val);
        TreeNode newNode = new TreeNode (val);
        
        // decide if new node is left child or right child of existing node
    if (found.val > val)
        found.left = newNode;
    
        else
            found.right = newNode;   
    return root;
    }
}
