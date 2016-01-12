/* Author : Jayant Gupta
	 Challenge : Upvotes
*/

#include<stdio.h>

int main(){
	int n, k;
	int i, j, cnd, cni, count_ni, count_nd;
	int N[100000];
	scanf("%d %d",&n, &k);
	for(i = 0 ; i < n ; i++){
		scanf("%d",&N[i]);
	}
	for(i = 0 ; i < n - k + 1 ; i++){
		cni = cnd = count_ni = count_nd = 0;
		for(j = 0 ; j < k - 1 ; j++){
			if(N[i + j] > N[i + j + 1]){ // Sequence non-increasing
				cni++;
				count_nd += (cnd * (cnd + 1)) / 2;
				cnd = 0;
			}
			else if(N[i + j] < N[i + j + 1]){ // Sequence non-decreasing
				cnd++;
				count_ni += (cni * (cni + 1)) / 2;
				cni = 0;
			}
			else{
				cnd++;
				cni++;
			}
		}
		count_nd += (cnd)*(cnd + 1) / 2;
		count_ni += (cni)*(cni + 1) / 2;
		printf("%d\n", count_nd - count_ni);
	}
	return 0;
}
