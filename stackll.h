#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

struct StackNode
{
    struct Node* data;
    struct StackNode* next;
};

void push(struct StackNode** head, struct Node* data)
{
    struct StackNode* newNode = (struct StackNode*) malloc(sizeof(struct StackNode));
    newNode->data = data;
    newNode->next = *head;
    *head = newNode;
}

struct Node* pop(struct StackNode** head)
{

   /*  int n = (*head)->data;
    *head = (*head)->next;
    return n; */
    struct StackNode* ptr = *head;
    struct Node* n = ptr->data;
    *head = (*head)->next;
    free(ptr);
    return n;
}

struct Node* peek(struct StackNode* head)
{
    return head->data;
}

/*void show(struct StackNode** head)
{
    printf("Printing stack\n");
    struct StackNode* ptr = *head;
    while(ptr->next!=NULL)
    {
        printf("%d ", ptr->data);
        ptr=ptr->next;
    }
    printf("%d\n", ptr->data);
}

int main()
{
    struct StackNode* head = (struct StackNode*)malloc(sizeof(struct StackNode*));
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
} */