#include<stdio.h>
#include<math.h>

double distance(int x, int y){
	double dist = sqrt(x*x + y*y);
	return dist;
}

void swap(double *d1, double *d2){
	double temp = *d1;
	*d1 = *d2;
	*d2 = temp;
}

int main(){
	int i, N, M;
	scanf("%d", &N);
	int R[N];
	for(i = 0 ; i < N ; i++){
		scanf("%d", &R[i]);
	}
	scanf("%d",&M);
	int X[M][4];
	int count = 0;
	int j;
	for(i = 0 ; i < M ; i++){
		scanf("%d %d %d %d",&X[i][0], &X[i][1], &X[i][2], &X[i][3]);
		double d1 = distance(X[i][0], X[i][1]);
		double d2 = distance(X[i][2], X[i][3]);
		if(d1 > d2)swap(&d1, &d2);
		for(j = 0 ; j < N ; j++){
			if( d1 <= R[j] && R[j] <= d2){
				count++;
			}
		}
	}
	printf("%d\n", count);
	return 0;
}
