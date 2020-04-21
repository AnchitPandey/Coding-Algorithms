class longPressedName {
    
    public boolean isLongPressedName(String name, String typed) {
        
        if (typed.length() < name.length())
            return false;
            
        int pointer1 =0 , prev1 =-1, pointer2 = 0;
        
        while (pointer1 != typed.length() && pointer2 != name.length())
        {
            if (typed.charAt(pointer1) == name.charAt(pointer2))
            {
                pointer1+=1;
                prev1 +=1;
                pointer2+=1;
            }
            else
            {
                if (typed.charAt(pointer1) != name.charAt(pointer2) && prev1!=-1)
                {
                    if (typed.charAt(pointer1) == typed.charAt(prev1))
                    {
                        pointer1+=1;
                        prev1+=1;
                    }
                    else
                        return false;                     
                }
                else
                    return false;
            }     
        }
        
        if (pointer2 < name.length())
            return false;
        
        while (pointer1 < typed.length())
        {
            if (typed.charAt(pointer1) != typed.charAt(prev1))
                return false;
            pointer1+=1;
            prev1+=1;
        }  
        return true;
    }
}
