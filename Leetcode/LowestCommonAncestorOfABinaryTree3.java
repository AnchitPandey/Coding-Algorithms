/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    
    public Node lowestCommonAncestor(Node p, Node q) {
        
    HashMap<Node, Integer> mapper = new HashMap<Node, Integer>();
    Node t = p;
    while (t != null)
    {
        mapper.put(t,1);
        t = t.parent;
    }
    Node fa = null;
    Node b= q;
    while (b != null)
    {
        if (mapper.containsKey(b))
        {
            fa = b;
            break;
        }
        b = b.parent;
    }
        return fa;
    }
}
