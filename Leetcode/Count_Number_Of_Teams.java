class Solution {
    
    public int numTeams(int[] rating) {
    
       int total =0;
       for (int i  =0; i < rating.length; i+=1)
       {
           int ar =0, al =0, dr = 0, dl =0;
           for (int j = i+1; j< rating.length;j+=1)
           {
               if (rating[j] > rating[i])
                   ar+=1;
               else if (rating[j] < rating[i])
                   dr+=1;
           }
           for (int j= i-1; j>=0; j--)
           {
               if (rating[j] < rating[i])
                   al +=1;
               else if (rating[j] > rating[i])
                   dl+=1;
           }
           total += al* ar + dl * dr;
       }
       return total;
    }
}
