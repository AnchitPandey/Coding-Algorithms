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
    public TreeNode recoverFromPreorder(String S) {
        StringBuilder sb = new StringBuilder ();
        Stack<TreeNode> st = new Stack<TreeNode>();  
        TreeNode root = new TreeNode ();
        int currDepth = 0;
            for (int i =0 ; i < S.length();i+=1)
            {
                char ch = S.charAt(i);
                if (ch =='-')
                    currDepth+=1;
                
                else if (ch >='0' && ch <='9' && i+1 < S.length() && S.charAt(i+1) >='0' && S.charAt(i+1) <= '9')
                    sb.append (ch);
            
                else
                {
                    sb.append(ch);
                    int num = Integer.parseInt (sb.toString());
                    sb = new StringBuilder();
                    if (currDepth ==0 )
                    {
                        root.val = num;
                        
                        st.push (root);
                        continue;
                    }
                   
                    TreeNode curr = new TreeNode (num);
                    //sb = new StringBuilder();
                    //System.out.println("Current index is "+ i); 
                    //System.out.println("Current stack size is "+st.size());
                    //System.out.println("Current depth is "+ currDepth );
                    while (st.size() != currDepth)
                        st.pop();
                    
                    TreeNode top = st.peek();
                    if (top.left == null)
                    {
                        top.left = curr;
                        st.push (curr);
                    }
                   else if (top.right == null)
                    {
                        top.right = curr;
                        st.push (curr);
                    }
                     currDepth = 0;
                }                      
            }
            return root;
    }
}
