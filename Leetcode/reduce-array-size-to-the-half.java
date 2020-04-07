class Solution {
    public int minSetSize(int[] arr) {
     
        HashMap<Integer, Integer> mapper = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length;i+=1)
        {
            if (!mapper.containsKey (arr[i]))
                mapper.put (arr[i],1);
            else
                mapper.put (arr[i], mapper.get(arr[i])+1);
        }
      //  System.out.println(mapper);
        int n = arr.length;
        ArrayList<Integer> vals = new ArrayList<Integer>(mapper.values());
        Collections.sort (vals, Collections.reverseOrder());
       // System.out.println(n);
        int sum =0;
        int fa = -1;
        for (int i =0;  i< vals.size();i+=1)
        {
         sum+= vals.get(i);  
            if (sum >= n/2)
            {
                fa = i;
                break;
            }
            } 
        return (fa+1);
    }
}
