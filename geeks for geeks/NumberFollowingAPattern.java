/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws Exception {
	    BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
	    int testcase = Integer.parseInt (buff.readLine());
	    
	    for (int test =1; test<=testcase;test+=1)
	    {
	        String input = buff.readLine();
	        Stack<Integer> stack = new Stack<Integer>();
	        StringBuilder sb =new StringBuilder();
	        for (int i= 0 ;i <= input.length();i+=1)
	        {
                stack.push (i+1);
                if (i == input.length() || input.charAt(i) =='I')
                {
                    while (!stack.isEmpty())
                    {
                        sb.append (stack.pop());
                    }
                }
	        }
	 System.out.println(sb.toString());
	    }
	 
	}
}
