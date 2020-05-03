class test implements Comparator <int[]>
{
    public int compare (int[] o1, int[] o2)
    {
        if (o1[1] < o2[1])
            return -1;
            
        else if (o1[1] > o2[1])
            return 1;
    
        return o1[0]-  o2[0];
    }
}


class sortIntegersByNumberOf1Bits {
    public int[] sortByBits(int[] arr) {
        
        int n = arr.length;
        ArrayList<int[]> ls = new ArrayList<int[]>();
        
        for (int i =0 ; i< arr.length;i+=1)
        {
            int counter =0; 
            String inp = Integer.toBinaryString(arr[i]);
            for (int j =0;j< inp.length();j+=1)
            {
                if (inp.charAt(j) =='1')
                    counter+=1;
            }
            int[] temp = new int[2];
            temp[0] = arr[i];
            temp[1] = counter;
            ls.add(temp);
        }
        
        Collections.sort (ls, new test());
        int[] fa=  new int[arr.length];
        for (int i =0; i< n; i+=1)
        {
            int[] tt = ls.get(i);
            fa [i] = tt[0];
        }
        return fa;
    }
}
