#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int data;
    int height;
    struct Node* left;
    struct Node* right;
};

typedef struct Node* node;

int getHeight(node root)
{
    if(root == NULL)
    {
        return 0;
    }
    return root->height;
}

node createNode(int data)
{
    node n = (node)malloc(sizeof(struct Node));
    n->data = data;
    n->left = NULL;
    n->right = NULL;
    n->height = 1;

    return n;
}

int getBalanceFactor(node root)
{
    if(root==NULL)
    {
        return 0;
    }
    return getHeight(root->left)-getHeight(root->right);
}

node rightRotate(node y)
{
    node x = y->left;
    node T2 = x->right;
    
    x->right = y;
    y->left = T2;

    y->height = max(getHeight(y->left), getHeight(y->right)) +1;
    x->height = max(getHeight(x->left), getHeight(x->right)) +1;
    
}
