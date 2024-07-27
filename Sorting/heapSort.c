#include <stdio.h>

void topDown(int n, int i, int *arr)
{
    int largest = i;
    int lchild = 2 * largest + 1;
    int rchild = lchild + 1;

    if (lchild < n && arr[lchild] > arr[largest])
        largest = lchild;
    if (rchild < n && arr[rchild] > arr[largest])
        largest = rchild;
    if (largest != i)
    {
        int temp = arr[largest];
        arr[largest] = arr[i];
        arr[i] = temp;
        topDown(n, largest, arr);
    }
}

void heapSort(int n, int *arr)
{
    for (int i = n / 2 - 1; i >= 0; i--)
        topDown(n, i, arr);

    for (int i =0; i<n; i++)
    {
        int temp = arr[0];
        arr[0] = arr[n - 1];
        arr[n - 1] = temp;
        n--;
        topDown(n, 0, arr);
    }
}

int main()
{
    int n;
    printf("Enter size of array : ");
    scanf("%d", &n);
    int arr[n];
    printf("Enter elements in the array\n");
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }

    heapSort(n, arr);

    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");
    return 0;
}


/* #include <stdio.h>
#include <stdlib.h>

void heapify(int arr[], int n, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && arr[l] > arr[largest])
        largest = l;

    if (r < n && arr[r] > arr[largest])
        largest = r;

    if (largest != i) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
        heapify(arr, n, largest);
    }
}

void heapsort(int arr[], int n) {
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);

    for (int i = n - 1; i >= 0; i--) {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        heapify(arr, i, 0);
    }
}

void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

int main() {
    int arr[] = {12, 11, 13, 5, 6, 7};
    int n = sizeof(arr) / sizeof(arr[0]);

    heapsort(arr, n);

    printf("Sorted array: \n");
    printArray(arr, n);
} */