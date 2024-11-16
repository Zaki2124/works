#include <stdio.h>

int main(void)
{
	int data1,data2,data3,data6;
	int data4 = 0;
	int data5 = 1;
	
	printf("次の2つの入力値を足し算します。:");
		scanf("%d, %d",&data1,&data2);
	
	data3 = data1 + data2;
	data6 = data1 + data2;
	
	printf ("%d と %d の合計値は %d です。\n",data1,data2,data3);
	
	printf("次に %d を2進数表記に直します。\n",data3);
	
	while(data3>0) {
		data4 = data4 + ( data3 % 2 ) * data5;
		data3 = data3 / 2;
		data5 = data5 * 10;
	}
	
	printf("%d の2進数表記は %d です。\n",data6,data4);
	
	return 0;
}