#include <stdio.h>
#include <string.h>
#include <conio.h>
#define MAX 128

int t[MAX];

void shiftTable(char p[])
{
    int max = strlen(p);
    for(int i=0; i<MAX; i++)
    {
        t[i]=max;
    }
    for(int j=0; j<max-1; j++)
    {
        t[p[j]]=max-1-j;
    }
}

int horspool(char txt[], char p[])
{
    int n = strlen(txt);
    int m = strlen(p);
    int k;
    int i=m-1;
    while(i<n)
    {
        k=0;
        while(k<m && txt[i-k]==p[m-1-k])
            k++;
        if(k==m)
            return i-k+1;
        else
            i+=t[txt[i]];
    }
    return -1;
}
int main()
{
    char txt[100],p[100];
    printf("Enter text : ");
    gets(txt);
    printf("Enter pattern : ");
    gets(p);
    shiftTable(p);
    int pos = horspool(txt,p);
    if(pos<0)
        printf("Pattern not found\n");
    else
        printf("Pattern found at position %d\n",pos);
    getch();
}