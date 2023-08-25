#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <conio.h>

struct Node
{
    int data;
    struct Node* next;
};

typedef struct Node* Node;

int isEmpty(Node head, Node last)
{
    if(head==NULL && last==NULL)
    {
        return 1;
    }
    return 0;
}

void enqueue(Node* head, Node* last, int data)
{
    Node new = (Node)malloc(sizeof(struct Node));
    new->data=data;
    new->next=NULL;

    if(*head==NULL)
    {
        (*head) = new;
        *last = *head;
    }
    else
    {
         (*last)->next=new;
         *last=new;
    }
}

int dequeue(Node* head, Node* last)
{
    if(isEmpty(*head, *last))
    {
        return -1;
    }
    int val = (*head)->data;
    if((*head)->next==NULL)
    {
        *head=NULL;
        *last=*head;
    }
    else
    {
        *head = (*head)->next;
    }
    return val;
}

void show(Node head)
{
    Node n = head;
    while(n!=NULL)
    {
        printf("%d ", n->data);
        n=n->next;
    }
    printf("\n");
}

int main()
{
    Node head = (Node)malloc(sizeof(struct Node));
    head = NULL;
    Node last = (Node)malloc(sizeof(struct Node));
    last = NULL;
    char ch;
    int opt, data, res;
    do
        {
        printf("Enter your choice\n 1.Enqueue\n 2.Dequeue\n");
        scanf("%d",&opt);
        switch(opt)
        {
            case 1 : printf("Enter data to enter\n");
                    scanf("%d",&data);
                    enqueue(&head, &last, data);
                    show(head);
                    break;
            case 2: res = dequeue(&head, &last);
                    if(res==-1)
                    {
                        printf("Queue Underflow....Cannot delete\n");
                        break;
                    }
                    printf("The number deleted is %d \n",res);
                    show(head);
                    break;
        }
        printf("Do you want to continue? (y/n)\n");
        ch = getch();
        }while(ch=='y');
    return 0;
}