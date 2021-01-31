class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer, Integer> mapper = new HashMap();
        int max = 0;
        for (int i = lowLimit;i <= highLimit;i+=1)
        {
            int num2 = i;
            int sum =0;
            while (num2 > 0)
            {
                sum += num2 % 10;
                num2 /=10;
            }
            mapper.put (sum, mapper.getOrDefault(sum,0)+1);
            max =Integer.max (max, mapper.get(sum));
        }
        return max;
    }
}
