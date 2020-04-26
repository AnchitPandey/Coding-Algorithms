/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class maximumBinaryTree {
    
    public void quick (TreeNode par, int[] nums, int lowerIndex, int upperIndex, char ch)
    {
      
        if (lowerIndex >= upperIndex)
        {
         //   System.out.println("breaking");
            return;
        }
            int max = Integer.MIN_VALUE;
        int curr = -1;
        // finding max element
        for (int i = lowerIndex; i< upperIndex;i+=1)
        {
            if (nums[i] > max)
            {
                max = nums[i];
                curr = i;
            }             
         }
        // System.out.println("max element is "+ max);
        // System.out.println("max element at index "+ curr);
        TreeNode child = new TreeNode (max);
        if (ch == 'l')
            par.left = child;
        else if (ch =='r')
            par.right = child; 
        // call recursively for left
        quick (child, nums,lowerIndex, curr,'l');
         // call recursively for right
        quick (child, nums,curr+1, upperIndex, 'r');
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
    if (nums.length ==0)
        return null;
    int max = Integer.MIN_VALUE;
    int curr=  -1;
        
    for (int i= 0 ; i< nums.length;i+=1)
    {
        if (nums[i] > max)
        {
            max = nums[i];
            curr = i;
        }
    }  
    // System.out.println("current max is at index "+ curr);
    // System.out.println("current max is"+ max);
        
    TreeNode root = new TreeNode (max);
    quick (root, nums, 0, curr, 'l');
    quick(root, nums, curr+1, nums.length, 'r');
    return root;
    }
}

