import java.io.*;
import java.util.*;


class custom implements Comparator<int[]>
{
    public int compare (int[] o1, int[] o2)
    {
        return o1[0] - o2[0]; 
    }
}

class TestClass {

    public static void main(String args[] ) throws Exception {

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt (buff.readLine());
        ArrayList<int[]> ls = new ArrayList<int[]>();
        //PriorityQueue<int[]> pq = new PriorityQueue <int[]>();
        for (int i =0  ;i< n; i+=1)
        {
            String[] input = buff.readLine().split("\\s+");
            for (int j =1; j< input.length-1;j+=2)
            {
                int start = Integer.parseInt (input[j]);
                int end = Integer.parseInt (input[j+1]);
                int[] temp = new int[] {start, end};
                ls.add (temp); 
            }
        }

        Collections.sort (ls, new custom());
        int[] curr = ls.get(0);
        int end= curr[1];
        int ans =-1;
        for (int i= 1; i < ls.size();i+=1)
        {
            int[] gets = ls.get(i);
            if (gets[0] >= end)
            {
                if (gets[0] - end >1)
                {
                    ans = end+1;
                    break;
                }
                else
                    end = gets[1];
            }
            else
                end = Integer.max (gets[1], end);
        }

        if (ans ==-1 && end +1 <=1000000)
            ans = end+1;
        System.out.println(ans);
    }
}
