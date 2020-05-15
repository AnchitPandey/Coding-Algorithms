class studentAttendanceRecord1 {
    public boolean checkRecord(String s) {
    
        if (s.length () ==0)
            return true;
        
        int counter= 0;
        for (int i=0 ; i< s.length();i+=1)   
        {
            if (s.charAt(i) == 'A')
                counter+=1;
            if (counter > 1)
                return false;
        }
     counter =0;
        for (int i =0  ; i< s.length();i+=1)
        {
            if (s.charAt(i) =='L')
                counter+=1;
            else
                counter =0;
            if (counter >2)
            {
             
                return false;
            }
        }
        return true;
    }
}
