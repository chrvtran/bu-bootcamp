#include <stdio.h>

void print_math(int a, int b) {
    printf("Sum: %d\n", a + b);
    printf("Product: %d\n", a * b);
}

int main() { 
    int a, b;

    printf("Enter your first number: "); 
    scanf("%d", &a);

    printf("Enter your second number: "); 
    scanf("%d", &b);

    print_math(a, b);

    return 0;
}