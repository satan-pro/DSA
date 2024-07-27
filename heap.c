#include <stdio.h>
#include <stdlib.h>

void topDown(int n, int*arr, int i)
{
    int largest=i;
    int lchild = 2*i+1;
    int rchild = 2*i+2;

    if(lchild<n && arr[lchild]>arr[largest])
        largest=lchild;
    if(rchild<n && arr[rchild]>arr[largest])
        largest=rchild;
    if(largest!=i)
    {
        int temp = arr[i];
        arr[i]=arr[largest];
        arr[largest] =temp;

        topDown(n,arr,largest);
    }
}

void bottomUp(int n, int* arr)
{
    int parent = n/2-1;

    if(n!=0 && parent>0)
    {
        if(arr[n]>arr[parent])
        {
            printf("%d\n",n);
            int temp = arr[n];
            arr[n]=arr[parent];
            arr[parent]=temp;

            bottomUp(parent, arr);
        }
    }
}

void bottomUpHeapify(int n, int* arr)
{
    int i=n;
    while(i>0)
    {
       bottomUp(i,arr);
       i--;
    }
}

void topDownHeapify(int n, int* arr)
{
    int start = n/2-1;

    for (int i=start; i>=0; i--)
    {
        topDown(n,arr,i);
    }
}

int main()
{
    int n;
    printf("Enter size of heap : ");
    scanf("%d", &n);
    int arr[n];

    printf("Enter elements in the heap\n");
    for(int i=0; i<n; i++)
    {
        scanf("%d", &arr[i]);
    }

    topDownHeapify(n,arr);

    printf("Heap : ");
    for(int i=0; i<n; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");


}

//Heap : 17 15 13 9 6 5 10 4 8 3 1