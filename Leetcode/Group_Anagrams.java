class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      HashMap<HashMap<Character, Integer>, List<String>> bm = new HashMap();
      for(int i = 0 ;i< strs.length;i+=1)
      {
          HashMap<Character, Integer> temp = new HashMap();
          for (int j = 0;j < strs[i].length();j+=1)
          {
              char ch = strs[i].charAt(j);
              temp.put (ch, temp.getOrDefault(ch,0)+1);
          }
          if (bm.containsKey(temp))
          {
              List<String> ls = bm.get(temp);
              ls.add (strs[i]);
          }
          else
          {
              List<String> ls = new ArrayList<String>();
              ls.add (strs[i]);
              bm.put (temp, ls);
          }          
      }
       List<List<String>> fa =new ArrayList();
       for (Map.Entry<HashMap<Character, Integer>,List<String>> me: bm.entrySet())
       {
           fa.add (me.getValue());
       }
        return fa;
    }
}
