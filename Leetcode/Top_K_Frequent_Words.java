class custom implements Comparator<Model>
{
    public int compare (Model m1, Model m2)
    {
        if (m1.fre < m2.fre)
            return -1;
        else if (m1.fre > m2.fre)
            return 1;
        else
        {
            return m2.str.compareTo (m1.str);
        }
    }
    
}

class Model {
    
    String str;
    int fre;
    public Model (String str, int fre)
    {
        this.str = str;
        this.fre = fre;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> mapper = new HashMap<String, Integer>();
        for (int i =0; i< words.length;i+=1)
            mapper.put (words[i], mapper.getOrDefault(words[i],0)+1);
        PriorityQueue<Model> pq = new PriorityQueue<Model> (new custom());
        for (Map.Entry<String,Integer> me: mapper.entrySet())
        {
           Model ml = new Model (me.getKey(), me.getValue());
           if (pq.size() ==k)
           {
                Model top = pq.peek();
                if (ml.fre > top.fre)
                {
                    pq.poll();
                    pq.add (ml);
                }
               else if (ml.fre == top.fre)
               {
                  if (ml.str.compareTo(top.str) < 0) 
                  {
                      pq.poll ();
                      pq.add (ml);
                  }
               }              
           }
            else
             pq.add (ml);
        }
        List<String>  fa = new ArrayList<String>();
        while (!pq.isEmpty())
        {
            Model ml = pq.poll();
            fa.add (ml.str);
        }
        List<String>  ans = new ArrayList<String>();     
        for (int i = fa.size() -1; i>=0; i--)
        {
            String str = fa.get(i);
            ans.add (str);            
        }
        return ans;
    }
}
