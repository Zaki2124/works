#include <stdio.h>

int main(void)
{
	char str[256] = "DRAGON";
	scanf("%s",&str[6]);
	printf("%s\n",str);
	
	printf("str[0]�̗v�f�̒l :\'%c\'\n", str[0]);
	printf("str[1]�̗v�f�̒l :\'%c\'\n", str[1]);
	printf("str[0]�̗v�f�̃A�h���X :%p\n",str[0]);
	printf("str[1]�̗v�f�̃A�h���X :%p\n",str[1]);
	printf("str�̐擪�v�f�̃A�h���X :%p\n",str);
	
	return 0;
}
