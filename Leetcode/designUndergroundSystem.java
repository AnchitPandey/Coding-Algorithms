class designUndergroundSystem {

    HashMap<Integer,ArrayList<String>> current;
    HashMap<ArrayList<String>, int[]> m;
    
    public UndergroundSystem() {
        
        current = new HashMap<Integer,ArrayList<String>>();
        m = new HashMap<ArrayList<String>, int[]>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        
    String ti = String.valueOf(t);
    ArrayList<String> adder = new ArrayList<String>();
    adder.add (stationName);
    adder.add (ti);
    current.put (id, adder);
        
    }
    
    public void checkOut(int id, String stationName, int t) {
        
        ArrayList<String> putter = new ArrayList<String>();
        ArrayList<String> getter = current.get(id);
        putter.add (getter.get(0));
        putter.add (stationName);
        //String timeTaken = String.valueOf(t- getter.get(1));
        if (m.containsKey(putter))
        {
            int[] gets = m.get(putter);
            gets[0] +=  t - Integer.parseInt(getter.get(1));
            gets[1] +=1;
            m.put (putter, gets);
        }

        else
        {
           int[] gets = new int[2];
           gets[0]  = t - Integer.parseInt(getter.get(1));
           gets[1] = 1;
           m.put (putter,gets);
        } 
        current.remove (id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
       
        ArrayList<String> getter = new ArrayList<String>();
        getter.add (startStation);
        getter.add (endStation);
        int[] temp = m.get(getter) ;
        return (double) temp[0]/ temp[1];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * designUndergroundSystem obj = new designUndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
