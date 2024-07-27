#include <stdio.h>
#include <stdlib.h>

int maximum(int n, int* arr)
{
    int max=arr[0];
    for(int i=0; i<n; i++)
    {
        if(arr[i]>max)
            max=arr[i];
    }
    return max;
}

void countSort(int n, int* arr)
{
    int max = maximum(n, arr);
    int* countArr = (int*)calloc(sizeof(int), max+1);

    for (int i=0; i<=n; i++)
    {
        countArr[arr[i]]++;
    }

    int i=0;
    int j=0;
    while(i<=max)
    {
        if(countArr[i]>0)
        {
            arr[j]=i;
            j++;
            countArr[i]--;
        }
        else
        {
            i++;
        }
    }
}

int main()
{
    int n;
    printf("Enter sixe of array : ");
    scanf("%d", &n);
    int arr[n];
    printf("Enter array elements\n");
    for(int i=0; i<n; i++)
    {
        scanf("%d", &arr[i]);
    }

    countSort(n,arr);
    printf("Sorted array : ");
    for(int i=0; i<n; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");
    return 0;
}