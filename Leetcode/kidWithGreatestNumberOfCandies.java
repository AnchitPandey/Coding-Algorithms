class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
     
        int max = -1;
        for (int i =0 ;i < candies.length;i+=1)
            max = Integer.max (candies[i], max);
        
        List<Boolean> ans = new ArrayList<Boolean>();
        for (int i =0; i<candies.length;i+=1)
        {
            if (candies[i] + extraCandies >= max)
                ans.add (true);
            else
                ans.add (false);
            
        }
        return ans;
    }
}
