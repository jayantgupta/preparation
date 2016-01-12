import java.util.*;
public class UnDuplicate {
				public String removeDuplicateLetters(String s) {
								int len = s.length();
								ArrayList<String> terms = new ArrayList<String>();
								char [] temp = s.toCharArray();
								int distinct = 0;
								int check[] = new int[26];
								for(int i = 0 ; i< 26 ; i++) check[i] = 0;
								for(char c : temp){
												if(check[(int)(c - '0')] == 0){
																distinct += 1;
																check[(int)(c - '0')] = 1;
												}
								}
								for(int i = 0 ; i < len ; i++){
												String my_str="";
												for(int j = i ; j < len && my_str.length() < distinct ; j++){
																if(my_str.indexOf(temp[j]) == -1){
																				my_str += temp[j];
																}
												}
												terms.add(my_str);
								}
								Collections.sort(terms);
								return terms.get(0);
				}
}
