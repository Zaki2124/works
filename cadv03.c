#include <stdio.h>

int main(void)
{
	int *p = NULL;
	int i = 5;
	p = &i;
	
	
	printf("i = %d\n", i);
	*p = i * 3;
	printf("i = %d\n", i);
	
	return 0;
}
