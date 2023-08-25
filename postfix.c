#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

struct stack
{
    int size;
    int top;
    char* arr;
    char* res;
};

int precedence(char ch)
{
    if(ch=='+'||ch=='-')
        return 1;
    else if(ch=='*'||ch=='/'||ch=='%')
        return 2;
    else if(ch=='(')
        return 3;
    else
        return 0;
}

int isEmpty(struct stack* s)
{
    if(s->top==0)
    {
        return 1;
    }
    return 0;
}

char operate(struct stack* s, char ch)
{
    char out = '\0';
    if(ch==')')
    {
        if(s->arr[(s->top)-1]=='(')
        {
            return out;
        }
        out = s->arr[--s->top];
        return out;
    }
    else if(isEmpty(s))
    {
        s->arr[s->top++]=ch;
        //printf("Pushed Empty Stack\n");
        return out;
    }
    else if(precedence(ch)>precedence(s->arr[(s->top)-1]))
    {
        s->arr[s->top++]=ch;
        //printf("Pushed non empty\n");
        return out;
    }
    else if(precedence(ch)<=precedence(s->arr[(s->top)-1]))
    {
        out = s->arr[--s->top];
        //printf("Popped\n");
        return out;
    }
}

void toPostfix(struct stack* s, char exp[])
{
    int i=0, ind=0;
    while(exp[i]!='\0')
    {
        char c = exp[i];
        //printf("%c\n",c);
        int flag=0;
        switch(c)
        {
            case '+':
            case '-':
            case '*':
            case '/':
            case '%':
            case ')':
            case '(': while(flag==0)
                      {
                        char ch = operate(s,c);
                        if(ch!='\0')
                        {
                            s->res[ind++]=ch;
                        }
                        else
                        {
                            flag=1;
                            break;
                        }
                      }
                      break;
            default : s->res[ind++]=c;
                      break;
        }
        i++;
    }
    while(!isEmpty(s))
    {
        s->res[ind++]=s->arr[--s->top];
    }
    s->res[ind]='\0';
}

int main()
{
    struct stack* s;
    char str[100];
    //char res[100];
    printf("Enter the expression\n");    
    gets(str);
    //puts(str);
    int len = strlen(str);
    s->size = len;
    //printf("%d", s->size);
    s->top=0;
    s->arr = (char *)malloc(s->size*sizeof(char));
    s->res = (char *)malloc(s->size*sizeof(char));
    //printf("Input taken\n");
    toPostfix(s, str);
    printf("The postfix expression is : %s", s->res);
    return 0;
}
