class custom implements Comparator <Integer> {
    public int compare (Integer o1, Integer o2)
    {
        return o2 -o1;        
    }    
}
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new custom());
        for (int i =0; i< stones.length;i+=1)
        {
            pq.add (stones[i]);
        }
        while (!pq.isEmpty())
        {
            int num1 = pq.poll();
            if (pq.size ()  ==0)
                return num1;
            int num2 = pq.poll();
            if (num1 != num2)
                pq.add (num1 - num2);
        }
        return 0;
    }
}
