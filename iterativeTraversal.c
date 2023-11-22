#include <stdio.h>
#include <stdlib.h>
#include "stackll.h"

struct Node
{
    int data;
    int visited;
    struct Node* left;
    struct Node* right;
};
typedef struct Node* node;

node createNode(int data)
{
    node newNode = (node)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->visited=0;
    newNode->left = NULL;
    newNode->right= NULL;
    return newNode;
}

node createTree(node root, int data)
{
    node temp = root;
    if(root==NULL)
    {
        root=createNode(data);
        //return root;
        //printf("Data entered into root Node");
    }
    else if(root->left==NULL)
    {
         root->left = createTree(root->left, data);
    }
    else if(root->right==NULL)
    {
        root->right = createTree(root->right, data);
    }
        //printf("%d\n",root->data);
    else{
        root->left = createTree(root->left, data);
    }
    return root;
}

void inorder(node root)
{
    if(root)
    {
        inorder(root->left);
        printf("%d ", root->data);
        inorder(root->right);
    }
}

void iterativeInorder(node root)
{
    struct StackNode* head = (struct StackNode*)malloc(sizeof(struct StackNode));
    head=NULL;
    if(root==NULL)
    {
        printf("Tree is empty\n");
    }
    node curr = root;
    int flag=1;
    while(flag)
    {
        while(curr)
        {
            push(&head, curr);
            curr=curr->left;
        }
        if(head!=NULL)
        {
            curr = pop(&head);
            printf("%d ",curr->data);
            curr= curr->right;
        }
        else{
            flag=0;
        }
    }
}

void iterativePreorder(node root)
{
    struct StackNode* head = (struct StackNode*)malloc(sizeof(struct StackNode));
    head = NULL;
    if(root==NULL)
    {
        printf("Tree is empty\n");
    }
    int flag=1;
    node curr = root;
    while(flag)
    {
        while(curr!=NULL)
        {
            push(&head, curr);
            printf("%d ", curr->data);
            curr=curr->left;
        }
        if(head!=NULL)
        {
            curr = pop(&head);
            curr = curr->right;
        }
        else{
            flag=0;
        }
    }
}

void iterativePostorder(node root)
{
    struct StackNode* head = (struct StackNode*)malloc(sizeof(struct StackNode));
    head=NULL;
    if(root==NULL)
    {
        printf("Tree is empty\n");
    }
    node curr = root;
    int flag=1;
    while(flag)
    {
        while(curr)
        {
            push(&head, curr);
            //printf("Pushed : %d\n",curr->data);
            if(curr->left==NULL)
            {
                curr=curr->right;
            }
            else{
                curr=curr->left; 
            }
        }
        if(head!=NULL)
        {
           curr = pop(&head);
           if(curr->visited>0)
           {
                printf("%d ", curr->data);
                curr = pop(&head);
           }
           if(curr->visited==0)
           {
                if(curr->right)
                {
                    curr->visited=1;
                    push(&head, curr);
                    curr=curr->right;
                }
                else{
                    printf("%d ", curr->data);
                    curr=curr->right;
                }
           }
        }
        else
        {
            flag=0;
        }
    }
}

int main()
{
    int d=0;
    node root = (node)malloc(sizeof(struct Node));
    root=NULL;
    node tracker = root;
    while(d!=-1){
    
        printf("Enter data : ");
        scanf("%d", &d);
        //printf("Data entered %d",d);
        if(d!=-1)
        {
             root = createTree(root,d);
        }
    }
    //printf("%d %d %d\n", root->data, root->left->data, root->right->data);
    iterativeInorder(root);
    printf("\n");
    iterativePreorder(root);
    printf("\n");
    iterativePostorder(root);
    printf("\n");
    return 0;
}