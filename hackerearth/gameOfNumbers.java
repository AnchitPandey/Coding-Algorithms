import java.io.*;
import java.util.*;

class gameOfNumbers {

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
     //   BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        faster f1 = new faster();
        int n = f1.nextInt();
      //  int n = Integer.parseInt(buff.readLine());
        //String[] input = buff.readLine().split("\\s+");
        long[] arr = new long[n];
        for (int i =0; i < n;i+=1)
            arr[i] = f1.nextLong();
           // arr[i] = Long.parseLong(buff.readLine());
          //  arr[i] = Integer.parseInt(input[i]);
        int[] f_x = new int[n];
        int[] g_x = new int[n];

        // calculating F(x) for every element
        Stack<Integer> st = new Stack<Integer>();
        st.push (0);
        for (int i= 0; i< n;i+=1)
        {
            while (!st.isEmpty() && arr[i] > arr[st.peek()])
                {
                int index =st.pop();
                f_x[index] = i;
                }         
            st.push(i);
        }
        while (!st.isEmpty())
        {
            f_x[st.pop()] = -1;
        }

        // calculating G(x) for every element
        st.push (0);
        for (int i= 0; i< n;i+=1)
        {
            while (!st.isEmpty() && arr[i] < arr[st.peek()])
                {
                int index =st.pop();
                g_x[index] = i;
                }         
            st.push(i);
        }

        while (!st.isEmpty())
        {
            g_x[st.pop()] = -1;
        }

        // Printing to console
        for (int i=0; i< f_x.length;i+=1)
        {
            if (f_x[i] ==-1)
                System.out.print("-1 ");
            else
            {
                    if (g_x[f_x[i]] ==-1)
                        System.out.print("-1 ");
                    else
                     System.out.print(arr[g_x[f_x[i]]]+" ");
            }
        
        }

    }
}
