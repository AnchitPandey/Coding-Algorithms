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
    
    
    public boolean checkPalindrome (HashMap<Integer, Integer> mapper)
    {
        int flag =0;
        ArrayList<Integer> keys = new ArrayList<Integer>(mapper.keySet());
        for (int i =0; i< keys.size();i+=1){
            
            int val = mapper.get(keys.get(i));
            if (val % 2 !=0 && flag  ==1)
                return false;
            else if (val %2 !=0 && flag ==0)
                flag+=1;            
        }
        return true;
    }
    
    public int pseudoPalindromicPaths (TreeNode root) {
        
        if (root ==null)
            return 0;
        
        HashMap<TreeNode, HashMap<Integer,Integer>> bigMap = new HashMap<TreeNode, HashMap<Integer, Integer>>();
        
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add (root);
        HashMap<Integer, Integer> starter = new HashMap<Integer, Integer>();
        starter.put (root.val,1);
        bigMap.put (root, starter);
        
        // storing leaf nodes
        HashMap<TreeNode, Integer> end = new HashMap<TreeNode, Integer>();
        
        
        while (!qu.isEmpty())
        {
            TreeNode curr = qu.poll();
            if(curr.left == null && curr.right == null)
                end.put (curr,1);           
            
            if (curr.left != null)
            { 
                HashMap<Integer, Integer> getter = bigMap.get(curr);
                HashMap<Integer,Integer> cloned = (HashMap<Integer, Integer>)getter.clone();
                cloned.put (curr.left.val, cloned.getOrDefault(curr.left.val,0)+1);
                
                bigMap.put (curr.left, cloned);
                qu.add (curr.left);
            }
            if (curr.right != null)
            { 
                HashMap<Integer, Integer> getter = bigMap.get(curr);
                HashMap<Integer,Integer> cloned = (HashMap<Integer, Integer>)getter.clone();
                cloned.put (curr.right.val, cloned.getOrDefault(curr.right.val,0)+1);  
                bigMap.put (curr.right, cloned);
                 qu.add (curr.right);
            }
        }
        
        // final answer       
        int ans = 0;
        // getting leaf nodes
        ArrayList<TreeNode> ls = new ArrayList<TreeNode>(end.keySet());
        
        for (int i =0; i< ls.size();i+=1)
        {
            TreeNode curr = ls.get(i);
            
            // frequencies hashmap
            HashMap<Integer, Integer> getter = bigMap.get (curr);
            
            boolean b = checkPalindrome (getter);
            if (b)
                ans +=1;           
        }
        return ans;
    }
}
