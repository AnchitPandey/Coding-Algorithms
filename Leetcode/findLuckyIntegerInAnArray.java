class findLuckyIntegerInAnArray {
    public int findLucky(int[] arr) {
        
    HashMap<Integer,Integer> mapper = new HashMap<Integer, Integer>();
    int lucky = -1;
    int n = arr.length;
    for (int i =0 ; i< n;i+=1)
    {
        if (!mapper.containsKey(arr[i]))
            mapper.put(arr[i],1);
        else
            mapper.put (arr[i], mapper.get(arr[i])+1);
    }
       
        ArrayList<Integer> keys = new ArrayList<Integer>(mapper.keySet());
        for (int i =0; i< keys.size();i+=1)
        {
            int key = keys.get(i);
            if (mapper.get(key) == key && key > lucky)
                lucky = key;
        }
        return lucky;
    }
}
