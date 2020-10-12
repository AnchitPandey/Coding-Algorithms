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
	        int[] arr = new int[n];
	        String[] input = buff.readLine().split("\\s+");
	        for (int i =0; i< n;i+=1)
	            arr[i]= Integer.parseInt (input[i]);
	        int[] left = new int[n];
	        Stack<Integer> stack = new Stack<Integer>();
	        stack.push (n-1);
	        for (int i = n-2;i>=0;i--){
	            while (!stack.isEmpty() && arr[i] < arr[stack.peek()])
	            {
	                left[stack.pop()] = arr[i];               
	            }
	            stack.push (i);
	        }
	        while (!stack.isEmpty())
	        {
	            left[stack.pop()] = -1;         
	        }
	        for (int i =0; i< n;i+=1)
	            System.out.print (left[i]+" ");
	        System.out.println();
	    }
	}
}
