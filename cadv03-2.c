#include <stdio.h>

int main(void)
{
	int suuti;
	scanf ("%d",&suuti);
	if (suuti >= 7 && suuti <= 24) printf("7〜24の間です。\n");
	if (!(suuti >= 7 && suuti <= 24)) printf("7〜24の間ではありません。\n");
	
	return 0;
}
