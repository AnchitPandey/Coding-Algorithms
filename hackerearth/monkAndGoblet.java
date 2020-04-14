
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {

        //BufferedReader
        
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in)); 
        HashMap<Integer, Integer> mapper = new HashMap<Integer, Integer>();
        ArrayList<Integer> order = new ArrayList<Integer>();
        HashMap<Integer, Queue<String>> quMap = new HashMap<Integer, Queue<String>>();
        for (int i =1;i<=4;i+=1)
        {
            Queue<String> qu = new LinkedList<String>();
            quMap.put(i,qu);
        }
        
        
        int q = Integer.parseInt(buff.readLine());
        for (int test =1 ; test <= q; test +=1)
        {
            String[] input =  buff.readLine().split("\\s+");
            if (input[0].charAt(0) =='E')
            {
                int sid = Integer.parseInt(input[1]);
                int roll = Integer.parseInt(input[2]);
                String inp  = String.valueOf(sid)+" "+ String.valueOf(roll);
                Queue<String> getter = quMap.get(sid);
                getter.add (inp);
                if (!mapper.containsKey(sid))
                    {
                        mapper.put (sid,1);
                        order.add (sid);
                    }
            }
            else
            {
                int sidId = order.get(0);
                Queue<String> qu1  = quMap.get(sidId);
                System.out.println(qu1.poll());
                if (qu1.size() ==0)
                {
                    mapper.remove (sidId);
                    order.remove (0);    
                }                
            }
        }
    }
}
