class custom implements Comparator<int[]> {
    
    public int compare (int[] o1, int[] o2){
        
        if (o1[1] < o2[1])
            return -1;
        else if (o1[1] > o2[1])
            return 1;
        return o1[0] - o2[0];
    }    
}
class Solution {
    HashMap<Integer, Integer> mapper;
    
    public void dfs (int number, HashMap<Integer,Integer> mapper){
        
        if (mapper.containsKey (number))
            return;
        int child =0;
        if (number % 2 ==0)
            child = number/2;
        else
            child = number *3 +1;
        if (!mapper.containsKey(child))
            dfs (child, mapper); 
        int val = mapper.get(child) +1;
        mapper.put (number, val);
        
    }
    
    public Solution ()  {
        mapper = new HashMap();
        mapper.put (0,0);
        mapper.put (1,1);
        for (int i= 1000; i >=1; i--)
            dfs (i, mapper);
    }
    public int getKth(int lo, int hi, int k) {
        
        //System.out.println(mapper);
        
        ArrayList<int[]> ls = new ArrayList();
        for (int i = lo; i<=hi;i+=1)
        {
            int[] tt = new int[] {i, mapper.get(i)};
            ls.add (tt);
        }
        Collections.sort(ls, new custom());
        k-=1;
        int[] tt  = ls.get(k);
        return tt[0];
    }
}
