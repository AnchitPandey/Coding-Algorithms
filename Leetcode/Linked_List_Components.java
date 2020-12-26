/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        HashMap<Integer, Integer> mapper = new HashMap<Integer, Integer> ();
        for (int i=0;i< G.length;i+=1)
            mapper.put (G[i],1);
        ListNode temp = head;
        boolean prev = false;
        int sum  =0;
        while (temp != null)
        {
            if(prev)
            {
                if (!mapper.containsKey (temp.val))
                    prev = false;
            }           
            else
            {
                if (mapper.containsKey (temp.val))
                {
                    prev = true;
                    sum +=1;
                }
                else
                    prev = false;
            }
            temp = temp.next;     
        }
    return sum;
    }
}
