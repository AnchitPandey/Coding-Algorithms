/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
   
        HashMap<TreeNode, TreeNode> mapper = new HashMap<TreeNode, TreeNode>();
        mapper.put (root,null);
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add (root);
        while (!qu.isEmpty())
        {
            TreeNode curr = qu.poll();
            if(curr.left != null)
            {
                mapper.put(curr.left, curr);
                qu.add (curr.left);
            }
            
            if (curr.right != null)
            {
                mapper.put (curr.right, curr);
                qu.add (curr.right);
            }        
        }
        
    List<Integer> ans = new ArrayList<Integer>();
    HashMap<TreeNode, Integer> mapped =new HashMap<TreeNode, Integer>();
    qu.add (target);
    mapped.put (target,0);
    HashMap<TreeNode, Integer> visited = new HashMap<TreeNode, Integer>();
    visited.put (target,1);
    while (!qu.isEmpty())
    {
        TreeNode curr = qu.poll();
        if (mapped.get(curr) == K)
            ans.add (curr.val);
        if (mapped.get (curr) > K)
            break;
        if (curr.left != null && !visited.containsKey (curr.left))
        {
            mapped.put (curr.left, mapped.get(curr)+1);
            qu.add (curr.left);
      //      if (mapped.get(curr.left) == K)
        //        ans.add (curr.left.val);
            visited.put (curr.left,1);
        }
        
        if (curr.right != null && !visited.containsKey (curr.right))
        {
            mapped.put (curr.right, mapped.get(curr)+1);
            qu.add (curr.right);
          //  if (mapped.get(curr.right) == K)
            //    ans.add (curr.right.val);
                        visited.put (curr.right,1);

        }
        
        if (mapper.get(curr) != null &&  !visited.containsKey(mapper.get(curr)))
        {
            mapped.put (mapper.get(curr), mapped.get(curr)+1);
            qu.add (mapper.get(curr));
//            if (mapped.get(mapper.get(curr)) ==K)
  //              ans.add (mapper.get(curr).val);
            visited.put (mapper.get(curr),1);          
        }        
    }
    return ans;
    }
}
