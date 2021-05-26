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
    
    public int findDistance(TreeNode root, int p, int q) {
        
        HashMap<TreeNode, TreeNode> mapper = new HashMap();
        Queue<TreeNode> qu = new LinkedList();
        TreeNode pNode = null , qNode = null;
        qu.add(root);
        while (!qu.isEmpty())
        {
            TreeNode curr = qu.poll();
            if (curr.left != null)
            {
                mapper.put(curr.left,curr);      
                qu.add (curr.left);    
            }
            if (curr.right != null)
            {
                mapper.put(curr.right,curr);               
                qu.add (curr.right);   
            }       
            if (curr.val == p)
                pNode = curr;
            if  (curr.val == q)
                qNode = curr;
        }
        HashMap<TreeNode, Integer> pMap = new HashMap();
        HashMap<TreeNode, Integer> qMap = new HashMap();
        pMap.put (pNode,0);
        qMap.put (qNode,0);
        
        // for p
        qu.add (pNode);
        while (!qu.isEmpty())
        {
            TreeNode curr = qu.poll();
            if (!mapper.containsKey(curr))
                break;
            pMap.put (mapper.get(curr) , pMap.get(curr)+1);
            qu.add (mapper.get(curr));
        }       
        // for q
        qu.add (qNode);
        while (!qu.isEmpty())
        {
            TreeNode curr = qu.poll();
            if (pMap.containsKey(curr))
                return pMap.get(curr) + qMap.get(curr); 
            qMap.put (mapper.get(curr) , qMap.get(curr)+1);
            qu.add (mapper.get(curr));
        }
        return -1;
    }
}
