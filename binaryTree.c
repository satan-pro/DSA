#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

struct Node
{
    int data;
    struct Node* left;
    struct Node* right;
};
typedef struct Node* node;

node createNode(int data)
{
    node p = (node)malloc(sizeof(struct Node));
    p->data = data;
    p->left=NULL;
    p->right=NULL;
    return p;
}

node completeBinaryTree(int start, int size)
{
    node root = NULL;
    int n;
    printf("Enter node data\n");
    scanf("%d", &n);
    root = createNode(n);

    int left = 2*start+1;
    int right = 2*start+2;

    if(left<size)
    {
        root->left = completeBinaryTree(left, size);
    }
    if(right<size)
    {
        root->right = completeBinaryTree(right, size);
    }
    return root;
}

node simpleBinaryTree(node root, int data)
{
    if(root==NULL)
    {
        root = createNode(data);
    }
    else
    {
        if(root->left == NULL)
        {
            root->left = simpleBinaryTree(root->left, data);
            printf("Inserted at left node\n");
        }
        else
        {
            root->right = simpleBinaryTree(root->right, data);
            printf("Inserted at right node\n");
        }
    }
    return root;
}

void preorder(node root)
{
    if(root!=NULL)
    {
        printf("%d ", root->data);
        preorder(root->left);
        preorder(root->right);
    }
}

void postorder(node root)
{
    if(root!=NULL)
    {
        postorder(root->left);
        postorder(root->right);
        printf("%d ", root->data);
    }
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
    int size,n;
    char ch;
    printf("Enter the size of the tree\n");
    scanf("%d", &size);

    node root = (node)malloc(sizeof(struct Node));
    root = NULL;
    do
    {
        printf("Enter the data\n");
        scanf("%d", &n);
        root = simpleBinaryTree(root, n);
        printf("Do you want to enter more? (y/n)\n");
        ch = getch();

    } while (ch=='y');
    
   
    preorder(root);
    printf("\n");
    postorder(root);
    printf("\n");
    inorder(root);
    return 0;
}
