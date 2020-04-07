/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    static int max;
    
    public static void calldfs (TreeNode parentNode, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap)
    {
        minHeap.add (parentNode.val);
        maxHeap.add (parentNode.val);
        if (parentNode.left == null && parentNode.right == null)
        {
            if (maxHeap.peek() - minHeap.peek() > max)
                max = maxHeap.peek () - minHeap.peek ();
            
            minHeap.remove (parentNode.val);
            maxHeap.remove (parentNode.val);

        }
        if (parentNode.left != null)
            calldfs (parentNode.left, minHeap, maxHeap);
        
        if (parentNode.right != null)
            calldfs (parentNode.right, minHeap, maxHeap);

         minHeap.remove (parentNode.val);
         maxHeap.remove (parentNode.val);
    }
        
        
    public int maxAncestorDiff(TreeNode root) {

        max = Integer.MIN_VALUE;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        calldfs (root, minHeap, maxHeap);        
        return max;
    }
}
