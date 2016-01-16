#include<stdio.h>
#include<string.h>

void reverse(char *a);

int main(){
	char a[100];
	scanf("%s", a);
	printf("%s\n",a);
	reverse(a);
	printf("%s\n",a);
}

void reverse(char * a){
	int L = strlen(a);
	int i;
	int start = 0;
	int end = L - 1;
	while(start < end){
		char temp = a[start];
		a[start] = a[end];
		a[end] = temp;
		start++;
		end--;
	}
	return;
}
