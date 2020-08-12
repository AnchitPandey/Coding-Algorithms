class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
     
        
     int total = 0;
        for(int i =0; i< startTime.length;i++)
        {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime)
                total+=1;
        }
        return total;
    }
}
