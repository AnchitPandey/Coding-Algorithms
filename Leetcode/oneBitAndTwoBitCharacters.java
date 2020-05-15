class oneBitAndTwoBitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        boolean flag = false;
        for (int i = 0; i< bits.length;i+=1)
        {
            if (bits[i] == 1)
                i+=1;
            else
            {
                if (i == bits.length-1 && bits[i] ==0)
                    flag = true;
            }
        }
        return flag;
    }
}
