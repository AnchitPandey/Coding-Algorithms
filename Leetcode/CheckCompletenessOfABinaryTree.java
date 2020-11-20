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
  
      
    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return true;
        
        HashMap<TreeNode, Integer> mapper = new HashMap<TreeNode, Integer>();
        mapper.put (root,0);
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add (root);
        int max = 1;
        
        while (!qu.isEmpty())
        {
            TreeNode curr = qu.poll();
            if (curr.left != null)
            {
                int h = mapper.get(curr)+1;
                max = Integer.max (max, h);
                mapper.put (curr.left, h);
                qu.add (curr.left);
            }
            
            if (curr.right != null)
            {
                int h = mapper.get(curr)+1;
                max = Integer.max (max, h);
                mapper.put (curr.right, h);
                qu.add (curr.right);
            }          
        }
        
        // check max -2 nodes
        qu.add (root);
        while (!qu.isEmpty())
        {
            TreeNode curr = qu.poll();
            int h = mapper.get(curr);
            if (h == max-1)
                break;
            if (curr.left == null || curr.right == null)
            {
            //    System.out.println ("1");
                return false;
            }
       //     if (curr.left != null)
                qu.add (curr.left);
        //    if (curr.right != null)
                qu.add (curr.right);
            
        }
        qu = new LinkedList<TreeNode>();
        

        // adding max-1 nodes
        ArrayList<TreeNode> ls = new ArrayList<TreeNode>();
        qu.add (root);
        
        while (!qu.isEmpty())
        {
            TreeNode curr = qu.poll();
            
            int h = mapper.get(curr);
            if (h == max-1)
            {
              //  System.out.println ("node value is "+curr.val);
                ls.add (curr);
            }
            if (curr.left != null)
                qu.add (curr.left);
            if (curr.right != null)
                qu.add (curr.right);      
        }
        
        int setFlag = 0;
        //System.out.println("size is "+ls.size());
        //System.out.println("max is "+max);
          //  System.out.println("mapper is "+mapper);
        for (int i=0;  i< ls.size();i+=1)
        {
            TreeNode curr = ls.get(i);
            
            if (setFlag ==0)
            {
                if (curr.right != null && curr.left == null)
                {
            //        System.out.println ("2");
                    return false;
                }
                else if (curr.right == null || curr.left == null)
                    setFlag =1;
            }
            else
            {
                if (curr.left != null || curr.right != null)
                {
             //       System.out.println ("3");
                    return false;
                
                }
                
                }          
        }
        return true;
    }
}
