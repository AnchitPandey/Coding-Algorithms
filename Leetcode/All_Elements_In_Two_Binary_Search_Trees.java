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
    
    
    
    
    public void dfs (TreeNode curr, List<Integer> ls)
    {
        if (curr.left != null)
            dfs (curr.left, ls);
        ls.add (curr.val);
        if (curr.right != null)
            dfs (curr.right, ls);
    }
    
    public List<Integer> merge (List<Integer> ls1, List<Integer> ls2)
    {
        List<Integer> ans =new ArrayList();
        int index1 =0, index2 =0 ;
        while (index1 < ls1.size() && index2< ls2.size())
        {
            if (ls1.get(index1) <= ls2.get(index2))
            {
                ans.add (ls1.get(index1));
                index1+=1;
            }
            else
            {
                ans.add (ls2.get(index2));
                index2+=1;                    
            }
        }
        while(index1 < ls1.size())
        {
            ans.add (ls1.get(index1));
            index1+=1;
        }
         while(index2 < ls2.size())
        {
            ans.add (ls2.get(index2));
            index2+=1;
        }
        return ans;       
    }
     
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ls1, ls2;
        ls1 = new ArrayList();
        ls2  = new ArrayList();
        if(root1 != null)
            dfs (root1, ls1);
        if (root2 != null)
            dfs (root2, ls2);
        List<Integer> ans = merge (ls1, ls2);
        return ans;
    }
}
