/*
	Author : Jayant Gupta
	Date : January 5, 2016
	Challenge : Related_Questions
*/

#include<stdio.h>
#include<stdlib.h>
#include<limits.h>

int main(){
	int i, N;
	scanf("%d",&N);
	int T[N], a, b;
	int G[N];
	long total_time[N];
	for(i = 0 ; i < N ; i++){
		scanf("%d",&T[i]);
		total_time[i] = -1;
		G[i] = i;
	}
	for(i=0 ; i < N - 1 ; i++){
		scanf("%d %d",&a, &b);
		if(a < b){
			G[b - 1] = G[a - 1];
		}
		else{
			G[a - 1] = G[b - 1];
		}
	}
	for(i = 0 ; i < N ; i++){
		int index = G[i];
		if(total_time[index] == -1)
						total_time[index] = 0;
		total_time[index] += T[i];
	}
	long min_time = LONG_MAX;
	int min_grp;
	for(i = 0 ; i < N ; i++){
		if(total_time[i] != -1 && min_time > total_time[i] ){
			min_time = total_time[i];
			min_grp = i;
		}		
	}
	int min_t = INT_MAX;
	int min_q;
	for(i = 0 ; i < N && G[i] == min_grp ; i++){
		if(min_t > T[i]){
			min_t = T[i];
			min_q = i+1;
		}
	}
	printf("%d\n", min_q);
}
