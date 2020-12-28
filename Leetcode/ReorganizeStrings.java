class custom implements Comparator<Model>
{
    public int compare (Model m1, Model m2)
    {
        return m2.fre - m1.fre;
    }
}

class Model {

    char ch;
    int fre;
    public Model (char ch, int fre)
    {
        this.ch = ch;
        this.fre = fre;
    }
}
class Solution {

    // TC: O (N * log N_DIST (<=26) ) =>  O (N)
    // SC: O (N)
    
    public String reorganizeString(String S) {
        // Create Map
        HashMap<Character, Integer> mapper = new HashMap<Character, Integer>();
        for (int i = 0 ; i< S.length();i+=1){       
            char ch = S.charAt(i);
            mapper.put (ch, mapper.getOrDefault(ch,0)+1);
        }
        // Creating PQ
        PriorityQueue<Model> pq = new PriorityQueue<Model>(new custom());
        for (Map.Entry<Character,Integer> me: mapper.entrySet()){
        
            Model m =new Model (me.getKey(), me.getValue());
            pq.add (m);
        }
        // Main Logic
        StringBuilder sb=new StringBuilder();
        while (!pq.isEmpty()){
        
            char prev = sb.length () > 0 ? sb.charAt(sb.length()-1) : '-' ;
            Model ml = pq.poll();
            if (ml.ch  == prev)
            {
                if (pq.size() ==0)
                    return "";
                else
                {
                    Model tt = pq.poll();
                    sb.append (tt.ch);
                    tt.fre -=1;
                    if (tt.fre >0)
                        pq.add (tt);
                    pq.add (ml);
                }
            }
            else
            {
                sb.append  (ml.ch);
                ml.fre-=1;
                if (ml.fre > 0)
                    pq.add (ml);           
            }    
        } 
        return sb.toString();        
    }
}
