#include <stdio.h>

void capitalize(char *data);

int main(void)
{
	int i;
	char str[] = "abcde";
	
	for (i = 0;str[i] != '\0'; i++){
		printf("%c",str[i]);
	}
	printf("\n");
	
	capitalize(str);
	
	printf("%s\n",str);
	
	return 0;
}

void capitalize(char *data)
{
	int i;
	for (i = 0;data[i] !='\0'; i++) {
		data[i] = data[i] - 32;
	}
	
	
}
