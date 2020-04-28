class monotonicArray {
    public boolean isMonotonic(int[] A) {
        if (A.length ==0)
            return true;
        
        if (A[0] < A[A.length-1])
        {
            for (int i =1; i< A.length;i+=1)
            {
                if (A[i] < A[i-1])
                    return false;
            }
            return true;
        }
        else if (A[0] > A[A.length-1])
        {
            for (int i =1; i< A.length;i+=1)
            {
                if (A[i] > A[i-1])
                    return false;
            }
            return true;
        }
        else
        {   
            for (int i =1; i< A.length;i+=1)
            {
                if (A[i] != A[i-1])
                    return false;
            }
            return true;
        }
    }
}
