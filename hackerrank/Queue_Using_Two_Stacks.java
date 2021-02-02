import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args)throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt (buff.readLine());
        Stack<Integer> stack1  = new Stack();
        Stack<Integer> stack2 = new Stack();
        String[] splitter;
        for (int i =0 ; i< q;i++)
        {
            splitter = buff.readLine().split("\\s+");
            if(splitter[0].equals("1"))
            {
                int num = Integer.parseInt(splitter[1]);
                stack1.push (num);    
            }
           else if (splitter[0].equals ("2"))
           {
               if (!stack2.isEmpty())
               {
                   stack2.pop();   
                   continue;
               }
               while (!stack1.isEmpty())
               {
                   int num = stack1.pop();
                   stack2.push (num);
               }
               stack2.pop();   
           } 
           else if (splitter[0].equals ("3"))
           {
                if (!stack2.isEmpty())
                {
                    System.out.println(stack2.peek());                    
                    continue;
                }
               while (!stack1.isEmpty())
               {
                   int num = stack1.pop();
                   stack2.push (num);
               }
               System.out.println(stack2.peek());                         
           }
        }         
    }
}
