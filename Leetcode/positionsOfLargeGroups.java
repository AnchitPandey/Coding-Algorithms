class positionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String s) {
        
        List<List<Integer>> fa = new ArrayList<List<Integer>>();
        int counter = 1;
        ArrayList<Integer> lister = new ArrayList<Integer>();
        for (int i =1;  i< s.length();i+=1)
        {   
            if (s.charAt(i) == s.charAt(i-1))
            {
                counter+=1;
                if (counter == 3)
                {
                    lister.add (i-2);
                }
            }
            else 
            {
                if (lister.size() !=0)
                {
                    lister.add (i-1);
                    fa.add (lister);
                }
                counter =1;
                lister = new ArrayList<Integer>();
            }
        }
        if (lister.size() !=0 )
        {
            lister.add (s.length()-1);
            fa.add (lister);
        }
        return fa;
    }
}
