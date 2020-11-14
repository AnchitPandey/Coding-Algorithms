class Solution {
    
    public String removeDuplicateLetters(String s) {
        
    int n = s.length();
    HashMap<Character, Integer> mapper = new HashMap<Character, Integer>();
    for (int i =0; i< s.length();i++)
    {
        char ch = s.charAt (i);
        mapper.put (ch, mapper.getOrDefault (ch,0)+1);
    }
            
    Stack<Character> st = new Stack<Character>();
    HashMap<Character, Integer> stackMap = new HashMap<Character, Integer>();
    st.push  (s.charAt(0));
    stackMap.put (s.charAt(0),1);
    mapper.put (s.charAt(0), mapper.get(s.charAt(0))-1);
    if (mapper.get(s.charAt(0)) == 0)
        mapper.remove (s.charAt(0));
    
    for (int i=1; i< n; i+=1)
    {
        char ch = s.charAt (i);
        if (stackMap.containsKey (ch))
        {
            mapper.put (ch,mapper.get(ch)-1);
            if (mapper.get(ch) ==0)
                mapper.remove (ch);
            continue;
        }
            while (!st.isEmpty() && st.peek () > ch && mapper.containsKey(st.peek()))
        {   
                char temp = st.pop();
                stackMap.remove (temp); 
        }
        st.push (ch);
        mapper.put(ch, mapper.get(ch)-1);
        if (mapper.get(ch) ==0)
            mapper.remove(ch);
        stackMap.put (ch,1);
    }
        
        StringBuilder sb = new StringBuilder  ();
        while (!st.isEmpty())
        {
            char ch = st.pop();
            sb.append (ch);
        }
        return sb.reverse().toString();
    }
}
