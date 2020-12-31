class Solution {
    public int[] processQueries(int[] queries, int m) {
        
        int[] ans = new int[queries.length];
        ArrayList<Integer> ls = new ArrayList();
        for (int  i= 1; i<=m; i+=1)
            ls.add (i);
        int counter = 0;
        for (int i =0 ; i< queries.length;i+=1)
        {
            int index = ls.indexOf(queries[i]);
            ans[counter++] = index;
            int tt = ls.remove(index);
            ls.add (0,tt);
        }
        return ans;
    }
}
