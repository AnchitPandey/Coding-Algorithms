import java.io.*;
import java.util.*;

public class balancedBrackets {
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

public static void main(String[] args)throws Exception
{
 faster f = new faster();
 int tc = f.nextInt();

 for (int t =1; t<=tc;t+=1)
 {

 String input = f.nextLine();
 Stack<Character> st = new Stack<Character>();
 int flag = 0;
 for (int i = 0; i< input.length();i+=1)
 {
     if (input.charAt(i) =='(' || input.charAt(i) =='{' || input.charAt(i) =='[')
         st.push(input.charAt(i));
     
     else if (input.charAt(i) ==')' || input.charAt(i) =='}' || input.charAt(i) ==']')
     {
         //String str ="";
         char str = '0';
         if (!st.isEmpty())    
          str =  st.pop();
         else
         {
            //System.out.println(i+1);
            flag =1;
            break;
         }
         
         if ((str =='[' && input.charAt(i)!=']' ) || (str =='(' && input.charAt(i)!=')' ) || (str =='{' && input.charAt(i)!='}' ))
         {
            flag = 1;
            break;
         }        
     }
 }
 if (!st.isEmpty() && flag ==0)
             flag = 1;        
 
    if (flag ==0)
        System.out.println("YES");
    else
    System.out.println("NO");
}
}
}
