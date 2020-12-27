/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
     
        ListNode tail = list2;
        while (tail.next != null)
            tail = tail.next;
        ListNode temp = list1, prev = null;
        int counter =-1;
        ListNode newHead =null;
        while (temp != null)
        {
            counter+=1;
            if(counter == a)
                newHead = prev;
            
            if (counter ==b) {
                tail.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        if  (newHead == null)
            return list2;
        newHead.next = list2;
        return list1;
    }
}
