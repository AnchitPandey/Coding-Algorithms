/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class StockSpanProblem {
	public static void main (String[] args)throws Exception {
	
	    BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
	    int testcase = Integer.parseInt (buff.readLine());
	    for (int test=1; test<=testcase;test+=1)
	    {
	        int n = Integer.parseInt (buff.readLine());
	        int[] array = new int[n];
	        int[] answer = new int[n];
	        String[] input=  buff.readLine().split ("\\s+");
	        for (int i =0;i< n;i+=1)
	            array[i] = Integer.parseInt (input[i]);
	        Stack<Integer> stack = new Stack<Integer>();
	        stack.push (array.length-1);
	        for (int i = array.length-2;i>=0;i--)
	        {
                while (!stack.isEmpty() && array[i] > array[stack.peek()])
                {
                    int num = stack.pop();
                    answer[num] = num - i ;                
                }
                stack.push (i);
	        }
	        while (!stack.isEmpty())
	        {
	            int num = stack.pop();
	            answer[num] = num+1;
	        }
	        for (int i =0; i< answer.length;i+=1)
	            System.out.print(answer[i]+" ");
	            
	        System.out.println();    
	    }
	}
}
