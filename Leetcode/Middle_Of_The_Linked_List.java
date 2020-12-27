/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {

       int len=0 ;
       ListNode temp = head;
       while (temp != null)
       {
           len+=1;
           temp = temp.next;
       }
        len = len/2 +1;
        temp = head;
        while (temp != null)
        {
            len -=1;
            if (len ==0)
                return temp;
            temp = temp.next;
        }
        return null;
    }
}
