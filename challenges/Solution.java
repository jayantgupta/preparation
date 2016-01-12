import java.util.HashMap;



public class Solution {

				public int[] singleNumber(int[] nums) {

								int size = nums.length;

								HashMap<Integer, Integer> num_freq = new HashMap<Integer, Integer>();

								for(int i = 0  ; i < size ; i++){

												if(num_freq.containsKey(nums[i])){

																num_freq.put(nums[i], 2);

												}else{

																num_freq.put(nums[i], 1);

												}

								}

								int ans[] = new int[2];

								int [] keys = num_freq.KeySet().toArray();

								int index = 0;

								for(int k = 0 ; k < keys.length && index < 2; k++){

												if(num_freq.get((int)keys[k]) != 2){

																ans[index++] = (int)keys[k];

												}

								}

								return ans;

				}

}
