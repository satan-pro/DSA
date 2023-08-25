#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

struct stack
{
    int size;
    int top;
    int* arr;
};
typedef struct stack* stackptr;

int isEmpty(stackptr s)
{
    if(s->top>=0)
        return 1;
    else
        return 0;
}

void push(stackptr* s, int data)
{
    if(isEmpty(*s))
    {
        (*s)->arr[--((*s)->top)]=data;
    }
}

int pop(stackptr *s)
{
    if((*s)->top==(*s)->size)
    {
        printf("Stack underflow\n");
        return -1;
    }
    return (*s)->arr[(*s)->top++];
}

int peek(stackptr s)
{
    if(s->top == s->size)
    {
        printf("Stack is empty....Nothing to peek\n");
        return -1;
    }
    return s->arr[s->top];
}

void show(stackptr s)
{
    for(int i=s->top; i<s->size; i++)
    {
        printf("%d ",s->arr[i]);
    }
    printf("\n");
}

int main()
{
    stackptr s;
    int n,opt;
    char ch;
    printf("Enter size of the stack\n");
    scanf("%d", &s->size);
    s->arr = (int*)malloc(s->size*sizeof(int));
    s->top=s->size;
    do
    {
        printf("Choose your operation\n\t1. Push\n\t2. Pop\n\t3. Peek\n");
        scanf("%d",&opt);
        switch(opt)
        {
            case 1: printf("Enter value\n");
                    scanf("%d", &n);
                    if(isEmpty(s)==0)
                    {
                        printf("Sorry stack is full\n");
                    }
                    else
                    {
                        push(&s,n);
                    }
                    show(s);
                    break;
            
            case 2: printf("Number popped from stack : %d\n",pop(&s));
                    show(s);
                    break;

            case 3: printf("Number peeked : %d\n",peek(s));
                    show(s);
                    break;
        }
        printf("Do you want to continue? (y/n)\n");
        ch = getch();
    } while(ch=='y');
    show(s);
}
