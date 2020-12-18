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
class FindElements {
    
    map<int, int> mapper;
public:
    FindElements(TreeNode* root) {
        root->val =0;
        mapper[root->val] =1;
        queue<TreeNode*> qu;
        qu.push (root);
        while (!qu.empty())
        {
            TreeNode* curr = qu.front();
            qu.pop();
            if (curr->left != NULL)
            {
                curr->left->val = curr->val * 2+1;
                qu.push (curr->left);
                mapper[curr->left->val] = 1;
            }
            if (curr->right != NULL)
            {
                curr->right->val = curr->val * 2+2;
                qu.push (curr->right);
                mapper[curr->right->val] = 1;
            }    
        }
    }
    
    bool find(int target) {
        if (mapper[target] ==1)
            return true;
        return false;
    }
};

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements* obj = new FindElements(root);
 * bool param_1 = obj->find(target);
 */
