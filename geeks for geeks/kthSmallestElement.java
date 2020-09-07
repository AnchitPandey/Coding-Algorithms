import java.io.*;
import java.util.*;


class template
{
    public static void main(String[] args)throws Exception
    {
        BufferedReader buff =  new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(buff.readLine());
        for (int test =1;test<=testcase;test++)
        {
            String[] input = buff.readLine().split("\\s+");
            int n = Integer.parseInt(input[0]);
            int[] array = new  int[n];
            input = buff.readLine().split("\\s+");
            for (int i=0;i<n;i++)
                array[i] = Integer.parseInt(input[i]);
            int k = Integer.parseInt(buff.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
            for (int i =0; i< k;i+=1)
                pq.add (array[i]);
                
            for (int i = k; i< n;i++)
            {
                if (array[i] < pq.peek())
                {
                    pq.poll();
                    pq.add (array[i]);
                }
            }
        System.out.println(pq.peek());
        } 
    } 
}
