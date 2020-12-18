/**
 * Definition for a binary tree node.
 * struct Node {
 *     char val;
 *     Node *left;
 *     Node *right;
 *     Node() : val(' '), left(nullptr), right(nullptr) {}
 *     Node(char x) : val(x), left(nullptr), right(nullptr) {}
 *     Node(char x, Node *left, Node *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool checkEquivalence(Node* root1, Node* root2) {
        map<char, int> m1, m2;
        queue<Node*> qu;
        qu.push (root1);
        while (!qu.empty())
        {
            Node* curr= qu.front ();
            qu.pop();
            m1[curr->val]+=1;
            if (curr->left != NULL)
                qu.push (curr->left);
            
            if (curr->right != NULL)
                qu.push (curr->right);
        }
        qu.push (root2);
        while (!qu.empty())
        {
            Node* curr= qu.front ();
            qu.pop();
            m2[curr->val]+=1;
            if (curr->left != NULL)
                qu.push (curr->left);
            
            if (curr->right != NULL)
                qu.push (curr->right);
        }
        
        if (m1.size() != m2.size())
            return false;
        
        for (const auto &p: m1)
        {
            if (m2[p.first] != p.second)
                return false;
        }
        return true;
    }
};
