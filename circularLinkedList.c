#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int data;
    struct Node* next;
};

struct Node* insert(int data, struct Node* head)
{
    struct Node* new = (struct Node*)malloc(sizeof(struct Node));
    new->data = data;
    if(head==NULL)
    {
        head=new;
        head->next = head;
    }
    else{
        struct Node* ptr = head;
        while(ptr->next!=head)
        {
            ptr=ptr->next;
        } 
        ptr->next = new;    
        new->next = head;
    }
    return head;
}

void show(struct Node* head)
{
    struct Node* ptr = head;
    do
    {
        printf("%d ", ptr->data);
        ptr=ptr->next;
    }while(ptr!=head);
}

int main()
{
    struct Node* head = (struct Node*)malloc(sizeof(struct Node));
    head = NULL;
    int n;
    for(int i=1; i<=5; i++)
    {
        printf("Enter node data\n");
        scanf("%d", &n);
        head = insert(n,head);
    }
    printf("Displaying the node\n");
    show(head);
}
