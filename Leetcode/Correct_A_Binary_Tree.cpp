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
    int repeated = -1;
    unordered_map<TreeNode*,int > umap;
    void dfs1 (TreeNode* curr, int level)
    {  
        if (flag || curr == nullptr)
            return;
        // cout<< "current node is " << curr->val << endl;
        if (umap[curr] !=0)
        {
           // cout << "inside here" << endl;
            umap[curr] = level;
            repeated = curr->val;
            flag = true;
            return;
        }
        umap[curr] = level;
        dfs1(curr->left,  level+1);
        dfs1(curr->right,  level+1);            
    }
    
    void dfs2(TreeNode* curr, TreeNode* parent, char ch)
    {
        if (curr == nullptr || flag)
            return;
        if (curr->right !=nullptr && curr->right->val == repeated && umap[curr] == umap[curr->right])
        {
            if (ch =='L')
                parent->left = NULL;
            else
                parent->right = NULL;
            flag = true;
            return;
        }
        dfs2(curr->left, curr, 'L');
        dfs2 (curr->right, curr,  'R');
        return;    
    }
    
    bool flag = false;    
    TreeNode* correctBinaryTree(TreeNode* root) {
        umap.clear();
        repeated = -1;
        flag = false;
        dfs1(root,1);
        flag = false;
        dfs2(root,root,'L');
        return root;
    }
};
