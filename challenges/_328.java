import java.io.*;
import java.util.*;

class ListNode {
				int val;
				ListNode next;
				ListNode(int x) { 
					val = x;
			 		next = null;
				}
}

public class _328{
				public static void main(String [] args){
					int [] vals = {1,2,3,4,5,6,7,8};
					_328 test = new _328();
					ListNode my_list = test.create_list(vals);
					test.printList(my_list);
					my_list = test.oddEvenList(my_list);
//					test.printList(my_list);
				}
				public ListNode oddEvenList(ListNode head) {
								if(head == null || head.next == null || head.next.next == null) return head;
								ListNode ol = head;
								ListNode el = head.next;
								ListNode temp = ol;
								while(temp != null && temp.next != null){
												System.out.println(temp.val);
												temp.next = temp.next.next;
												temp = temp.next;
								}
								if(temp != null)temp.next = null;
								temp = el;
								while(temp != null && temp.next != null){
												System.out.println(temp.val);
												temp.next = temp.next.next;
												temp = temp.next;
								}
								if(temp != null)temp.next = null;
								while(ol.next != null)ol = ol.next;
								ol.next = el;
								return head;
				}
				
				ListNode create_list(int [] vals){
					int n = vals.length;
					if (n == 0) return null;
					ListNode L = new ListNode(vals[0]);
					ListNode temp = L;
					for(int i = 1 ; i < n ; i++){
						temp.next = new ListNode(vals[i]);
						temp = temp.next;
					}
					return L;
				}

				void printList(ListNode L){
					ListNode temp = L;
					while(temp != null){
						System.out.print(Integer.toString(temp.val) + " -> ");
						temp = temp.next;
					}
					System.out.println();
				}
}
