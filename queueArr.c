#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <conio.h>

struct queue
{
  int size;
  int front;
  int rear;
  int* arr;
};

int isEmpty(struct queue* q)
{
   if(q->front>=q->rear)
      return 1;
  return 0;
}

int isFull(struct queue* q)
{
   if(q->front>q->rear || q->rear>=q->size)
      return 1;
   return 0;
}

void enqueue(struct queue* q, int data)
{
    if(!isFull(q))
    {
       q->arr[q->rear++]= data;
    }
    else 
    {
      printf("Queue is full....cannot enter more\n");
    }
}

int dequeue(struct queue* q)
{
   if(!isEmpty(q))
   {
      return q->arr[q->front++];
   }
   else
   {
     printf("Queue is empty cannot dequeue\n");
     return -1;
   }

}

void show(struct queue* q)
{
   for(int i=q->front; i<q->rear; i++)
     {
       printf("%d ",q->arr[i]);
     }
}

int main() {
  //printf("Hello World\n");
  struct queue q;
  int n;
  printf("Enter the size of array\n");
  scanf("%d" , &n);
  printf("%d", n);
  q.size = n;
 /*  printf("%d", q.size); */
  q.arr = (int*)malloc(q.size*sizeof(int));
  q.front = 0;
  q.rear = 0;
  printf("System initiated\n");
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
                enqueue(&q, data);
                show(&q);
                break;
        case 2: printf("The number deleted is %d \n",dequeue(&q));
                show(&q);
                break;
                 
    }
      printf("Do you want to continue? (y/n)\n");
      ch = getch();
    }while(ch=='y');
  return 0;
}