#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>

struct stack
{
    int size;
    int top;
    char* arr;
};
typedef struct stack* stackptr;

int isEmpty(struct stack* s)
{
    if(s->top==0)
    {
        return 1;
    }
    return 0;
}

void push(struct stack* s, char ch)
{
     if(s->top>=s->size)
    {
        printf("Unbalanced Parenthesis\nPlease check opening parenthesis\n");
        exit(0);
    }
    s->arr[(s->top)++]=ch;
    //printf("Pushed\n");
}

int pop(struct stack* s, char ch)
{
    char a = s->arr[(s->top)-1];
    //printf("%c", a);
    if(isEmpty(s))
    {
        return 0;
    }
    else if((a=='('&&ch==')')||(a=='{'&&ch=='}')||(a=='['&&ch==']'))
    {
        (s->top)--;
        return 1;
        //printf("Popped\n");
    }
    return 0;
}


int main()
{
    struct stack* s;
    char str[100];
    s->top=0;
    printf("Enter the expression\n");
    gets(str);
    int len = strlen(str);
    s->size = len;
    s->arr = (char *)malloc(s->size*sizeof(char));
    int i=0;
    while(str[i]!='\0')
    {
        char c = str[i];
        if(c=='('||c=='{'||c=='[')
        {
            push(s,c);
        }
        if(c==')'||c=='}'||c==']')
        {
            if(pop(s,c)==0)
            {
                printf("Unbalanced parenthesis\nPlease check closing parenthesis\n");
                exit(0);
            }
        }
        i++;
    }
    if(isEmpty(s))
    {
        printf("Parenthesis Matched\n");
    }
    else
    {
        printf("Parenthesis not matched\n");
    }
    return 0;
}