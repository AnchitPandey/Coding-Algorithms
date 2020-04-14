import java.io.*;
import java.util.*;

class TestClass {

static class faster 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public faster()     
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }

    public static void main(String args[] ) throws Exception {
        
        faster f1 = new faster();
        int n =f1.nextInt();
        Queue<Integer> call = new LinkedList<Integer>();
        for (int i =0 ; i< n;i+=1)
            call.add (f1.nextInt());

        Queue<Integer> ideal = new LinkedList<Integer>();
        for (int i =0 ; i< n;i+=1)
            ideal.add (f1.nextInt());

        int counter =0; 

        while (!call.isEmpty())
        {
            int num = call.poll();
            counter+=1;
            if (num != ideal.peek())
                call.add (num);
            else 
                ideal.poll();
        }
        System.out.println(counter);
    }
}
