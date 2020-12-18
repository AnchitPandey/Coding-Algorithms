/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
public:
    Node* cloneTree(Node* root) {
    
    if(root == NULL)
            return NULL;
     map<Node*,Node*> mapper;
     queue<Node*> qu1, qu2;
     qu1.push (root);
     Node* dupRoot(new Node(root->val)); 
     //dupRoot->val = root->val;
     //map[root] = dupRoot;
     qu2.push (dupRoot);
     while (!qu1.empty())
     {
         Node* curr =qu1.front ();
         qu1.pop();
         Node* currDup = qu2.front();
         qu2.pop();
         for (int i =0 ; i< curr->children.size();i+=1)
         {
            Node* child = curr->children[i];
            
            Node* childDup(new Node(child->val));
            //childDup->val = child->val;
            qu1.push (child);
            currDup->children.push_back (childDup);
            qu2.push (childDup);
            //map[child] = childDup;            
         }        
     }
     return dupRoot;       
    }
};
