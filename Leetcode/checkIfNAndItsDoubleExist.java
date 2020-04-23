class checkIfNAndItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        
    HashMap<Integer, Integer> mapper = new HashMap<Integer,Integer>();
    for (int i =0 ; i< arr.length;i++)
    {
        mapper.put (arr[i],1);
    
    }
        for (int i =0;  i< arr.length;i+=1)
        {
            if (arr[i] !=0 && arr[i] % 2==0 && mapper.containsKey(arr[i]/2))
            {
             //   System.out.println(arr[i]);
                return true;
            }
            if (arr[i] !=0 && mapper.containsKey(arr[i]*2))
                return true;
        }
    
        int counter =0;
        for (int i= 0 ; i< arr.length;i+=1)
        {
            if (arr[i] ==0)
                counter+=1;
            
        }
        if (counter >1)
            return true;
            return false;
}
}
