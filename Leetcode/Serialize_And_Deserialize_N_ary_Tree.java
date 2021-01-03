/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    // Encodes a tree to a single string.
    
    StringBuilder sb;
    public void dfs (Node curr) {
        if (curr == null)
            return;
        sb.append (curr.val);
        sb.append ('|');
        sb.append ('(');
        for (int i =0; i<curr.children.size();i+=1){
            Node child = curr.children.get(i);
            dfs (child);
        }
        sb.append (')');
        if (curr.children.size() ==0)
        {
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }
    public String serialize(Node root) {
        
    sb = new StringBuilder();
    dfs (root);
        return sb.toString();
        
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.length() ==0)
            return null;
        //System.out.println(data);
        int currDepth =0;
        Stack<Node> st = new Stack();
        Node starting=  new Node ();
        StringBuilder sbr = new StringBuilder();
        for (int i =0; i< data.length();i+=1)
        {
            //System.out.println("current index is "+i);
            char ch = data.charAt(i);
            if (ch >='0' && ch <='9')
                sbr.append (ch);
            else if (ch == '|')
            {
                int num = Integer.parseInt (sbr.toString());
                sbr = new StringBuilder();
                if (st.isEmpty())
                {
                    starting.val = num;
                    starting.children = new ArrayList();
                    st.push (starting);
                    continue;
                }
               // System.out.println("stack size is "+ st.size());
               // System.out.println("current depth is "+ currDepth);
                while (st.size () != currDepth)
                    st.pop();
                Node child = new Node (num);
                child.children = new ArrayList();
                st.peek().children.add (child);
                //sbr = new StringBuilder();     
                st.push (child);
            }
            else if (ch =='(')
                currDepth++;
            else if (ch == ')')
                currDepth-=1;
        }
        return starting;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
