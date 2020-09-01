/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws Exception {
	    
	    BufferedReader buff = new BufferedReader (new InputStreamReader(System.in));
	    int testcase = Integer.parseInt (buff.readLine());
	    for (int test=1; test<=testcase;test+=1)
	    {
	       int n = Integer.parseInt (buff.readLine());
	       String[] input = buff.readLine().split("\\s+");
	       Stack<String> stack = new Stack<String>();
	       for (int i =0 ;i< input.length;i++)
	       {
	            if (!stack.isEmpty())
	            {
	               String str = stack.peek();
	               if (str.equals(input[i]))
	                    stack.pop();
                    else
                    stack.push (input[i]);
	            }
	           else
	           stack.push (input[i]);
	       }
	       System.out.println(stack.size());
	    }
	}
}
