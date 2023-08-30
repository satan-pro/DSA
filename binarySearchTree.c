#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

struct Node
{
    int data;
    struct Node *left;
    struct Node *right;
};

typedef struct Node *node;

node createNode(int data)
{
    node new = (node)malloc(sizeof(struct Node));
    new->data = data;
    new->left = NULL;
    new->right = NULL;
    return new;
}

int isBST(node root)
{
    node prev = (node)malloc(sizeof(struct Node));
    if (root != NULL)
    {
        if (!isBST(root->left))
        {
            return 0;
        }
        if (prev != NULL && root->data <= prev->data)
        {
            return 0;
        }
        prev = root;
        return isBST(root->right);
    }
    else
    {
        return 1;
    }
}

node search(node root, int key)
{
    if (root == NULL)
    {
        return NULL;
    }
    if (root->data == key)
    {
        return root;
    }
    else if (root->data > key)
    {
        return search(root->left, key);
    }
    else
    {
        return search(root->right, key);
    }
}

node searchIter(node root, int key)
{
    while (root != NULL)
    {
        if (root->data == key)
        {
            return root;
        }
        else if (root->data > key)
        {
            root = root->left;
        }
        else
        {
            root = root->right;
        }
    }
    return NULL;
}

void insert(node root, int key)
{
    node prev;
    while (root != NULL)
    {
        prev = root;
        if (root->data == key)
        {
            return;
        }
        else if (key < root->data)
        {
            root = root->left;
        }
        else
        {
            root = root->right;
        }
    }
    node new = createNode(key);
    if (key < prev->data)
    {
        prev->left = new;
    }
    else
    {
        prev->right = new;
    }
}

node  inorderPredecessor(node root)
{
    root = root->left;
    while(root->right != NULL)
    {
        root = root->right;
    }
    return root;
}

int minVal(node root)
{
    int min = root->data;
    while(root->left != NULL)
    {
        root = root->left;
        min = root->data;
    }
    return min;
}

node delete(node root, int key)
{
    node temp;
    if(root == NULL)
    {
        return root;
    }
    if(key < root->data)
    {
        root->left = delete(root->left, key);
    }
    else if(key > root->data)
    {
        root->right = delete(root->right, key);
    }
    else
    {
        if(root->right == NULL)
        {
            return root->left;
        }
        else if(root->left == NULL)
        {
            return root->right;
        }
        root->data = minVal(root->right);
        root->right = delete(root->right, root->data);
    }
    return root;
}

void inorder(node root)
{
    if(root!=NULL)
    {
        inorder(root->left);
        printf("%d ", root->data);
        inorder(root->right);
    }
}

int main()
{
    node root = (node)malloc(sizeof(struct Node));
    root = NULL;
    int n, opt;
    char ch;
    printf("Enter the value of first node\n");
    scanf("%d", &n);
    root = createNode(n);
    do
    {
        printf("Enter your choice\n1.Insert Node\n2.Delete Node\n");
        scanf("%d", &opt);
        switch(opt)
        {
            case 1: printf("Enter the value of node\n");
                    scanf("%d", &n);
                    insert(root, n);
                    inorder(root);
                    break;

            case 2: printf("Enter the value of the node you want to delete\n");
                    scanf("%d", &n);
                    delete(root, n);
                    inorder(root);
                    break;
        }
        
        printf("Do you want to enter more? (y/n)\n");
        ch = getch();
    } while (ch == 'y');

    if(isBST(root))
    {
        printf("It is a BST\n");
    }
    else 
    {
        printf("Not a BST\n");
    }
    inorder(root);
}