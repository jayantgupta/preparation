import java.io.*;
import java.util.*;

class ListNode {
				int val;
				ListNode next;
				ListNode(int x) { val = x; }
}

public class swapNodes{

				public static void main(String [] args){
						
				}

				public ListNode swapPairs(ListNode head) {
								if(head != null && head.next != null){
												ListNode temp = head;
												head = head.next;
												temp.next = head.next;
												head.next = temp;
												ListNode rest = head.next.next;
												while(rest != null && rest.next != null){
																temp = rest;
																rest = rest.next;
																temp.next = rest.next;
																rest.next = temp;
																rest = rest.next.next;
												}
								}
								return head;
				}
}
