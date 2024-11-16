#include <stdio.h>

int main(void)
{
	int data;
	double s;
	
	do {
		printf("”¼Œa‚ÍH:");
		scanf("%d", &data);
	} while (data < 0);
	
	s = data * data * 3.14;
	printf("–ÊÏ‚Í %f ‚Å‚·B\n",s);
	
	return 0;
}
