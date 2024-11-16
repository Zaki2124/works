#include <stdio.h>

int main(void)
{
	int suuti;
	scanf ("%d",&suuti);
	if (suuti >= 7 && suuti <= 24) printf("7`24‚ÌŠÔ‚Å‚·B\n");
	if (!(suuti >= 7 && suuti <= 24)) printf("7`24‚ÌŠÔ‚Å‚Í‚ ‚è‚Ü‚¹‚ñB\n");
	
	return 0;
}
