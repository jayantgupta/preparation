/*
	Given an array of length n, create the maximum number of length k.
 */

public class maxK{
	public static void main(String [] args){
		int [] nums	= {9, 1, 2, 5, 8, 3};
		int k = 3;
		int stack[] = new int[nums.length];
		int l = nums.length;
		int top = -1;
		for(int i = 0 ; i < l && top < k; i++){
			while(top != -1 && stack[top] < nums[i] && k - (top + 1) < (l - i)){
				top--;
			}
			stack[++top] = nums[i];
		}
		for(int i = 0 ; i < k ; i++){
			System.out.print(Integer.toString(stack[i]) + " ") ;
		}
		System.out.println();
	}
}
