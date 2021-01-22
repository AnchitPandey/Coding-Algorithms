/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

//#include <algorithm>

class Solution {
    
public:
    
     void dfs (TreeNode* curr, int currHeight){
          if (curr->left == NULL && curr->right == NULL)
          {
              maxi = max (maxi, currHeight);
              return;
          }
          if (curr -> left != NULL)
              dfs (curr->left, currHeight+1);
          if (curr->right != NULL)
              dfs (curr->right, currHeight+1);
         return;
    }
    void dfsAgain (TreeNode* curr, int height)
    {
        if (curr->left == NULL && curr->right == NULL)
        {
            if (height == maxi)
                sum += curr->val;
        }
        if (curr->left != NULL)
            dfsAgain (curr->left, height+1);     
        
        if (curr->right != NULL)
              dfsAgain (curr->right, height+1);               
        return;      
    }
    int maxi =0, sum =0 ;
    int deepestLeavesSum(TreeNode* root) {
        maxi =0;
        sum =0;
        dfs (root,0);           
        dfsAgain (root,0);
        return sum;
    }
};
