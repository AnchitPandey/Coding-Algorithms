class GFG
{
    // return an array containing the zig zag level order traversal of the given tree
	ArrayList<Integer> zigZagTraversal(Node root)
	{
        LinkedHashMap<Integer, ArrayList<Node>> mapper = new LinkedHashMap<Integer,ArrayList<Node>>();
        HashMap<Node, Integer> depth = new HashMap<Node, Integer>();
        depth.put (root,0);
        ArrayList<Node> initial = new  ArrayList<Node>();
        initial.add (root);
        mapper.put (0, initial);
        Queue<Node> qu = new LinkedList<Node>();
        qu.add (root);
        while (!qu.isEmpty())
        {
            Node par = qu.poll();
        //    System.out.println("parent node is "+ par.data);
            int height = depth.get (par);
            if (par.left != null)
            {
                qu.add (par.left);
             //   System.out.println("child node is "+par.left.data);
          //      height = depth.get(par);
                depth.put (par.left, height+1);
                if (!mapper.containsKey(height+1))
                {
                    ArrayList<Node> ls=  new ArrayList<Node>();
                    ls.add(par.left);
                    mapper.put (height+1, ls);
                }
                else
                {
                    ArrayList<Node> ls = mapper.get(height+1);
                    ls.add (par.left);
                }
            }
            
            if (par.right != null)
            {
                         qu.add (par.right);   
            //    System.out.println("child node is "+par.right.data);
                depth.put (par.right, height+1);
                if (!mapper.containsKey(height+1))
                {
                    ArrayList<Node> ls=  new ArrayList<Node>();
                    ls.add(par.right);
                    mapper.put (height+1, ls);
                }
                else
                {
                    ArrayList<Node> ls = mapper.get(height+1);
                    ls.add (par.right);
                }
            }
        }
        
        String result = "";
        ArrayList<Integer> fa =new ArrayList<Integer>();
        ArrayList<ArrayList<Node>> finalval = new ArrayList<ArrayList<Node>>(mapper.values());
        for (int i =0; i< finalval.size();i+=1)
        {
            if (i %2 ==0)
            {
                ArrayList<Node> vals = finalval.get(i);
                for (int j =0; j< vals.size();j+=1)
                {
                    fa.add (vals.get(j).data);
                    //result += vals.get(j).data +" ";
                }
            }
            else
            {
                ArrayList<Node> vals = finalval.get(i);
                for (int j =vals.size()-1; j>=0;j-=1)
                {
                    fa.add (vals.get(j).data);
                   // result += vals.get(j).data +" ";
                }                
            }
        }
     //  System.out.println(mapper);
    return fa;    
	}
}
