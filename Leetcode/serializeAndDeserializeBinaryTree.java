/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class serializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add (root);
        sb.append (root.val);
        sb.append (',');
        while (!qu.isEmpty())
        {
            TreeNode curr = qu.poll();
            if (curr.left == null)
                sb.append ("null,");
            else
            {
                sb.append (curr.left.val);
                sb.append(',');
                qu.add (curr.left);
            }
            
            if (curr.right == null)
                sb.append ("null,");
            else
            {
                sb.append (curr.right.val);
                sb.append(',');
                qu.add (curr.right);
            }   
        }
        if (sb.length() !=0)
        sb.deleteCharAt(sb.length()-1);
      //  System.out.println("encoded string is "+ sb.toString());
        return sb.toString();
    }  
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       
        if (data.length()==0)
            return null;
        
        String[] splitter = data.split(",");
        TreeNode root = new TreeNode (Integer.parseInt(splitter[0]));
        //TreeNode prev = root;
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        Queue<String> values = new LinkedList<String>();
        for (int i=1 ;i < splitter.length;i+=1)
            values.add (splitter[i]); 
        qu.add (root);
        while (!values.isEmpty())
        {
            String leftgetter = values.poll();
            TreeNode curr = qu.poll();
            if (leftgetter.equals ("null"))
                curr.left = null;
            else
            {
                int lvalue = Integer.parseInt(leftgetter);
                TreeNode currLeft = new TreeNode (lvalue);
                curr.left = currLeft;
                qu.add (currLeft);
            }
            
            if (values.isEmpty())
                break;
            
            String rightgetter = values.poll();
           
            if (rightgetter.equals ("null"))
                curr.right = null;
            else
            {
                int rvalue = Integer.parseInt(rightgetter);
                TreeNode currRight = new TreeNode (rvalue);
                curr.right = currRight;
                qu.add (currRight);
            }          
        }           
        return root;  
    }  
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
