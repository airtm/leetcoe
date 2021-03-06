package myTest;

import java.util.UUID;

import pojo.ListNode;

//移除链表元素
class Solution_21 {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l5_ = new ListNode(5);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l5_;

		print(l1);
		ListNode removeElements = removeElements(l1, 5);
		System.err.println(UUID.randomUUID());
		print(removeElements);

	}

	// 循环
	public static ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		ListNode hh = head;
		while (hh != null) {
			if (hh.next != null && hh.next.val == val) {
				hh.next = hh.next.next;
			} else {
				hh = hh.next;
			}
		}
		if (head.val == val) {
			return head.next;
		}
		return head;
	}

	// 递归
	public ListNode removeElements1(ListNode head, int val) {
		if (head == null)
			return null;
		head.next = removeElements(head.next, val);
		if (head.val == val) {
			return head.next;
		} else {
			return head;
		}
	}

	private static void print(ListNode removeElements) {
		while (removeElements != null) {
//			System.out.print(removeElements.val);
			removeElements = removeElements.next;
		}
	}

}