class MyCalendarThree {

    TreeMap<Integer, Integer> mapper;
    public MyCalendarThree() {
        
        mapper = new TreeMap();
    }
    
    public int book(int start, int end) {
    
        int ans = 0,max =0;
        mapper.put (start,mapper.getOrDefault(start,0)+1);
        mapper.put (end,mapper.getOrDefault(end,0) - 1);
        for (int d: mapper.values())
        {
            ans +=d;
            max = Integer.max (ans, max);
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
