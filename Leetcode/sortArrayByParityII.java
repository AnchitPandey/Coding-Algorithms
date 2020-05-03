class sortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        
        ArrayList<Integer> odd = new ArrayList<Integer>();
        ArrayList<Integer> even = new ArrayList<Integer>();
        for (int i  =0 ; i< A.length;i++)
        {
            if (A[i] %2 ==0)
                even.add (A[i]);
            else
                odd.add(A[i]);
        }
            
        int[] fa= new int[A.length];
        for (int i =0 ;i<fa.length;i+=1)
        {
            if (i %2 ==0)
            {
                fa[i] = even.remove (even.size()-1);
            }
            else
                fa[i]=  odd.remove (odd.size()-1);   
        }
        return fa;
    }
}
