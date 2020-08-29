/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class MaximumRectangularArea {
    
	public static void main (String[] args)throws Exception {
		
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(buff.readLine());
		for (int test=1; test<=testcase;test+=1)
		{
		    int n = Integer.parseInt(buff.readLine());
		    int[] nums = new int[n];
		    String[] input = buff.readLine().split("\\s+");
		    for (int i =0; i< input.length;i+=1)
		        nums[i] = Integer.parseInt (input[i]);
		    
		    int[] right = new int[n];
		    int[] left = new int[n];
		    
		    Stack<Integer> stack = new Stack<Integer>();
		    stack.push (0);
		    
		    for (int i=1; i< n;i+=1)
		    {
	            while (!stack.isEmpty() && nums[i] < nums[stack.peek()])
	            {
	                int nu = stack.pop();
	                right[nu] = i - nu;    
	            }
	            stack.push(i);
		    }
		    while (!stack.isEmpty())
		    {
		        int nu  =stack.pop();
		        right[nu] = n - nu;
		    }
		    stack.push (n-1);
		    for (int i =n-2;i>=0;i--)
		    {
		        while (!stack.isEmpty() && nums[i] < nums[stack.peek()])
		        {
		            int nu = stack.pop();
		            left[nu] = nu - i;
		        }
		        stack.push (i);
		    }
		    while (!stack.isEmpty())
		    {
		        int nu = stack.pop();
		        left[nu] = nu+1;
		    }
		    
		    int[] total = new int[n];
		    for (int i =0; i< n;i+=1)
		    total[i] = right[i]+ left[i]-1;
		    
		    int max = 0;
		    for (int i =0; i< n;i+=1)
		        max = Integer.max (max, total[i] * nums[i]);
		    
		    System.out.println(max);
		}
	}
}
