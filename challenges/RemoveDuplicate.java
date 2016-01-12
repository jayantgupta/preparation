/*
soln from : https://leetcode.com/discuss/74373/java-2ms-two-pointers-solution-or-stack-simulation-beats-72%25
*/

public class RemoveDuplicate{
	public static void main(String [] args){
					RemoveDuplicate RD = new RemoveDuplicate();
					String s = "cbacdcbc";
					String ans = RD.removeDuplicates(s);
					System.out.println(ans);
	}

	public String removeDuplicates(String s){
		int i, n = s.length();
		int [] cnt = new int[128];
		boolean [] inRes = new boolean[128];
		char res[] = s.toCharArray();
		for(i = 0 ; i < n ; i++){
			cnt[res[i]]++;
		}
		char c, sc;
		int end = -1;
		for(i = 0 ; i < n ; i++){
			c = res[i];
			if(inRes[c]){
				cnt[c]--;
				continue;
			}
			while(end >= 0 && (sc = res[end]) >= c && cnt[sc] > 0){
				end--;
				inRes[sc] = false;
			}
			res[++end] = c;
			cnt[c]--;
			inRes[c] = true;
		}
		return String.valueOf(res).substring(0, end + 1);
	}
}
