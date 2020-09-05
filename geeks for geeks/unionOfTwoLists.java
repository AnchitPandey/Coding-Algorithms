class Sol
{
	public static Node findUnion(Node head1,Node head2)
	{
     HashMap<Integer, Integer> mapper = new HashMap<Integer, Integer>();
     while (head1 != null)
     {
         mapper.put (head1.data, 1);
         head1 = head1.next;
     }
     while (head2 != null)
     {
         mapper.put (head2.data, 1);
         head2 = head2.next;
     }
        ArrayList<Integer> ls  = new ArrayList<Integer>(mapper.keySet());
        Collections.sort (ls);
        Node head = new Node(ls.get(0));
        Node tr = head;
        for (int i =1; i< ls.size();i+=1)
        {   
            Node ne = new Node (ls.get(i));
            tr.next = ne;
            tr = tr.next;
        }
        tr.next = null;
        return head;
	}
}
