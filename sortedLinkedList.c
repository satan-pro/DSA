#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int data;
    struct Node* next;
};

typedef struct Node* node;

node insertNode(node head, int data)
{
    node new = (node)malloc(sizeof(struct Node));
    new->data = data;
    new->next=NULL;
    if(head==NULL)
    {
        head=new;
        return head;
    }
    else if(new->data<=head->data)
    {
        new->next=head;
        head=new;
        return head;
    }
    else{
        node ptr =head;
        node ptr2 = ptr->next;
        while(ptr->next!=NULL)
        {
            if(new->data<ptr2->data)
            {
                ptr->next=new;
                new->next=ptr2;
                return head;
            }
            ptr=ptr->next;
            ptr2=ptr2->next;
        }
        ptr->next=new;
    }
    return head;
}

node delAtIndex(node head, int index)
{
    node ptr = head;
    node ptr2 = ptr->next;
    int i=1;
    while(i<index-1)
    {
        ptr=ptr->next;
        ptr2=ptr2->next;
        i++;
    }
    ptr->next = ptr2->next;
    free(ptr2);
    return head;
}

node delByValue(node head, int val)
{
    node ptr=head;
    node ptr2=ptr->next;
    while(ptr->next!=NULL)
    {
        if(ptr2->data==val)
        {
            ptr->next = ptr2->next;
            free(ptr2);
        }
        ptr=ptr->next;
        ptr2=ptr2->next;
    }
    return head;
}

node delHead(node head)
{
    node n = head;
    head = head->next;
    free(n);
    return head;
}

void show(node head)
{
    node ptr = head;
    while(ptr!=NULL)
    {
        printf("%d ",ptr->data);
        ptr=ptr->next;
    }
    printf("\n");
}

int main()
{
    node head = (node)malloc(sizeof(struct Node));
    head=NULL;
    int flag=1;
    while(flag)
    {
        int ch,data;
        printf("Enter your choice\n1.Add Node\n2.Delete at Index\n3.Delete By Value\n4.Delete Head\n");
        scanf("%d",&ch);
        switch(ch)
        {
            case 1: printf("Enter your data : ");
                    scanf("%d",&data);
                    head=insertNode(head,data);
                    show(head);
                    break;

            case 2: printf("Enter the index at which you want to delete : ");
                    scanf("%d",&data);
                    head=delAtIndex(head,data);
                    show(head);
                    break;

            case 3: printf("Enter the value you want to delete : ");
                    scanf("%d",&data);
                    head=delByValue(head,data);
                    show(head);
                    break;

            case 4: head=delHead(head);
                    show(head);
                    break;

            default: flag=0;
        }
    }
    return 0;
}
