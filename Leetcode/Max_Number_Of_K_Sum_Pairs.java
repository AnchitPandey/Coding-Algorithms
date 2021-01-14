class Solution {
    public int maxOperations(int[] nums, int k) {
        
        HashMap<Integer, Integer> mapper = new HashMap();
        for (int i =0 ; i< nums.length;i+=1)
            mapper.put (nums[i], mapper.getOrDefault(nums[i],0)+1);
        int ans=0;
        
        for (Map.Entry<Integer,Integer> me: mapper.entrySet()) {
       // for (int i =0 ; i< nums.length;i+=1)
       // {
            int key = me.getKey();
            int val = me.getValue();
            if (val ==0) 
                continue;
            
            if (k - key == key) {
                //System.out.println(mapper.get(nums[i]));
                ans += val/2;
            }
            
            else if (mapper.containsKey (k - key)) {
               // System.out.println("in here");
                if (mapper.get(k - key) < val)
                {
                    ans += mapper.get(k -key);
                    mapper.put ( k-key,0);
                }
                else
                {
                    ans += val;
                    mapper.put (key,0);
                }
            }
        }
        return ans;
    }
}
