class Solution {
    public int numRabbits(int[] answers) {
        if (answers.length ==0)
            return 0;
        HashMap<Integer, Integer> mapper = new HashMap();
        for (int i= 0; i< answers.length;i+=1)
        {
            int num = answers[i]+1;
            mapper.put (num, mapper.getOrDefault(num,0)+1);
        }
        int ans =0;
        for (Map.Entry<Integer,Integer> me: mapper.entrySet()) {
            ans += (int)Math.ceil((float)me.getValue() / me.getKey()) * me.getKey();
        }
        return ans;
    }
}
