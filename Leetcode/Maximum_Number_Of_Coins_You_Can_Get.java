class Solution {
    public int maxCoins(int[] piles) {
        ArrayList<Integer> ls = new ArrayList();
        for (int i= 0 ; i< piles.length;i+=1)
        {
            ls.add (piles[i]);   
        } 
        Collections.sort (ls, Collections.reverseOrder());
        int me =1;
        int bob = ls.size()-1;
        int ans = 0;
        while (me < bob)
        {
            ans += ls.get(me);
            me+=2;
            bob-=1;
        }
        return ans;
    }
}
