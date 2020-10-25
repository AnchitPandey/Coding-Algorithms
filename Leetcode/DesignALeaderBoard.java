class Leaderboard {

    HashMap<Integer,Integer> mapper;
    PriorityQueue<Integer> pq;
    
    public Leaderboard() {
        
        mapper = new HashMap<Integer, Integer>();
        pq= new PriorityQueue<Integer>(Collections.reverseOrder());
        
    }
    
    public void addScore(int playerId, int score) {
        
        if (!mapper.containsKey (playerId))
        {
            mapper.put (playerId, score);
            pq.add(score);
        }
        else
        {
            int sco = mapper.get(playerId);
            mapper.put (playerId, score + sco);
            pq.remove (sco);
            pq.add (score+ sco);
        }
    }
    
    public int top(int K) {
        
        int sum =0 ;
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for(int i = 0 ; i< K;i+=1)
        {
            int num = pq.poll();
            sum+= num;
            ls.add (num);     
        }
        for (int i= 0; i< K;i+=1)
            pq.add (ls.get(i));
        return sum;
    }
    
    public void reset(int playerId) {
        
        int get= mapper.get(playerId);
        mapper.remove(playerId);
        pq.remove (get);
        
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
