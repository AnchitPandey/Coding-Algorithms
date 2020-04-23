class minTimeDifference {
    public int findMinDifference(List<String> timePoints) {
    
        if (timePoints.size() ==0)
            return 0;
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for (int i =0; i< timePoints.size();i+=1)
        {
            String[] splitter = timePoints.get(i).split (":");
            int min1 = Integer.parseInt(splitter[0]);
            int min2 = Integer.parseInt(splitter[1]);
            int total = min1 *60 + min2;
            ls.add (total);
        }
        Collections.sort(ls);
        int min = Integer.MAX_VALUE;
        for (int i =1 ; i< ls.size();i+=1)
        {
            if  (ls.get(i) - ls.get(i-1) < min)
                min = ls.get(i) - ls.get(i-1);
        }
        min = Integer.min (min, 1440 - ls.get(ls.size()-1) + ls.get(0));
        return min;
    }
}
