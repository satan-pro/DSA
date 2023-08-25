#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int data;
    struct Node* next;
};

struct Node* insert(struct Node* head, int data)
{
    struct Node* new = (struct Node*)malloc(sizeof(struct Node));
    new->data = data;
    new->next = NULL;
    if(head==NULL)
    {
        head = new;
    }
    else{
        struct Node* n = head;
        while(n->next!=NULL)
        {
            n=n->next;
        }
        n->next=new;
    }
    return head;
}

struct Node* del(struct Node* head, int index)
{
    struct Node* ptr = head;
    struct Node* ptr2 = ptr->next;
    int i=1;
    while(i<index)
    {
        ptr = ptr->next;
        ptr2 = ptr2->next;
        i++;
    }
    ptr->next = ptr2->next;
    free(ptr2);
    return head;
}

void show(struct Node* n)
{
    while(n!=NULL)
    {
        printf("%d ", n->data);
        n=n->next;
    }
}

int main()
{
    struct Node* head;
    head = (struct Node*)malloc(sizeof(struct Node));
    head = NULL;
    int n,ind;
    char ch;
    for(int i=1; i<=5; i++)
    {
        printf("Enter node data\n");
        scanf("%d", &n);
        head = insert(head,n);
    } 
    printf("Which index you do want to delete?\n");
    scanf("%d", &ind);
    head = del(head, ind);
    show(head);
    return 0;
}
