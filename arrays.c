#include <stdio.h>

void showArr(int *arr, int size)
{
    for(int i=0; i<size; i++)
    {
        printf("%d ", arr[i]);
    }
}

int insert(int *arr, int number, int size, int capacity, int index)
{
    if(size>=capacity)
    {
        return -1;
    }
    for(int i=size-1; i>=index; i--)
    {
        arr[i+1]=arr[i];
    }
    arr[index]=number;
}

int delete(int *arr, int size, int index)
{
    if(index>size)
    {
        return -1;
    }
    for(int i=index; i<size-1; i++)
    {
        arr[i]=arr[i+1];
    }
    return 1;
}

int main()
{
    int arr[10] = {7,8,5,4};
    int size=4, index=2,ch;
    printf("Enter your operation\n1. Insert\n2. Delete\n");
    scanf("%d",&ch);
    switch(ch)
    {
        case 1: if(insert(arr, 45, size, 10, index)>0)
                {
                    size+=1;
                }
                break;

        case 2: if(delete(arr, size, index)>0)
                {
                    size-=1;
                }
                break;

    }
    printf("Printing the new array\n");
    showArr(arr,size);
    return 0;
}