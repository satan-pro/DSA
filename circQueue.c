#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

struct queue
{
    int size;
    int count;
    int front;
    int rear;
    int* arr;
};

int isFull(struct queue* q)
{
    if(((q->rear+1)%q->size)==q->front)
    {
        return 1;
    }
    return 0;
}

int isEmpty(struct queue* q)
{
    if(q->count==0)
    {
        return 1;
    }
    return 0;
}

void enqueue(struct queue* q, int data)
{
    if(isFull(q))
    {
        printf("Queue is full...cannot add more\n");
    }
    else
    {
        printf("Not full\n");
        q->arr[q->rear++]=data;
        printf("data entered\n");
        q->count++;
        printf("count increased\n");
    }
}

int dequeue(struct queue* q)
{
    if(isEmpty(q))
    {
        printf("The queue is empty\n");
        return -1;
    }
    else
    {
        q->front = (q->front+1)%q->size;
        int data= q->arr[q->front];
        q->count--;
        return data;
    }
}

void show(struct queue* q)
{
   for(int i=q->front; i<q->rear; i++)
     {
       printf("%d ",q->arr[i]);
     }
}

int main()
{
    int n;
    struct queue* q = (struct queue*)malloc(sizeof(struct queue));
    printf("Enter the size of the array\n");
    scanf("%d", &n);
    q->size = n;
    q->front = -1;
    q->rear = 0;
    q->count=0;
    q->arr = (int*)malloc(q->size*sizeof(int));
    char ch;
    int opt, data;
    do
        {
        printf("Enter your choice\n 1.Enqueue\n 2.Dequeue\n");
        scanf("%d",&opt);
        switch(opt)
        {
            case 1 : printf("Enter data to enter\n");
                    scanf("%d",&data);
                    enqueue(q, data);
                    show(q);
                    break;
            case 2: printf("The number deleted is %d \n",dequeue(q));
                    show(q);
                    break;
        }
        printf("Do you want to continue? (y/n)\n");
        ch = getch();
        }while(ch=='y');
    return 0;
}