class test implements Comparator <String>
{

    public int compare (String o1, String o2)
    {
        String[] splitter =  o1.split("\\s+");
        int num1 = Integer.parseInt(splitter[0]);
        int num2 = Integer.parseInt(splitter[1]);
        
        splitter =  o2.split("\\s+");
        int num3 = Integer.parseInt(splitter[0]);
        int num4 = Integer.parseInt(splitter[1]);
        
        if (Math.abs (num1 - num2 ) > Math.abs (num3 - num4))
            return -1;
        else
        return 1;
    }
}

class Solution {
    public int twoCitySchedCost(int[][] costs) {
  
    PriorityQueue<String> pq = new PriorityQueue<String>(new test());
    for (int i =0 ;  i< costs.length;i+=1)
    {
        String str1 = String.valueOf(costs[i][0])+" "+String.valueOf(costs[i][1]);
        pq.add (str1);
    }
    int city1 =0 ;
    int city2 =0;
    int n = costs.length/2;
    int total =0 ;
    while (!pq.isEmpty())
    {
        String getter = pq.remove();
       // System.out.println("string is "+ getter);     
        String[] splitter = getter.split("\\s+");
        int c1 = Integer.parseInt(splitter[0]);
        int c2 = Integer.parseInt(splitter[1]);
        if (city1 ==n)
        {
            total += c2;
            city2+=1;
        }
        else if (city2 ==n)
        {
            total +=c1;
            city1+=1;
        }
        
        else if (c1 <= c2)
            {
                total +=c1;
                city1+=1;
            }
        else if (c2 < c1)
        {
                total += c2;
                city2+=1;
        }
    }
    return total;
    }
}
