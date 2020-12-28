/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    
    public NodeCopy copyRandomBinaryTree(Node root) {
        if (root ==null)
            return null;
        NodeCopy r = new NodeCopy (root.val);
        HashMap<Node, NodeCopy> mapper = new HashMap<Node, NodeCopy>();
        mapper.put (root,r);
        Queue<Node> qu = new LinkedList<Node>();
        Queue<NodeCopy> dup = new LinkedList<NodeCopy>();
        qu.add (root);
        dup.add (r);
        
        while (!qu.isEmpty())
        {
            Node curr = qu.poll();
            NodeCopy temp = dup.poll();
            if (curr.left != null)
            {
                qu.add (curr.left);
                NodeCopy child = new NodeCopy (curr.left.val);
                temp.left = child;
                mapper.put (curr.left, child);
                dup.add (child);               
            }
            
            if (curr.right != null)
            {
                qu.add (curr.right);
                NodeCopy child = new NodeCopy (curr.right.val);
                temp.right = child;
                mapper.put (curr.right, child);
                dup.add (child);               
            }   
        }
        qu.add (root);
        dup.add(r);
        while (!qu.isEmpty())
        {
            Node curr = qu.poll();
            NodeCopy tt = dup.poll();
            if (curr.random ==null)
                tt.random = null;
            else
            {
                NodeCopy ran =  mapper.get(curr.random);
                tt.random = ran;
            }
            if (curr.left != null)
            {
                qu.add (curr.left);
                dup.add (tt.left);    
            }
            
            if (curr.right != null)
            {
                qu.add (curr.right);
                dup.add (tt.right);    
            }
                        
        }
        return r;
    }
}
