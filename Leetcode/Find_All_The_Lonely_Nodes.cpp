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
class Solution {
public:
    vector<int> getLonelyNodes(TreeNode* root) {
    
        vector<int> vec;
        queue<TreeNode*> qu;
        qu.push (root);
        while (!qu.empty())
        {
            TreeNode* curr = qu.front();
            qu.pop();
            if (curr->left == NULL && curr->right != NULL)
                vec.push_back(curr->right->val);
            
            else if (curr->left != NULL && curr->right == NULL)
                vec.push_back(curr->left->val);
            
            if (curr->left != NULL)
                qu.push (curr->left);
            
        if (curr->right != NULL)
                qu.push (curr->right);
        }
                
    return vec;                
    }
};
