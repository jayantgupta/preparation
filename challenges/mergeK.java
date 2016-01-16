/*
	Given two arrays of length m, n.
	Merge the arrays to get the largest 
	number of size m + n.
 */

public class mergeK{
	public static void main(String [] args){
//		int [] nums1 = {9, 1, 2, 5, 8, 3};
//		int [] nums2 = {3, 4, 6, 5};
		int []nums1 = {6, 7};
		int []nums2 = {6, 0, 4};
		int m = nums1.length;
		int n = nums2.length;
		int K = m + n;
		int ans[] = new int[m + n];
		int i = 0, j = 0, k = 0;
		for(k = 0 ; k < K && i < m && j < n; k++){
			if(nums1[i] > nums2[j]) ans[k] = nums1[i++];
			else if(nums1[i] < nums2[j])ans[k] = nums2[j++];
			else{
				int i_ = i + 1; int j_ = j + 1;
				while(i_ < m && j_ < n && nums1[i_] == nums2[j_]){
					i_++; j_++;	
				}
				if(i_ == m || j_ == n || nums1[i_] > nums2[j_])ans[k] = nums1[i++];
				else ans[k] = nums2[j++];
			}	
		}
		if(i == m){
						while(j < n && k < K){
										ans[k++] = nums2[j++];
						}
		}
		else if(j == n){
						while(i < m && k < K){
										ans[k++] = nums1[i++];
						}
		}
		for(k = 0 ; k < K ; k++)System.out.print(Integer.toString(ans[k]) + " ");
		System.out.println();
	}
}
