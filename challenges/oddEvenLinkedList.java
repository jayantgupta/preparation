/**
 *
 * Solution for https://leetcode.com/problems/odd-even-linked-list/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
				public ListNode oddEvenList(ListNode head) {
								if(head == null || head.next == null || head.next.next == null) return head;
								ListNode e_head = head.next;
								ListNode p1 = head;
								ListNode p2 = head.next;
								ListNode p3 = head;
								while(p3 != null && p3.next != null && p3.next.next != null){
												p3 = p3.next.next;
												p1.next = p3;
												p2.next = p3.next;
												p1 = p1.next;
												p2 = p2.next;
								}
								p1.next = e_head;
								return head;
				}
}
