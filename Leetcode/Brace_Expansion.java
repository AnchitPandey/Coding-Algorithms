class Solution {
    
    ArrayList<String> ans;
    public ArrayList<Character> formatString (String str)
    {
        ArrayList<Character> ans = new ArrayList();
        String[] arr = str.split(",");
        for (int i =0 ; i< arr.length;i+=1)
            ans.add (arr[i].charAt(0));
        return ans;
    }
    
        
    public void backTrack (int index, HashMap<Integer, ArrayList<Character>> mapper, int length, StringBuilder sb)
        {
            if (index == length) {              
                String str = sb.toString();
                ans.add (str);
                return;
            }
            ArrayList<Character> children = mapper.get(index);
            for (char ch: children)
            {
                sb.append (ch);
                backTrack (index+1, mapper, length, sb);
                sb.deleteCharAt(sb.length()-1);
            }
            return;
        }
    
    
    public String[] expand(String s) {    
        HashMap<Integer, ArrayList<Character>> mapper = new HashMap();
        ans = new ArrayList();
        int counter =0;
        boolean out = false;
        StringBuilder sb = new StringBuilder();
        for (int i =0; i < s.length();i+=1)
        {
            char ch = s.charAt(i);
            if (out && ch =='}')
            {
                ArrayList<Character> gets = formatString (sb.toString());
                mapper.put (counter, gets);
                counter+=1;
                sb = new StringBuilder();
                out = false;                
            }
            else if (out)
                sb.append (ch);
            else if (ch =='{')
                out = true;
            else if (!out)
            {
                ArrayList<Character> gets = new ArrayList();
                gets.add  (ch);
                mapper.put (counter, gets);
                counter+=1;
            }    
        }
        for (Map.Entry<Integer, ArrayList<Character>> me: mapper.entrySet())
        {
            ArrayList<Character> ls = me.getValue();
            Collections.sort (ls);
        }
        //System.out.println(mapper);
        sb = new StringBuilder();
        backTrack(0,mapper, counter,sb);        
        String[] fa = new String[ans.size()];
        for (int i =0 ; i< fa.length;i++)
            fa[i] = ans.get(i);
        return fa;
    }
}
