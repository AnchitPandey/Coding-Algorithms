/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean checkEquivalence(Node root1, Node root2) {
        
        HashMap<Character, Integer> mapper1 = new HashMap<Character, Integer>();
        Queue<Node> qu = new LinkedList<Node>();
HashMap<Character, Integer> mapper2 = new HashMap<Character, Integer>();           
        qu.add (root1);
        while (!qu.isEmpty())
        {
            Node ch = qu.poll();
            if (ch.val!= '+')
                mapper1.put (ch.val, mapper1.getOrDefault (ch.val,0)+1);
            if (ch.left != null)
                qu.add (ch.left);
            if (ch.right != null)
                qu.add(ch.right);           
        }
       
        qu.add (root2);
        while (!qu.isEmpty())
        {
            Node ch = qu.poll();
            if (ch.val!= '+')
                mapper2.put (ch.val, mapper2.getOrDefault (ch.val,0)+1);
            if (ch.left != null)
                qu.add (ch.left);
            if (ch.right != null)
                qu.add(ch.right);           
        }
        
        ArrayList<Character> ls1 = new ArrayList<Character>(mapper1.keySet());
        
          ArrayList<Character> ls2 = new ArrayList<Character>(mapper2.keySet());
        
        if(ls1.size() != ls2.size())
            return false;
        
        for (int i =0  ;i< ls1.size();i+=1)
        {
            if (!mapper2.containsKey (ls1.get(i)) || mapper2.get(ls1.get(i)) != mapper1.get(ls1.get(i)))
                return false;     
        }
        return true;
    }
}
