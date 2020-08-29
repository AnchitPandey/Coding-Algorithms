/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class custom implements Comparator<int[]> {
    
    public int compare (int[] o1, int[] o2)
    {
        if (o1[0] < o2[0])
            return -1;
        else if (o1[0] > o2[0])
            return 1;
        else
            return o1[1] - o2[1];
    }
}


class GFG {
    
	public static void main (String[] args)throws Exception {
	    
		BufferedReader buff = new BufferedReader (new InputStreamReader(System.in));
	    int testcase = Integer.parseInt (buff.readLine());
	    for (int test=1; test<=testcase;test+=1)
	    {
	        int n = Integer.parseInt (buff.readLine());
	        String[] input = buff.readLine().split("\\s+");
	        int index=0;
	        int[][] intervals = new int [n][2];
	        int i =0;
	        while (index != input.length)
	        {
	            intervals[i][0] = Integer.parseInt (input[index]);
	            index+=1;
	            intervals[i][1] = Integer.parseInt (input[index]);
	            index+=1;
	            i+=1;
	        }
	       Arrays.sort (intervals, new custom());
	       Stack<int[]> stack = new Stack<int[]>();
	       for (int j =0; j< intervals.length;j++)
	       {
	           if (stack.isEmpty())
	           {
	               stack.push (intervals[j]);
	           }
	           else
	           {
	                int[] peeker = stack.peek();
	                if (intervals[j][0] >= peeker[0] && intervals[j][0] <=peeker[1])
	                    {
	                        int[] remover = stack.pop();
	                        
	                        remover[1] = Integer.max (intervals[j][1],remover[1]);
	                        stack.push (remover);
	                    }
	                else
	                stack.push (intervals[j]);
	           }
	       }
	       Stack<int[]> reverser = new Stack<int[]>();
	       while (!stack.isEmpty())
	       {
	           reverser.push (stack.pop());
	       }
	       while (!reverser.isEmpty())
	       {
	           int[] tt = reverser.pop();
	           System.out.print(tt[0]+" "+tt[1]+" ");
	       }
	     System.out.println();  
	    }
	}
}
