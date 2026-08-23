#include <stdio.h> 
 
void swap(int *a, int *b) { 
    int temp = *a; // this points to the address
    *a = *b; // address data is updated
    *b = temp;
} 

void broken_swap(int a, int b) { 
    int temp = a; // this is a local copy
    a = b; // this is a local reassignment
    b = temp;
}
 
int main() { 
    int x = 10; 
    int y = 20; 
 
    printf("======Using swap:======\n");
    printf("Before: x = %d, y = %d\n", x, y); 
 
    swap(&x, &y); 
 
    printf("After:  x = %d, y = %d\n", x, y); 

    printf("\n======Using broken_swap:======\n");
    printf("Before: x = %d, y = %d\n", x, y);
    broken_swap(x, y);
    printf("After:  x = %d, y = %d\n", x, y);

    return 0;
} 