import java.io.*;
import java.util.*;

public class minAdd {

public static void main(String[] args)throws Exception
{
BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

 //String input = f.nextLine();
 String input = buff.readLine();
 Stack<Character> st = new Stack<Character>();
 int flag = 0;
 int counter =0;
 for (int i = 0; i< input.length();i+=1)
 {

     if (input.charAt(i) =='(')
     {
         
         char str = input.charAt(i);
         st.push(str);
     }

     else if (input.charAt(i) ==')')
     {
         char str  ='a';
         if (!st.isEmpty())    
            str =  st.pop();
         else
            counter +=1;                
     }
 }
   counter += st.size();
   System.out.println(counter);
}
}
