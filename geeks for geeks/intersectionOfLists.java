class Sol
{
    public static Node findIntersection(Node head1, Node head2)
    {
        HashMap<Integer, Integer> mapper = new HashMap<Integer, Integer>();
        ArrayList<Node> ls = new ArrayList<Node>();
        while (head2 != null)
        {
            mapper.put (head2.data,1);
            head2 = head2.next;
        }
        while (head1 != null)
        {
            if (mapper.containsKey(head1.data))
            {
                Node d = new Node (head1.data);
                ls.add (d);
    //            mapper.put (head1.data,1);
            }
            head1 = head1.next;
        }
        for (int i =1; i< ls.size();i+=1)
            {
                    ls.get(i-1).next = ls.get(i);
            }
            ls.get(ls.size()-1).next = null;
            
    return ls.get(0);        
    }
}
