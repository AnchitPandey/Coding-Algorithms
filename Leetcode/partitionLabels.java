class Solution {
    
    public List<Integer> partitionLabels(String S) {
      
        HashMap<Character, Integer> mapper = new HashMap<Character,Integer>();
        for  (int i =0;i< S.length();i+=1)
        {
            mapper.put (S.charAt(i), i);
        }
        int counter= 0;
        List<Integer> fa = new ArrayList<Integer>();
        int end = mapper.get(S.charAt(0));
        for (int i =1 ; i< S.length();i+=1)
        {
            if (i > end)
            {
                fa.add (end);
                end = mapper.get(S.charAt(i));
            }
            end = Integer.max (end, mapper.get(S.charAt(i)));
        }
        fa.add (end);
    
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(fa.get(0)+1);
        for (int i = 1; i< fa.size();i++)
        {
            ans.add(fa.get(i) - fa.get(i-1));
        }
        return ans;
    }
}
