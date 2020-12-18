/**
 * Definition for a Node.
 * struct Node {
 *     int val;
 *     Node *left;
 *     Node *right;
 *     Node *random;
 *     Node() : val(0), left(nullptr), right(nullptr), random(nullptr) {}
 *     Node(int x) : val(x), left(nullptr), right(nullptr), random(nullptr) {}
 *     Node(int x, Node *left, Node *right, Node *random) : val(x), left(left), right(right), random(random) {}
 * };
 */

class Solution {
public:
    NodeCopy* copyRandomBinaryTree(Node* root) {
      if (root == NULL)
          return NULL;
        
      map<Node*, NodeCopy*> mapper;
      queue<Node*> qu1;
      queue<NodeCopy*> qu2;
      NodeCopy* rootDup(new NodeCopy(root->val));
      mapper[root] = rootDup;
      qu1.push (root);
        qu2.push (rootDup);
        while (!qu1.empty())
        {
            Node* curr = qu1.front();
            qu1.pop();
            NodeCopy* currDup = qu2.front ();
            qu2.pop();
            if (curr->left != NULL)
            {
                NodeCopy* leftChild (new NodeCopy (curr->left->val));
                mapper[curr->left] = leftChild;
                currDup->left = leftChild;
                qu1.push (curr->left);
                qu2.push(leftChild);  
            }
            if (curr->right != NULL)
            {
                NodeCopy* rightChild (new NodeCopy (curr->right->val));
                mapper[curr->right] = rightChild;
                currDup->right = rightChild;
                qu1.push (curr->right);
                qu2.push(rightChild);  
            }
        }
        qu1.push (root);
        qu2.push (rootDup);
        while (!qu1.empty())
        {
            Node* curr = qu1.front();
            qu1.pop();
            Node* randomptr = curr->random;
            NodeCopy* currEq = mapper [curr];
            NodeCopy* randomEq = mapper [randomptr];
            currEq->random = randomEq;
            if (curr->left != NULL)
                qu1.push (curr->left);            
            if (curr->right != NULL)
                qu1.push (curr->right);                        
        }
        return rootDup;
    }
};
