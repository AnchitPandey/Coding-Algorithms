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
class recoverATreeFromPreOrderTraversal {
    public TreeNode recoverFromPreorder(String S) {
        
        // Initialization step
        HashMap<Integer, TreeNode> mapper = new HashMap<Integer,TreeNode>();
        StringBuilder sb = new StringBuilder();
        TreeNode root = null;
        int index =-1;
        for (int i =0; i< S.length();i++)
        {
            if(S.charAt(i) =='-')
            {
                root = new TreeNode (Integer.parseInt(sb.toString()));
                index = i;
                break;
            }
            sb.append (S.charAt(i));
        }
        if (root == null)
            root = new TreeNode (Integer.parseInt(sb.toString()));        
        mapper.put (0,root);
        if (index ==-1)
            return root;
        
        // Main code
        sb = new StringBuilder();
        int counter =0;
        int flag = 0;
        for (int i = index;i< S.length();i+=1)
        {
            if (S.charAt(i) =='-' && flag ==0)
                counter+=1;
            else if (S.charAt(i) != '-')
            {
              flag = 1;
              sb.append (S.charAt(i));
            }
            else if (flag ==1)
            {
                flag = 0;
                
               // System.out.println(Integer.parseInt(sb.toString()));
                TreeNode child = new TreeNode(Integer.parseInt(sb.toString()));
                TreeNode parent = mapper.get(counter-1);
               // System.out.println(parent.val);
                if (parent.left == null)
                    parent.left = child;
                else
                {
                    parent.right = child;
                    mapper.remove (counter-1);
                }
                mapper.put (counter, child);
                counter =1;
                sb = new StringBuilder();
            }
        }
        
        
        // for the last node
            TreeNode child = new TreeNode(Integer.parseInt(sb.toString()));
                TreeNode parent = mapper.get(counter-1);
               // System.out.println(parent.val);
                if (parent.left == null)
                    parent.left = child;
                else
                    parent.right = child;
        
        return root;    
    }
}
