class Solution {
    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        int targetVal = target.val;
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add (cloned);
        TreeNode fa = null;
        while (!qu.isEmpty())
        {
            TreeNode curr = qu.poll();
            if (curr.val == targetVal)
            {
                fa = curr;
                break;
            }
            if (curr.left != null)
                qu.add (curr.left);
            
            if (curr.right != null)
                qu.add (curr.right);            
        }
        
        return fa;
    }
}
