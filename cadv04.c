void seteven2zero(int data[]);

int main(void)
{
	int i, array[5] = {15,78,98,15,98};
	
	for(i = 0; i < 4; i++) {
		printf("array[%d] = %d\n", i, array[i]);
	}
	
	seteven2zero(array);
	
	printf("\n");
	for(i = 0; i < 4; i++) {
		printf("array[%d] = %d\n", i, array[i]);
	}
	
	return 0;
}

void seteven2zero(int data[])
{
	int i;
	
	for(i = 0; i < 4; i++) {
		if(data[i] % 2 == 0)
		    data[i] = 0;
	}
}
