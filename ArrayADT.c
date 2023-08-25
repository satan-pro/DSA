#include <stdio.h>
#include <stdlib.h>

struct myArray
{
    int total_size;
    int used_size;
    int* p;
};

void createArray(struct myArray* a, int tSize, int uSize)
{
    a->total_size = tSize;
    a->used_size = uSize;
    a->p = (int*)malloc(tSize * sizeof(int));
}

void setVal(struct myArray* a)
{
    printf("Enter input into the array\n");
    for(int i=0; i<=a->used_size; i++)
    {
        scanf("%d", &a->p[i]);
    }
}

void show(struct myArray* a)
{
    for(int i=0; i<a->total_size; i++)
    {
        printf("%d\n", a->p[i]);
    }
}

int main()
{
    struct myArray marks;
    createArray(&marks, 10, 4);
    setVal(&marks);
    printf("Displaying the array elements\n");
    show(&marks);
    return 0;
}
