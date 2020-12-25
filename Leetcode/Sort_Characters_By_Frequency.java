class custom implements Comparator <Model>
{
public int compare (Model m1, Model m2)
{
    return m2.value - m1.value;
}
}

class Model  {
    int value;
    char ch;
    public Model (int value, char ch)
    {
        this.ch = ch;
        this.value = value;
    }
}

class Solution {
    public String frequencySort(String s) {
       
       HashMap<Character, Integer> mapper = new HashMap<Character,Integer>();
       for(int  i=0 ;i< s.length();i+=1){
            char ch = s.charAt(i);
            mapper.put (ch, mapper.getOrDefault(ch,0)+1);              
       }
       PriorityQueue<Model> pq = new PriorityQueue<Model>(new custom());
       for (Map.Entry<Character,Integer> hm: mapper.entrySet())
       {
           Model ml = new Model (hm.getValue(), hm.getKey());
           pq.add (ml);
       }
        StringBuilder sb = new StringBuilder ();
       while (!pq.isEmpty())
       {
           Model getter = pq.poll();
           for (int j =0 ;j< getter.value;j+=1)
               sb.append (getter.ch);
       }
        return sb.toString();
    }
}
