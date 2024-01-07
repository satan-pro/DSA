#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <conio.h>
#include "stackll.h"

struct Node{
    char data;
    struct Node* left;
    struct Node* right;
};
typedef struct Node* node;

node createNode(char ch)
{
    node new = (node)malloc(sizeof(struct Node));
    new->data=(char)ch;
    new->left=NULL;
    new->right=NULL;
    return new;
}

void inorder(node root)
{
    if(root!=NULL)
    {
        inorder(root->left);
        printf("%c ", root->data);
        inorder(root->right);
    }
}

int isOperand(char ch)
{
    if(isdigit(ch))
        return 1;
    return 0;
}

int isOperator(char ch)
{
    switch(ch)
    {
        case '+':
        case '-':
        case '*':
        case '/':
        case '^': return 1;
                  break;
        default : return 0;
    }
}

node operate(char* s)
{
    struct StackNode* head = (struct StackNode*)malloc(sizeof(struct StackNode));
    head=NULL;
    for(int i=0; i<strlen(s); i++)
    {
        char ch = s[i];
        if(isOperand(ch))
        {
            node curr = createNode(ch);
            push(&head,curr);
        }
        else if(isOperator(ch))
        {
            node right = pop(&head);
            node left = pop(&head);
            node curr = createNode(ch);
            curr->left=left;
            curr->right = right;
            push(&head,curr);
        }
    }
    node res = pop(&head);
    if(res)
    {
        return res;
    }
    return NULL;
}



int main()
{
    char str[100];
    printf("Enter postfix expression : ");
    scanf("%s", &str);
    node root = operate(&str[0]);
    inorder(root);
    return 0;
}