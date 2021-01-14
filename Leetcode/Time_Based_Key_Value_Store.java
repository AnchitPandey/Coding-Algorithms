class TimeMap {

    /** Initialize your data structure here. */
    HashMap<String, ArrayList<Integer>> keyTime;
    HashMap<ArrayList, String> val;
    public TimeMap() {
        keyTime = new HashMap();
        val = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!keyTime.containsKey(key)) {
            
            ArrayList<Integer> ls = new ArrayList();
            ls.add (timestamp);
            keyTime.put (key, ls);
        }
        else {
            ArrayList<Integer> getter = keyTime.get(key);
            getter.add (timestamp);
        }
        ArrayList quer = new ArrayList();
        quer.add (key);
        quer.add (timestamp);
        val.put (quer, value);
    }
    
    public String get(String key, int timestamp) {
            
        ArrayList<Integer> gets = keyTime.get(key);
        int index = Collections.binarySearch(gets, timestamp);
        if (index < 0)
            index = -index-2;
        if (index < 0)
            return "";
        ArrayList quer = new ArrayList();
        quer.add (key);
        quer.add (gets.get(index));
        return val.get(quer);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
