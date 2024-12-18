#include <stdio.h>
#include <math.h>

typedef struct {
	double x;
	double y;
} point;

double getDistance(point * p1,point * p2);
int main(void)
{
	point p1,p2;
	
	p1.x = 1.0;
	p1.y = 1.0;
	
	p2.x = 4.0;
	p2.y = 5.0;
	
	printf("p1の座標は(%f, %f)\n", p1.x, p1.y);
	printf("p2の座標は(%f, %f)\n", p2.x, p2.y);
	
	printf("p1とp2の距離は%f\n", getDistance(&p1,&p2));
	
	return 0;
}

double getDistance(point * p1,point * p2)
{
	double distance;
	
	distance = (p2->x - p1->x) * (p2->x - p1->x) + (p2->y - p1->y) * (p2->y - p1->y);
	distance = sqrt(distance);
	
	return distance;
}