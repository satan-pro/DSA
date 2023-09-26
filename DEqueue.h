#include <stdio.h>
#include <stdlib.h>

struct QUEUE
{
    int size;
    int front;
    int rear;
    int* arr;
};

typedef struct QUEUE* queue;

int isEmpty(queue q)
{
    if(q->front==q->rear)
    {
        return 1;
    }
    return 0;
}

int isFull(queue q)
{
    if((q->rear+1)%q->size==q->front)
    {
        return 1;
    }
    return 0;
}

void insertF(queue q, int data)
{
    if(!isFull(q))
    {
        q->front=(q->front-1)%q->size;
        q->arr[q->front]=data;
    }
}

void insertR(queue q, int data)
{
    if(!isFull(q))
    {
        q->rear=(q->rear+1)%q->size;
        q->arr[q->rear]=data;
    }
}

void deleteF(queue q)
{
    if(!isEmpty(q))
    {
        int data = q->arr[q->front];
        q->front = (q->front+1)%q->size;
        printf("Data removed : %d\n",data);
    }
}

void deleteR(queue q)
{
    if(!isEmpty(q))
    {
        int data = q->arr[q->rear];
        q->rear =(q->rear-1)%q->size;
        printf("Data Removed : %d\n",data);
    }
}
