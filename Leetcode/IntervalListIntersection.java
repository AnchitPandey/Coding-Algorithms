class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
     
        int index1 = 0, index2 =0;
        int len1 = A.length;
        int len2 = B.length;
        ArrayList<int[]> ans = new ArrayList<int[]>();
        while (index1 < len1 && index2 < len2)
        {
            int start1 = A[index1][0];
            int end1 = A[index1][1];
            
            int start2 = B[index2][0];
            int end2 = B[index2][1];
            
            if (end1 < start2)
            {
                index1+=1;
                continue;
            }
            else if (end2 < start1)
            {
                index2+=1;
                continue;
            }
            else if (start1 > start2)
            {
                if (end1 >end2)
                {
                    int[] tt = new int[] {start1, end2};
                    ans.add (tt);
                    index2+=1;
                }
                else if (end1 < end2)
                {
                    int[] tt =new int[] {start1, end1};
                    ans.add (tt);                    
                    index1+=1;
                }
                else if (end1 == end2)
                {
                    int[] tt= new int[] {start1, end1};
                    ans.add (tt);
                    index1+=1;
                    index2+=1;
                }
            }
            
            else if (start1  < start2)
            {
                if (end1 < end2)
                {
                    int[] tt  = new int [] {start2, end1};
                    ans.add (tt);
                    index1+=1;
                }
                else if  (end1 > end2)
                {
                    int[] tt = new int[] {start2, end2};
                    ans.add (tt);
                    index2+=1;
                }
                else if (end1 == end2)
                {
                    
                    int[] tt = new int[] {start2, end1};
                    index1+=1;
                    index2+=1;
                    ans.add (tt);
                }               
            }
            
            else if (start1 == start2)
            {
                if (end1 < end2)
                {
                    int[] tt =new int[] {start1, end1};
                    ans.add (tt);
                    index1+=1;
                }
                else if (end2 < end1)
                {
                    int[] tt = new int[] {start1,end2};
                    ans.add (tt);
                    index2+=1;                   
                }
                else
                {
                    int[] tt = new int[] {start1, end2};
                    ans.add (tt);
                    index1+=1;
                    index2+=1;                   
                }
            }          
        }    
        int[][] fa = new int[ans.size()][2];
        for (int i =0 ; i< fa.length;i+=1)
        {
            int[] tt = ans.get(i);
            fa[i][0] = tt[0];
            fa[i][1] = tt[1];
        }
        return fa;
    }
}
