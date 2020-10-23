/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node cloneTree(Node root) {
 
       if (root ==null)
           return null;
        
 //    HashMap<Node, Node> mapper = new HashMap<Node, Node>();
       Node r = new Node (root.val);
       Queue<Node> qu1 =  new LinkedList<Node>();
       qu1.add (root);
     
       Queue<Node> qu2 =  new LinkedList<Node>();
       qu2.add (r);
        
        while (!qu1.isEmpty())
        {
            Node curr = qu1.poll();
            Node dup  = qu2.poll();
            List<Node> ch = curr.children;
            if (ch != null)
            {
                dup.children = new ArrayList<Node>();
                for (int j =0; j< ch.size();j+=1)
                {
                    Node child = ch.get(j);
                    Node temp = new Node (child.val);
                    qu1.add (child);
                    dup.children.add (temp);
                    qu2.add (temp);                    
                }                
            }   
        }
        return r;
    }
}
