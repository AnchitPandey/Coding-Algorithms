import java.io.*;
import java.util.*;

class arrayFormation
{

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


      public static boolean isPrime(int n) 
    { 
        // Corner cases 
        if (n <= 1) return false; 
        if (n <= 3) return true; 
      
        // This is checked so that we can skip  
        // middle five numbers in below loop 
        if (n % 2 == 0 || n % 3 == 0) return false; 
      
        for (int i = 5; i * i <= n; i = i + 6) 
            if (n % i == 0 || n % (i + 2) == 0) 
            return false; 
      
        return true; 
    } 

    public static void main(String[] args)throws Exception
    {
       // BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        faster f1 = new faster();
        int n = f1.nextInt();
        //int n = Integer.parseInt(buff.readLine());
       // String[] input = buff.readLine().split("\\s+");
        int[] arr = new int[n];
        for (int i=0;i<n;i+=1)
            arr[i] = f1.nextInt();
           // arr[i] = Integer.parseInt(input[i]);
        Stack<Integer> st = new Stack<Integer>();
        Stack<Integer> fa=  new Stack<Integer>();
        Queue<Integer> qu = new LinkedList<Integer>();
        for (int i=0; i< n;i+=1)
        {
            if (isPrime(arr[i]))
               qu.add (arr[i]); 
            else
            st.push (arr[i]);
        }
       
 
        // queue 
        
        while (!qu.isEmpty())
        {
           System.out.print(qu.poll()+" ");
        }  
        System.out.println();
       while (!st.isEmpty())
        {
            System.out.print(st.pop()+" ");
        }
    }
}
