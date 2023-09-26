#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n;
    printf("Enter the no of rows : ");
    scanf("%d",&n);
    int** table = (int**)calloc(n+1,sizeof(int*));
    for(int i=0; i<n; i++)
    {
        int colnum;
        printf("Enter the no of columns : ");
        scanf("%d",&colnum);
        table[i]=(int*)calloc(colnum+1, sizeof(int));
        printf("Enter row elements\n");
        for(int j=1; j<=colnum; j++)
        {
            scanf("%d", &table[i][j]);
        }
        table[i][0]=colnum;
    }
    table[n]=NULL;
    printf("\n\nDisplaying the ragged array\n");
    for(int i=0; i<n; i++)
    {
        for(int j=1; j<=*table[i]; j++)
        {
            printf("%d ",table[i][j]);
        }
        printf("\n");
    }
    return 0;
}