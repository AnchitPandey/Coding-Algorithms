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
    int max = 0;
    HashMap<Integer, Integer> mapper;
    public int dfs (TreeNode curr)
    {
        int leftSum =0, rightSum =0;
        if (curr.left != null)
           leftSum = dfs (curr.left);
        if (curr.right != null)
            rightSum = dfs (curr.right);
        int total = curr.val + leftSum + rightSum;
        mapper.put (total, mapper.getOrDefault(total,0)+1);
        max = Integer.max (mapper.get(total), max);
        return total;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        if  (root == null)
        {
            int[] fa= new int[0];
            return fa;
        }
        max=0;
        mapper = new HashMap<Integer, Integer>();
        dfs (root);
        //System.out.println(mapper);
        int counter =0;
        for (Map.Entry<Integer, Integer> me: mapper.entrySet())
            if (me.getValue() == max)
                counter+=1;      
        int[] tt = new int[counter];
        counter =0;
        for (Map.Entry<Integer, Integer> me: mapper.entrySet())
        {
            if (me.getValue() == max) 
            {
                tt[counter] = me.getKey();
                counter+=1;
            }        
        }       
        return tt;
    }
}
