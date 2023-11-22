#include <stdio.h>
#include <stdlib.h>

struct polynomial
{
    int coef;
    int exp;
    struct polynomial* next;
};

typedef struct polynomial* poly;

void insert(poly* head, int c, int e)
{
    poly new = (poly)malloc(sizeof(struct polynomial));
    new->coef = c;
    new->exp = e;
    new->next=NULL;
    if((*head)==NULL)
    {
        (*head)=new;
    }
    else{
        poly p = *head;
        while(p->next!=NULL)
        {
            p=p->next;
        }
        p->next=new;
    }
}

void show(poly head)
{
    while(head!=NULL)
    {
        printf("(%dx^%d)+", head->coef,head->exp);
        head=head->next;
    }
    printf("\n");
}

poly add(poly a, poly b)
{
    poly c = (poly)malloc(sizeof(struct polynomial));
    c=NULL;
    while(a && b)
    {
        if(a->exp>b->exp)
        {
            insert(&c,a->coef, a->exp);
            a=a->next;
        }
        else if(b->exp>a->exp)
        {
            insert(&c,b->coef, b->exp);
            b=b->next;
        }
        else
        {
            insert(&c, a->coef+b->coef, a->exp);
            a=a->next;
            b=b->next;
        }
    }
    show(b);
    show(a);
    while(a!=NULL)
    {
        insert(&c,a->coef,a->exp);
        a=a->next;
    }
    while(b!=NULL)
    {
        insert(&c,b->coef,b->exp);
        b=b->next;
    }
    return c;
}

int main()
{
    poly a = (poly)malloc(sizeof(struct polynomial));
    poly b = (poly)malloc(sizeof(struct polynomial));
    poly c = (poly)malloc(sizeof(struct polynomial));
    a=NULL;
    b=NULL;
    int flag=1;
    while(flag)
    {
        int ch,exp,coeff;
        printf("Enter your choice\n1.Insert Node\n2.Add polynomials\n");
        scanf("%d",&ch);
        int ch2;
        switch(ch)
        {
            case 1: printf("Enter choice : 1. Poly A\t2.Poly B\n");
                    scanf("%d",&ch2);
                    printf("Enter your exponent : ");
                    scanf("%d",&exp);
                    printf("Enter coefficient: ");
                    scanf("%d", &coeff);
                    if(ch2==1)
                    {
                        insert(&a,coeff, exp);
                        show(a);
                    }
                    if(ch2==2)
                    {
                        insert(&b,coeff,exp);
                        show(b);
                    }
                    break;

            case 2: c = add(a,b);
                    show(c);
                    break;

            default: flag=0;
        }
    }
}