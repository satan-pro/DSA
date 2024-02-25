#include <stdio.h>

void merge(int* arr, int low, int mid, int high)
{
    int i,j,k;
    i=low;
    j=mid+1;
    k=low;
    int b[high];

    while(i<=mid && j<=high)
    {
        if(arr[i]<arr[j])
        {
            b[k++]=arr[i];
            i++;
        }
        else{
            b[k++]=arr[j];
            j++;
        }
    }
    while(i<=mid)
    {
        b[k++]=arr[i];
        i++;
    }
    while(j<=high)
    {
        b[k++]=arr[j];
        j++;
    }
    
    for(int i=low; i<=high; i++)
    {
        arr[i]=b[i];
    }
}

void mergeSort(int* arr, int low, int high)
{
    int mid;
    if(low<high)
    {
        mid=(low+high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }
}

int main()
{
    int n;
    printf("Enter size of array : ");
    scanf("%d", &n);
    int arr[n];
    printf("Input Array : ");
    for(int i=0; i<n; i++)
    {
        scanf("%d", &arr[i]);
    }
    mergeSort(arr, 0, n-1); 
    printf("Sorted Array : ");
    for(int i=0; i<n; i++)
    {
        printf("%d ", arr[i]);
    }
    return 0;
}