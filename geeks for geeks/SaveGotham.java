/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws Exception {
	 
	 BufferedReader buff = new BufferedReader (new InputStreamReader (System.in));
	 int testcase = Integer.parseInt(buff.readLine());
	 for (int test=1;test<= testcase;test+=1)
	 {
         int n  = Integer.parseInt (buff.readLine());
         int[] arr = new int [n];
         String[] input = buff.readLine().split("\\s+");
         for (int j =0; j< n;j+=1)
            arr[j] = Integer.parseInt (input[j]);
        
        Stack<Integer> stack = new Stack<Integer>();
        long ans = 0L;
        stack.push (0);
        for (int j =1 ; j< n;j+=1)
        {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[j])
                {
                    stack.pop();
                    ans += arr[j];
                }
                stack.push (j);
        }
        System.out.println(ans % 1000000001);
	 }
	}
}
