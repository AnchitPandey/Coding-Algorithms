/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


class Solution {
    public int[] nextLargerNodes(ListNode head) {
    
        if (head == null)
        {
            int[] tt = new int[0];
            return tt;
        }
        int len = 0;
        ListNode temp = head;
        while (temp != null)
        {
            len+=1;
            temp = temp.next;
        }
        
        int[] arr = new int[len];
        int index= 0;
        temp = head;
        
        while (temp != null)
        {
            arr[index] = temp.val;
            temp = temp.next;
            index+=1;
        } 
       
        Stack<Integer> st = new Stack<Integer>();
        st.push (0);
        int[] par = new int[len];
        for (int i =1; i < len; i+=1)
        {
            while (!st.isEmpty() && arr[i] > arr[st.peek()])
            {
                int ind = st.pop();
                par[ind]= i;
            }
            st.push (i);
        }
        while (!st.isEmpty())
        {
            int ind = st.pop();
            par[ind] = -1;
        }
        for (int i =0 ;i< len;i+=1)
        {
            if (par[i]==-1)
                par[i] =0;
            else
            par[i] = arr[par[i]]; 
        }
        return par;
    }
}
