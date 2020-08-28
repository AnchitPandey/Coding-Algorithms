/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class InfixToPostFix {
    
	public static void main (String[] args)throws Exception {
 
    BufferedReader buff = new BufferedReader (new InputStreamReader(System.in));
    int testcase = Integer.parseInt (buff.readLine());
    HashMap<Character, Integer> mapper = new HashMap<Character, Integer>();
    mapper.put ('+',1);
    mapper.put ('-',1);
    mapper.put ('*',2);
    mapper.put ('/',2);
    mapper.put ('^',3);
    
    for (int test=1; test<=testcase;test+=1)
    {
        
        String exp = buff.readLine();
        Stack<Character> stack = new Stack<Character>();
        StringBuilder result = new StringBuilder("");
        for (int i =0 ;i< exp.length();i+=1)
        {
            char ch = exp.charAt(i);
            if ( (ch>='A' && ch <='Z') || (ch >='a' && ch<='z'))
                result.append(ch);                
            
            else if (mapper.containsKey (ch) )
            {
                while (!stack.isEmpty() && mapper.containsKey (stack.peek()) && mapper.get(stack.peek()) >= mapper.get(ch)) 
                {
                    char ch1 = stack.pop();
                    result.append (ch1);                
                }
                stack.push (ch);
            }
            else if (ch =='(')
                stack.push (ch);
                
            else if (ch == ')')
            {
                while (stack.peek () != '(')
                {
                    char ch1 = stack.pop();
                    result.append (ch1);
                }
                stack.pop();
            }
        }
        while (!stack.isEmpty())
            result.append (stack.pop());
        String finalAnswer = result.toString();
        System.out.println(finalAnswer);
    }
    
	}
}
