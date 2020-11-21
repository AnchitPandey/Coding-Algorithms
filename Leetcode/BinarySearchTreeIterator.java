/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
 
    Stack<TreeNode> stack;
    
    public void dfs (TreeNode curr, Stack<TreeNode> stack)
    {
        if (curr == null)
            return;
        stack.push (curr);
        if (curr.left != null)
            dfs (curr.left, stack);
        return;
    }
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        dfs (root, stack);    
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode curr = stack.pop();
        dfs (curr.right, stack);
        return curr.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
