#include <stdio.h>

int main(void)
{
	int data;
	double s;
	
	do {
		printf("���a�́H:");
		scanf("%d", &data);
	} while (data < 0);
	
	s = data * data * 3.14;
	printf("�ʐς� %f �ł��B\n",s);
	
	return 0;
}
