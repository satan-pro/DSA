#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int data;
    struct Node* left;
    struct Node* right;
};
typedef struct Node* node;

struct Queue
{
    struct Node* value;
    struct Queue* next;
};
typedef struct Queue* queue;

int isEmpty(queue front, queue rear)
{
    if(front==NULL && rear==NULL)
    {
        return 1;
    }
    return 0;
}

void insertq(queue* front, queue* rear, node root)
{
    queue q = (queue)malloc(sizeof(struct Queue));
    q->next=NULL;
    q->value=root;
    
    if((*rear)==NULL)
    {
        *rear = q;
        *front = *rear;
    }
    else{
        (*rear)->next=q;
        *rear=q;
    }
}

node deleteq(queue* front, queue* rear)
{
    if(*front==NULL)
    {
        return NULL;
    }
    queue temp = *front;
    node delNode = temp->value;
    if((*front)->next==NULL)
    {
        *front=NULL;
        *rear = *front;
    }
    else{
        *front = (*front)->next;
    }
    free(temp);
    return delNode;
}

node createNode(int data)
{
    node new = (node)malloc(sizeof(struct Node));
    new->data = data;
    new->left = NULL;
    new->right = NULL;
    return new;
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

void levelorder(node root)
{
    queue front = NULL;
    queue rear = NULL;
    insertq(&front,&rear,root);

    while(!isEmpty(front,rear))
    {
        node temp = deleteq(&front,&rear);
        printf("%d ",temp->data);
        if(temp->left)
        {
            insertq(&front,&rear,temp->left);
        }
        if(temp->right)
        {
            insertq(&front,&rear,temp->right);
        }
    }

}

void inorder(node root)
{
    if(root!=NULL)
    {
        inorder(root->left);
        printf("%d ",root->data);
        inorder(root->right);
    }
}

int search(node root, int key)
{
    static int flag=0;
    if(root)
    {
        if(root->data==key)
        {
            flag=key;
            return 999;
        }
        if(flag==0)
        {
            search(root->left,key);
        }
        if(flag==0)
        {
            search(root->right,key);
        }
    }
    // return flag;
}

node copy(node root)
{
    node temp;
    if(root)
    {
        temp = createNode(root->data);
        temp->left = copy(root->left);
        temp->right  = copy(root->right);
        
    }
}

int countleaf(node root)
{
    static int count=0;
    if(root)
    {
        if(root->left==NULL && root->right==NULL)
        {
            count++;
        }
        countleaf(root->left);
        countleaf(root->right);
    }
    return count;
}

int countnodes(node root)
{
    static int count=0;
    if(root)
    {
        count++;
        countnodes(root->left);
        countnodes(root->right);
    }
    return count;
}

int main()
{
    node root = (node)malloc(sizeof(struct Node));
    root=NULL;
    int flag=1;
    int d;
    while(flag)
    {
        printf("Enter root data <-1 to terminate> : ");
        scanf("%d", &d);
        if(d==-1)
        {
            flag=0;
            continue;
        }
        root = createTree(root,d);
    }
    levelorder(root);
    //inorder(root);
    /* int searchRes = search(root,7);
    if(searchRes==0)
    {
        printf("Not found");
    }
    else{
        printf("%d ",searchRes);
    }

    node temp  =copy(root);
    inorder(temp); */
    return 0;
}
