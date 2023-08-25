#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

struct Node
{
    int data;
    struct Node* next;
};

void push(struct Node** head, int data)
{
    struct Node* new = (struct Node*) malloc(sizeof(struct Node));
    new->data = data;
    new->next = *head;
    *head = new;
}

int pop(struct Node** head)
{

   /*  int n = (*head)->data;
    *head = (*head)->next;
    return n; */
    struct Node* ptr = *head;
    int n = ptr->data;
    *head = (*head)->next;
    free(ptr);
    return n;
}

void peek(struct Node* head)
{
    printf("The number peeked is %d\n", head->data);
}

void show(struct Node** head)
{
    printf("Printing stack\n");
    struct Node* ptr = *head;
    while(ptr->next!=NULL)
    {
        printf("%d ", ptr->data);
        ptr=ptr->next;
    }
    printf("%d\n", ptr->data);
}

int main()
{
    struct Node* head = (struct Node*)malloc(sizeof(struct Node*));
    head = NULL;
    char ch;
    int opt, n;
    do
    {
        printf("Enter your choice\n1.Push\n2.Pop\n3.Peek\n");
        scanf("%d", &opt);
        switch (opt)    
        {
        case 1: printf("Enter the value you want to enter\n");
                scanf("%d", &n);
                push(&head, n);
                show(&head);
            break;

        case 2: printf("The value popped is %d\n", pop(&head));
                show(&head);
                break;

        case 3: peek(head);
                show(&head);
                break;
        }
        printf("Do you want to continue? (y/n)\n");
        ch = getch();
    } while (ch=='y');
    return 0;
}