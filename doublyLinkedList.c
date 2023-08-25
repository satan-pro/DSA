#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>
#include <ctype.h>

struct Node
{
    int data;
    struct Node* prev;
    struct Node* next;
};

struct Node* insert(struct Node* head, int data)
{
    struct Node* new = (struct Node*)malloc(sizeof(struct Node));
    new->data = data;
    if(head==NULL)
    {
        head = new;
        head->next = NULL;
        head->prev = NULL;
    }
    else
    {
        struct Node* ptr = head;
        while(ptr->next!=NULL)
        {
            ptr=ptr->next;
        }
        ptr->next=new;
        new->next=NULL;
        new->prev=ptr;
    }
    return head;
    
}

void show(struct Node* ptr)
{
    printf("Printing the linked list from front\n");
    while(ptr->next!=NULL)
    {
        printf("%d ",ptr->data);
        ptr=ptr->next;
    }
    printf("%d\n",ptr->data);
    printf("Printing the linked list in reverse\n");
    do
    {
        printf("%d ",ptr->data);
        ptr=ptr->prev;
    } while (ptr!=NULL);
}

int main()
{
    struct Node* head = (struct Node*)malloc(sizeof(struct Node));
    head=NULL;
    int n;
    char ch;
    do
    {
        printf("Enter Node data\n");
        scanf("%d", &n);
        head=insert(head,n);
        printf("Do you want to insert more ? (y/n)\n");
        ch = getch();
    } while (ch=='y');
    
    show(head);
}