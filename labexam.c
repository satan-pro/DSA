#include <stdio.h>
#include <stdlib.h>

struct Node{
    int data;
    struct Node* left;
    struct Node* right;
};
typedef struct Node* node;

node createNode(int data)
{
    node new = (node)malloc(sizeof(struct Node));
    new->data = data;
    new->left=NULL;
    new->right=NULL;
    return new;
}

node createTreeLeft(node root, int data)
{
    if(root==NULL)
    {
        root=createNode(data);
        return root;
    }
    else if(root->right==NULL)
    {
        root->left = createTreeLeft(root->left, data);
    }
    else if(root->left==NULL)
    {
        root->right = createTreeLeft(root->right, data);
    }
    else{
        root->left = createTreeLeft(root->left, data);
    }
    return root;
}

void display(node root)
{
    if(root)
    {
        display(root->left);
        printf("%d ", root->data);
        display(root->right);
    }
}

int findLargest(node root)
{
    static int max=0;
    if(root)
    {
        if(root->data>max)
        {
            max=root->data;
        }
        max = findLargest(root->left);
        max = findLargest(root->right);
    }
    return max;
}

int countNodes(node root)
{
    static int count=0;
    if(root)
    {
        count++;
        count = countNodes(root->left);
        count = countNodes(root->right);
    }
    return count;
}

int* findnodes(node root, int a[])
{
    static int i=0;
    if(root)
    {
        a[i++]=root->data;
        a=findnodes(root->left,a);
        a=findnodes(root->right, a);
    }
    return a;
}

node createBST(node root, int data)
{
    if(root==NULL)
    {
        root=createNode(data);
        return root;
    }
    else if(root->data>data)
    {
        root->left = createBST(root->left, data);
    }
    else if(root->data<data)
    {
        root->right = createBST(root->right, data);
    }
    else
        return root;
}

int main()
{
    node tree1 = (node)malloc(sizeof(struct Node));
    node tree2 = (node)malloc(sizeof(struct Node));
    node tree3 = (node)malloc(sizeof(struct Node));
    tree2=NULL;
    tree1=NULL;
    tree3=NULL;
    int d;
    int flag=1;
    while(flag)
    {
        printf("Enter data (tree1): ");
        scanf("%d", &d);
        if(d==-1)
        {
            flag=0;
        }
        else
        {
            tree1=createTreeLeft(tree1, d);
        }
    }
    flag=1;
    while(flag)
    {
        printf("Enter data (tree2): ");
        scanf("%d", &d);
        if(d==-1)
        {
            flag=0;
        }
        else
        {
            tree2=createTreeLeft(tree2, d);
        }
    }

    display(tree1);
    int largest = findLargest(tree1);
    printf("Largest : %d", largest);
    int count1 = countNodes(tree1);
    int count2 = countNodes(tree2);
    int* a1 = (int*)malloc(count1*sizeof(int));
    int* a2 = (int*)malloc(count2*sizeof(int));
    a1=findnodes(tree1,a1);
    a2 = findnodes(tree2,a2);
    tree3 = createBST(tree3, largest);
    for(int i=0; i<count1; i++)
    {
        tree3 = createBST(tree3,a1[i]);
    }
    for(int i=0; i<count2; i++)
    {
        tree3 = createBST(tree3,a2[i]);
    }
    display(tree1);
    printf("\n");
    display(tree2);
    printf("\n");
    display(tree3);
    printf("\n");
}