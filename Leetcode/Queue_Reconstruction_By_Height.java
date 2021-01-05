class custom implements Comparator <int[]> 
{
    public int compare (int[] o1, int[] o2)
    {
        if (o1[0] > o2[0])
        return -1;
        else if (o1[0] < o2[0])
        return 1;
        else
            return o1[1] - o2[1];
    }
}
class Solution {
    public int[][] reconstructQueue(int[][] people) {

      PriorityQueue<int[]> pq = new PriorityQueue(new custom()); 
        for (int i =0 ; i< people.length;i+=1)
        {
            pq.add (people[i]);
        }
        List<int[]> ls = new ArrayList();
        while (!pq.isEmpty())
        {
            int[] tt = pq.poll();
            ls.add (tt[1],tt);
        }
        int[][] fa= new int[ls.size()][2];
        for (int i= 0; i< ls.size();i+=1)
        {
            int[] gt = ls.get(i);
            fa[i] = new int[] {gt[0], gt[1]};
        }
        return fa;
    }
}
