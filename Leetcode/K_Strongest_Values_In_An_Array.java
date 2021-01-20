class custom implements Comparator<Model> {
    
    public int compare (Model m1, Model m2)
    {
        if (m1.mod < m2.mod)
            return -1;
        else if (m1.mod > m2.mod)
            return 1;
        else
        {
            return m1.number - m2.number;
        }
    }   
}
class Model {   
    int number, mod;
    public Model (int number, int mod)
    {
        this.number = number;
        this.mod = mod;
    }
}
class Solution {
    public int[] getStrongest(int[] arr, int k) {

        Arrays.sort (arr);
        int median = (arr.length-1)/2;
        PriorityQueue<Model> pq = new PriorityQueue(new custom());
        
        for (int i =0; i< arr.length;i++)
        {
            int diff = Math.abs (arr[i] - arr[median]);
            Model m = new Model (arr[i], diff);
            if (pq.size() ==k)
            {
                Model tt = pq.peek();
                if (tt.mod < diff) {
                    pq.poll();
                    pq.add (m);
                }
                else if (tt.mod == diff)
                {
                    if (tt.number < arr[i])
                    {
                        pq.poll();
                        pq.add (m);
                    }
                }
            }
            else
                pq.add (m);
        }
        int[] ans = new int[k];
        int index =0;
        while (!pq.isEmpty())
        {
            Model tt = pq.poll();
            ans[index] = tt.number;
            index+=1;
        }
        return ans;
    }
}
