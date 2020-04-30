import java.io.*;
import java.util.*;

class lexographicallyMinimalString
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
     


    public static int findParent(int id, int[] parent)
    {
        if (id != parent[id])
            parent[id] = findParent (parent[id], parent);
        return parent[id];
    }

    public static void main (String[] args)throws Exception
    {
        faster f1 = new faster();
       // BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String a = f1.next();
     String b =  f1.next();
        String c =  f1.next();
        // String a = buff.readLine();
        // String b = buff.readLine();
        // String c = buff.readLine();
        int[] parent = new int[26];

        for (int i =0; i< 26;i+=1)
            parent[i] = i;
         
        for (int i =0; i< a.length();i+=1)
        {
            char ch1  = a.charAt(i);
            char ch2  = b.charAt(i);
            int par1 = findParent((int)ch1-97, parent);
            int par2 = findParent((int)ch2-97, parent);

            if (par1 < par2)
                parent[par2] = par1;
            else 
                parent[par1] = par2;
        }

        for (int i =0; i< 26;i+=1)
            parent[i]  = findParent(i, parent);

        StringBuilder sb = new StringBuilder();
        for (int i =0; i< c.length();i+=1)
        {
            char ch = c.charAt(i);           
            int num = parent[(int) ch-97];
            char ch2 = (char)(num+97);
            sb.append(ch2); 
        }

        String str = sb.toString();
        System.out.println(str);
    }
}
