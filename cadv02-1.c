#include <stdio.h>

int main(void)
{
	char str[256] = "DRAGON";
	scanf("%s",&str[6]);
	printf("%s\n",str);
	
	printf("str[0]の要素の値 :\'%c\'\n", str[0]);
	printf("str[1]の要素の値 :\'%c\'\n", str[1]);
	printf("str[0]の要素のアドレス :%p\n",str[0]);
	printf("str[1]の要素のアドレス :%p\n",str[1]);
	printf("strの先頭要素のアドレス :%p\n",str);
	
	return 0;
}
