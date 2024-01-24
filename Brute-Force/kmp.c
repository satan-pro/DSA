#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void findLps(int len, int lps[], char p[])
{
    int prev = 0, i = 1;
    lps[0]=0;
    while (i < len)
    {
        if (p[i] == p[prev])
        {
            lps[i] = prev + 1;
            prev++;
            i++;
        }
        else
        {
            if (prev == 0)
            {
                lps[i] = 0;
                i++;
            }
            else
            {
                prev = lps[prev - 1];
            }
        }
    }
}

int main()
{
    char str[100];
    char pattern[100];
    printf("Enter the string : ");
    gets(str);
    printf("Enter the pattern : ");
    gets(pattern);
    int ls = strlen(str);
    int lp = strlen(pattern);

    int lps[lp];
    findLps(lp, lps, pattern);


    printf("\n");
    int j, i=0;
   while(i<strlen(str))
    {
        if (str[i] == pattern[j])
        {
            i++;
            j++;
        }
        else{
            if(j==0)
            {
                i++;
            }
            else{
                j=lps[j-1];
            }
        }
        if(j==strlen(pattern))
        {
            printf("Pattern found at : %d", i-strlen(pattern));
        }
    }
}