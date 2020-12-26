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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Solution {
    boolean found;
   
    public void StartPatternMatching (ListNode travel, TreeNode curr)
    {
        if (travel.next == null)
        {
            found = true;
            return;
        }
        if (curr.left != null)
        {
            if (travel.next.val == curr.left.val)
                StartPatternMatching (travel.next, curr.left);
        }
        if (curr.right != null)
        {
            if (travel.next.val == curr.right.val)
                StartPatternMatching (travel.next, curr.right);
        }
        return;
    }
    
    public void dfs (ListNode temp, TreeNode curr)
    {
    
         if (curr == null || found)
             return;
         if (curr.val == temp.val)
         {
             ListNode travel = temp;
             StartPatternMatching (travel, curr);
         }
         if (curr.left != null)  
             dfs (temp, curr.left);
         
         if (curr.right != null)
             dfs (temp, curr.right);
        return;
    }
    
    public boolean isSubPath(ListNode head, TreeNode root) {
        found = false;
        dfs (head,root);     
        return found;
    }
    
}
