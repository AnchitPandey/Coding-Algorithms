class custom implements Comparator<Model> {
    
    public int compare (Model m1, Model m2)
    {
        if (m1.length < m2.length)
            return -1;
        else if (m1.length > m2.length)
            return 1;
        else
            return m1.order - m2.order;
    }
}

class Model {
    String text;
    int order, length;
    public Model (String text, int order, int length)
    {
        this.text = text;
        this.order = order;
        this.length = length;
    }   
}

class Solution {
    
    public String arrangeWords(String text) {
        
    PriorityQueue<Model> pq =new PriorityQueue(new custom());
        char[] toarr = text.toCharArray();
        toarr[0] = (char)((int)toarr[0] + 32);
        text = new String(toarr);
        String[] splitter = text.split("\\s+");
        for (int i= 0; i< splitter.length;i++)
        {
            Model m = new Model (splitter[i], i, splitter[i].length());
            pq.add (m);
        }
        String ans ="";
        while (!pq.isEmpty()) {         
            Model tt =pq.poll();
            ans += tt.text;
            if (!pq.isEmpty())
            ans +=" ";
        }
        toarr = ans.toCharArray();
        toarr[0] = (char) ((int)toarr[0]-32);
        ans = new String(toarr);
        return ans;
    }
}
