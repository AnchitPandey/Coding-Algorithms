class Solution {
    
    
    public int findHCF (int num, int denom)
    {
        num = Math.abs (num);
        denom = Math.abs (denom);
        int x = Integer.min(num, denom);
        int hcf = 1;
    //    System.out.println("min is " + x);
        for (int i = x; i>= 2;i--)
        {
           // System.out.println("inside here");
            if (num % i ==0 && denom % i == 0)
            {
                hcf = i;
                break;
            }        
        }
        return hcf;
    }
    public String fractionAddition(String expression) {
        
        ArrayList<Integer> num = new ArrayList<Integer>();
        ArrayList<Integer> denom = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder ();
        char sign = '.';
        
        for (int i =0; i < expression.length();i+=1)
        {
            if (expression.charAt(i) == '/')
            {
                int nume = Integer.parseInt (sb.toString());
                if (sign =='-' )
                    nume = -nume;
                num.add  (nume);
                sb = new StringBuilder ();
            }
            
            else if  (expression.charAt(i) =='-' || expression.charAt(i) == '+')
            {
                sign = expression.charAt (i);
                if (sb.length() !=0)
                {
                    int denomi = Integer.parseInt (sb.toString());
                    denom.add (denomi);
                    sb = new StringBuilder();
                }
            }
            else
                sb.append (expression.charAt(i));
        }
        
        int denomi = Integer.parseInt (sb.toString());
        denom.add (denomi); 
        int prod =  1;
       for (int i =0; i< denom.size();i+=1)
            prod *=  denom.get(i);        
        
        int total =0 ;
    
        for (int i =0; i < num.size();i+=1)
        {
            total += num.get(i)*(prod / denom.get(i));         
        }
        if (total == 0)
            return "0/1";
        
        int x = findHCF (total, prod);
        int newNum = total / x;
        int newDenom = prod  / x;
        if (newDenom < 0)
        {
            newNum = -newNum;
            newDenom = -newDenom;
        }
            String fa  = newNum +"/"+newDenom;
        return fa;
    }
}
