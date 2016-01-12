#include<stdlib.h>
#include<stdio.h>

int compare(const void *a, const void *b){
				return *(int *)a <= *(int *)b ? -1 : 1;
}

void wiggleSort(int* nums, int numsSize) {
				int temp[numsSize];
				int i;
				for(i = 0 ; i < numsSize ; i++){
								temp[i] = nums[i];
				}
				qsort(temp, numsSize, sizeof(int), compare);
				int even_ptr = 0;
				int odd_ptr = (numsSize + 1)/ 2;
				for(i = 0 ; i < numsSize  ; i += 2){
								nums[i] = temp[even_ptr];
								if(i + 1 < numsSize){
												nums[i+1] = temp[odd_ptr];
								}
								even_ptr+=1;
								odd_ptr+=1;
								printf("i:%d ep:%d op:%d\n", i, even_ptr, odd_ptr);
				}
				for(i = 0 ; i < numsSize ; i++){
					printf("%d ",nums[i]);
				}
				printf("\n");
				return;
}

int main(){
	int a[] = {1,5,1,1,6,4};
	wiggleSort(a, 6);
}
