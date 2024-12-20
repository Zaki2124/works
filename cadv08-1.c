#include <stdio.h>
#include <math.h>

typedef struct {
	double x;
	double y;
} point;

void setXY(point *p, double x, double y);

double getDistance(point *pa, point *pb);

int main(void)
{
	point p1, p2;
	
	setXY(&p1, 1.0, 1.0);
	setXY(&p2, 4.0, 5.0);
	
	printf("p1の座標は(%f, %f)\n", p1.x, p1.y);
	printf("p2の座標は(%f, %f)\n", p2.x, p2.y);
	
	printf("p1とp2の距離は%f\n", getDistance(&p1, &p2));
	
	return 0;
}

void setXY(point *p, double x, double y)
{
	p->x = x;
	p->y = y;
}

double getDistance(point *pa, point *pb)
{
	double distance;
	
	distance = (pb->x - pa->x) * (pb->x - pa->x) + (pb->y - pa->y) * (pb->y - pa->y);
	distance = sqrt(distance);
	
	return distance;
}