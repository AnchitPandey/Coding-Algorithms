class nextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        if (nums1.length ==0 || nums2.length ==0)
        {
            int[] fa = new int[0];
            return fa;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int n = nums2.length;
        int[] indi = new int[n];
        stack.push(0);
        HashMap<Integer,Integer> mapper = new HashMap<Integer,Integer>();
        mapper.put(nums2[0],0);
        for (int i =1 ; i<n ;i+=1)
        {
            mapper.put (nums2[i],i);
            // if (nums2[i] > nums2[stack.peek()])
            // {
                while (nums2[i] > nums2[stack.peek()])
                {
                    int index = stack.pop();
                    indi[index] = i;
                    if (stack.isEmpty())
                        break;
                }
           // }    
              stack.push (i);
        }
        while (!stack.isEmpty())
        {
            int index = stack.pop();
            indi[index] = -1;
        }
         
        int[] fa = new int [nums1.length];
        for (int i =0;i< nums1.length;i+=1)
        {
            int index = mapper.get(nums1[i]);
            if (indi[index] ==-1)
                fa[i] = -1;
            else
            fa[i] = nums2[indi[index]];
        }
        return fa;
    }
}
