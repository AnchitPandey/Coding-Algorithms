class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        
        List<List<String>> ans = new ArrayList();
        if (paths.length ==0)
            return ans;
        
        HashMap<String,List<String>> mapper = new HashMap();
        for (int i =0 ; i<  paths.length;i++)
        {
            String[] spl = paths[i].split("\\s+");
            for (int j=1; j < spl.length;j+=1)
            {
                boolean counter = false;
                StringBuilder fileName = new StringBuilder(),
                content = new StringBuilder ();
                for(int k =0; k < spl[j].length();k+=1)
                {
                    char ch = spl[j].charAt(k);
                    if (ch =='(')
                    {
                        counter = true;
                        continue;
                    }
                    else if (ch ==')')
                    {
                        counter = false;
                        continue;
                    }
                    if (counter)
                        content.append (ch);
                    else
                        fileName.append (ch);
                }
                String dir = spl[0] + "/"+fileName.toString();
                String actualContent = content.toString();
                if (!mapper.containsKey(actualContent))
                {
                     List<String> ls = new ArrayList();
                     ls.add (dir);
                     mapper.put (actualContent, ls);
                }
                else
                {
                    List<String> ls = mapper.get(actualContent);
                    ls.add (dir);
                }
            }           
        }
        for (Map.Entry<String, List<String>> me: mapper.entrySet())
        {
            if (me.getValue().size() >=2)
                ans.add (me.getValue());
        }
        return ans;
    }
}
