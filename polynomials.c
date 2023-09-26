#include <stdio.h>
#include <stdlib.h>

struct polynomial
{
    int coef;
    int exp;
    struct polynomial* next;
};

typedef struct polynomial* poly;

void insert(poly* p, int c, int e)
{
    poly new = (poly)malloc(sizeof(struct polynomial));
    new->coef = c;
    new->exp = e;
    new->next=NULL;

    if(*p==NULL)
    {
        *p=new;
    }
    else{
        (*p)->next=new;
        *p=(*p)->next;
    }
}

void add(poly a, poly b)
{
    poly end = (poly)malloc(sizeof(struct polynomial));
    poly c=end;
    end=NULL;
    while(a && b)
    {
        if(a->exp>b->exp)
        {
            insert(&end,a->coef, a->exp);
            a=a->next;
        }
        else if(b->exp>a->exp)
        {
            insert(&end,b->coef, b->exp);
            b=b->next;
        }
        else
        {
            insert(&end, b->coef, a->exp+b->exp);
            a=a->next;
            b=b->next;
        }
    }
    while(a!=NULL)
    {
        insert(&end,a->coef,a->exp);
        a=a->next;
    }
    while(b!=NULL)
    {
        insert(&end,b->coef,b->exp);
        b=b->next;
    }
    end->next=NULL;
    return c;
}

int main()
{
    poly a = (poly)malloc(sizeof(struct polynomial));
    poly b = (poly)malloc(sizeof(struct polynomial));
    a=NULL;
    b=NULL;
}