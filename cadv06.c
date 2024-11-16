#include <stdio.h>
#include <math.h>

typedef struct {
	double x;
	double y;
}point;

int main(void)
{
	point p1, p2;
	double distance;
	p1.x =1.0;
	p1.y =1.0;
	
	p2.x =4.0;
	p2.y =5.0;


	printf("p1‚ÌÀ•W‚Í(%f, %f)\n", p1.x, p1.y);
	printf("p2‚ÌÀ•W‚Í(%f, %f)\n", p2.x, p2.y);

	distance = (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
	distance = sqrt(distance);

	printf("p1‚Æp2‚Ì‹——£‚Í%f\n", distance);
	return 0;
}