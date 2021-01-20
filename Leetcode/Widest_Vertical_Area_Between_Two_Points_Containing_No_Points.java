class custom implements Comparator <int[]> {
    
    public int compare (int[] o1, int[] o2){
        return o1[0] - o2[0];
    }
}
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        ArrayList<int[]> ls = new ArrayList();
        for (int i=0; i< points.length;i+=1)
        {
            ls.add (points[i]);
        }
        Collections.sort (ls, new custom());
        int max = 0;
        for (int i = 1; i< ls.size();i+=1)
        {
            int diff = ls.get(i)[0] - ls.get(i-1)[0];
            max = Integer.max (max, diff);
        }
        return max;
    }
}
