#include <stdio.h>

int main(void)
{
	int data1,data2,data3,data6;
	int data4 = 0;
	int data5 = 1;
	
	printf("����2�̓��͒l�𑫂��Z���܂��B:");
		scanf("%d, %d",&data1,&data2);
	
	data3 = data1 + data2;
	data6 = data1 + data2;
	
	printf ("%d �� %d �̍��v�l�� %d �ł��B\n",data1,data2,data3);
	
	printf("���� %d ��2�i���\�L�ɒ����܂��B\n",data3);
	
	while(data3>0) {
		data4 = data4 + ( data3 % 2 ) * data5;
		data3 = data3 / 2;
		data5 = data5 * 10;
	}
	
	printf("%d ��2�i���\�L�� %d �ł��B\n",data6,data4);
	
	return 0;
}