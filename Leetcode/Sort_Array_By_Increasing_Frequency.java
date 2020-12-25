class custom implements Comparator<int[]>
{
    public int compare (int[] o1, int[] o2)
    {
        if (o1[1] != o2[1])
            return o1[1] - o2[1];
        return o2[0] - o1[0];
    }

}
class Solution {
    public int[] frequencySort(int[] nums) {
        
        HashMap<Integer,Integer> mapper=  new HashMap<Integer, Integer>();
        for (int i =0  ;i< nums.length;i+=1)
            mapper.put (nums[i], mapper.getOrDefault(nums[i],0)+1);
        ArrayList<int[]> ls = new ArrayList<int[]>();
        int sum =0;
        for (Map.Entry<Integer,Integer> me: mapper.entrySet())
        {
            int[] tt =new int[] {me.getKey(), me.getValue()}; 
            sum+= me.getValue();
            ls.add (tt);
        }
        int curr =0;
        Collections.sort (ls, new custom() );
        int[] fa = new int[sum];
        for (int i= 0 ;i< ls.size();i+=1){
            int[] getter = ls.get(i);
            for (int  j=0 ;j< getter[1];j+=1) {
                fa[curr] = getter[0];
                curr+=1;
            }
        }
        return fa;
    }
}
