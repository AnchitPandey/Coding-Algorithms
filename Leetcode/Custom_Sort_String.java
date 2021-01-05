class custom implements Comparator <Model>
{
    public int compare (Model m1, Model m2)
    {
        return m1.weight - m2.weight;
    }
}
class Model {
    char ch;
    int weight;
    public Model (char ch, int weight)
    {
        this.ch = ch;
        this.weight = weight;
    }
}

class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> mapper = new HashMap();
        int index =0;
        for (int i =0; i < S.length();i+=1 )
        {
            char ch = S.charAt(i);
            mapper.put (ch, index);
            index+=1;
        }
        PriorityQueue<Model> pq=  new PriorityQueue(new custom());
        for (int i =0; i< T.length();i+=1)
        {
            char ch = T.charAt(i);
            int d ;
            if (!mapper.containsKey(ch))
                d = -1;
                else
                d = mapper.get(ch);
            Model m = new Model(ch,d);
            pq.add (m);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Model tt = pq.poll();
            sb.append (tt.ch);
        }
        return sb.toString();
    }
}
