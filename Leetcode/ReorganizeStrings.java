class custom implements Comparator <ArrayList> {
    
    public int compare (ArrayList o1, ArrayList o2)
    {
        return -((int)o1.get(1) - (int)o2.get(1));
    }
}


class Solution {
    public String reorganizeString(String s) {

        HashMap<Character,Integer> mapper = new HashMap<Character, Integer>();
        
        for (int i =0 ; i< s.length();i+=1)
        {
            char ch = s.charAt(i);
            mapper.put (ch, mapper.getOrDefault(ch,0)+1);
        }
        PriorityQueue<ArrayList> pq = new PriorityQueue<ArrayList>(new custom());
        ArrayList<Character> chs = new ArrayList<Character>(mapper.keySet());
        
        for (int i=0; i < chs.size();i+=1)
        {
            ArrayList putter=  new ArrayList();
            putter.add (chs.get(i));
            putter.add (mapper.get(chs.get(i)));
            pq.add (putter);
        }       
        
        
        int len = s.length();
        StringBuilder sb  = new StringBuilder();
        char prev = '-';
        while (sb.length() != s.length())
        {
            //System.out.println("in here");
            ArrayList topmost= pq.poll();
            //System.out.println("array list is "+ topmost);
            char ch = (char) topmost.get(0);
            if (ch != prev)
            {
                sb.append (ch);
                prev = ch;
                int fre = (int)topmost.get(1);
                topmost.remove (1);
                if (fre > 1)
                {
                    topmost.add (fre-1);
                    pq.add (topmost);
                }
            }
            else
            {
                if (pq.isEmpty())
                    return "";
                else
                {
                    ArrayList secondmst = pq.poll();
                    sb.append ((char)secondmst.get(0));
                    prev = (char)secondmst.get(0);
                    int fre2 = (int)secondmst.get(1);
                    if (fre2 > 1)
                    {
                        secondmst.remove (1);
                        secondmst.add (fre2-1);
                        pq.add (secondmst);
                     }
                    pq.add (topmost);
                }
            }    
        }
        return sb.toString ();
    }
}
