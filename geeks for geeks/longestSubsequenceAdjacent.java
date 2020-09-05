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
	        int[] array = new int[n];
	        for (int i =0; i< n;i+=1)
	            array[i] = Integer.parseInt (input[i]);
	        HashMap<Integer, Integer> mapper = new HashMap<Integer, Integer>();
	        
	       for (int i =0; i< n;i+=1)
	        {
	            if (!mapper.containsKey (array[i]-1) && !mapper.containsKey (array[i]+1))
	               mapper.put (array[i],1);
	            
                else if (mapper.containsKey (array[i]+1) && mapper.containsKey(array[i]-1))
                    mapper.put (array[i], 1 + Integer.max(mapper.get(array[i]+1), mapper.get(array[i]-1)));
                    
                else if (mapper.containsKey (array[i]+1))
                    mapper.put (array[i], 1+ mapper.get(array[i]+1));
                    
                else if (mapper.containsKey (array[i]-1))
                    mapper.put (array[i], 1+ mapper.get(array[i]-1));
	        }
	        ArrayList<Integer> values = new ArrayList<Integer>(mapper.values());
	        int max = 0;
	        for (int i =0; i< values.size();i+=1)
	            max = Integer.max (max, values.get(i));
	        System.out.println(max);
	    }
	}
}
