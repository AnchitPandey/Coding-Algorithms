class Solution {
    
    public boolean patternMatch (String curr, String str)
    {
        int error =1;
        for (int i =0 ; i< curr.length();i++)
        {
            char char1 = curr.charAt(i);
            char char2 = str.charAt(i);
            if (char1 != char2 )
            {
                if (error ==0)
                    return false;
                error-=1;
            }
        }
        if (error ==1)
            return false;
        return true;
    }
    
    public int inspectString (Set<String> setter, String str, HashMap<String, Integer> mapper)
    {
 
        int ans = 0;
        Iterator itr = setter.iterator();
        while (itr.hasNext())
        {
            String curr = (String)itr.next();
            if (patternMatch(curr, str))
                ans += mapper.get(curr);
        }
        return ans;
    }
    
    public int countSubstrings(String s, String t) {

        HashMap<String, Integer> mapper = new HashMap();
        HashMap<Integer, Set<String>> bm = new HashMap();
        
        // fill t hashmap
        for (int len =1;  len <= t.length(); len+=1)
        {        
            StringBuilder sb = new StringBuilder();
            // initialize
            for (int i =0 ; i< len;i+=1)
            {
                sb.append (t.charAt(i));
            }
            String str = sb.toString();
            mapper.put (str, mapper.getOrDefault(str,0)+1);
            Set<String> set = new HashSet();
            set.add (str);
            bm.put (len, set);
            for (int i = len; i < t.length();i++)
            {
                sb.deleteCharAt(0);
                sb.append (t.charAt(i));
                String st = sb.toString();
                mapper.put (st, mapper.getOrDefault(st,0)+1);
                set.add (st);
            }            
        }
        int ans = 0;
        // for s
        for (int len =1; len <= s.length();len+=1)
        {
            StringBuilder sb = new StringBuilder();
            // initialize
            for (int i =0; i < len;i +=1)
                sb.append (s.charAt(i));
            String str = sb.toString();
            Set<String> getter = bm.get(len);
            ans += inspectString (getter, str, mapper);
            for (int i =len;i < s.length();i+=1)
            {
                sb.deleteCharAt (0);
                sb.append (s.charAt(i));
                String st = sb.toString();
               ans += inspectString (getter, st, mapper);
            }        
        }
        return ans;
    }
}
