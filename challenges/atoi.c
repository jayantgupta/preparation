#include<stdio.h>
#include<stdlib.h>

int compare(const void *a, const void *b){
	return *(int *)a <= *(int *)b ?-1 : 1; 
}

int main(){
	int a[] = {12, 1, 34, 2, -1, 6};
	int i;
	for(i = 0 ; i < 6 ; i++)printf("%d ", a[i]);
	printf("\n");
	qsort(a, 6, sizeof(int), compare);
	for(i = 0 ; i < 6 ; i++)printf("%d ", a[i]);
	printf("\n");
}
