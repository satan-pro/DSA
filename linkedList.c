#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int data;
    struct Node* next;
};

void insert(int data, struct Node** head)
{
    struct Node* new = (struct Node*)malloc(sizeof(struct Node));
    new->data = data;
    new->next = NULL;
    if(*head==NULL)
    {
        *head = new;
        return;
    }
    else{
        struct Node* n = *head;
        while(n->next != NULL)
        {
            n = n->next;
        }
        n->next = new;
    }
}

void del(struct Node** head, int index)
{
    if(index>5)
    {
        printf("High index....Program terminated\n");
        return;
    }
    struct Node* p = *head;
    struct Node* q = p->next;
    int i=1;
    while(i<index)
    {
        p = p->next;
        q = q->next;
        i++;
    }
    p->next = q->next;
    free(q);
    printf("node deleted\n");
    return;
}

void show(struct Node** head)
{
    struct Node* n = *head;
    while(n->next != NULL)
    {
        printf("%d ", n->data);
        n = n->next;
    }
    printf("%d\n", n->data);
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
        printf("Enter Node data\n");
        scanf("%d", &n);
        insert(n,&head);
    }
    printf("Displaying the linked List\n");
    del(&head, 2);
    show(&head);
    printf("Do you want to delete a node?\n");
    if((ch=getchar())=='y')
    {
        printf("Which index you do want to delete?\n");
        scanf("%d", &ind);
        
    }
    else{
        printf("Program terminated\n");
    }
    show(&head);
    return 0;
}