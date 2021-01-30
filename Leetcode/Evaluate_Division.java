class Model {
    String str;
    double val;
    public Model (String str, double val)
    {
        this.str = str;
        this.val = val;
    }
}
class Solution { 
    public double dfs (String currentNode, String endNode, HashMap<String,ArrayList<Model>> mapper, double currentValue, Set<String> currentStack)
    {
       currentStack.add (currentNode);
       if (currentNode.equals (endNode))
       {
           if (mapper.containsKey(endNode))
             flag = true;
           currentStack.remove (endNode);
           return currentValue;
       }
        if (!mapper.containsKey(currentNode))
            return -1;
        ArrayList<Model> children = mapper.get(currentNode);
        double ans = currentValue;
        for (Model child: children)
        {
            if (!currentStack.contains(child.str))
             ans = dfs (child.str, endNode, mapper, currentValue * child.val, currentStack);
            if (flag)
                return ans;
        }
        return ans;       
    }
    
    Set<String> visited;
    boolean flag;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        visited = new HashSet();     
        HashMap<String, ArrayList<Model>> mapper = new HashMap();  
        double[] ans = new double[queries.size()];
        for (int i =0 ; i< equations.size();i+=1)
        {
            List<String> curr = equations.get(i);
            String num = curr.get(0);
            String denom = curr.get(1);
            if (!mapper.containsKey (num))
            {
                ArrayList<Model> ls = new ArrayList();
                mapper.put (num, ls);
            }
            if (!mapper.containsKey (denom))
            {
                ArrayList<Model> ls = new ArrayList();
                mapper.put (denom, ls);
            }
            Model m1 = new Model (denom, values[i]);
            Model m2 = new Model (num , (double)1.0/values[i]);
            ArrayList<Model> ls1 = mapper.get(num);
            ls1.add (m1);
            ls1 = mapper.get(denom);
            ls1.add (m2);     
        }
        for (int i= 0;  i< queries.size();i+=1)
        {
            flag = false;
            List<String> quer = queries.get(i);
            String num = quer.get(0);
            String denom = quer.get(1);
            visited.clear();
            Set<String> currentStack = new HashSet();
            // dfs
            double product =  dfs (num,denom, mapper,1.0, currentStack);  
            if (!flag)
                ans[i] = -1;
            else
                ans[i] = product;
        }       
        return ans;
    }
}
