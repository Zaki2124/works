#include <stdio.h>

int main(void)
{
	int suuti;
	scanf ("%d",&suuti);
	if (suuti >= 7 && suuti <= 24) printf("7�`24�̊Ԃł��B\n");
	if (!(suuti >= 7 && suuti <= 24)) printf("7�`24�̊Ԃł͂���܂���B\n");
	
	return 0;
}
