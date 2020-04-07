class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
        visited.put (0,1);
        Queue<Integer> qu = new LinkedList<Integer>();
        qu.add (0);
        while (!qu.isEmpty())
        {
            int parentNode = qu.poll();
            List<Integer> children = rooms.get(parentNode);
            for (int j = 0 ;j< children.size();j+=1)
            {
                if (!visited.containsKey(children.get(j)))
                {
                    visited.put (children.get(j),1);
                    qu.add (children.get(j));
                }
            }
        }
        if (visited.size() == rooms.size())
            return true;
        else
            return false;
    }
}
