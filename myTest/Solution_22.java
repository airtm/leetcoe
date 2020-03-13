package myTest;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import pojo.ListNode;
import pojo.TreeNode;

//环形链表
class Solution_22 {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(3);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(0);
		ListNode l4 = new ListNode(-4);
		ListNode l5 = new ListNode(5);
		ListNode l5_ = new ListNode(5);

		l1.next = l2;
		l2.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l2;

		System.err.println(hasCycle(l1));

	}

	public static boolean hasCycle(ListNode head) {
		HashSet<Integer> hashSet = new HashSet<>();
		while (head != null) {
			if (hashSet.contains(head.hashCode())) {
				return true;
			}
			hashSet.add(head.hashCode());
			head = head.next;
		}
		return false;
	}

	private static void print(ListNode removeElements) {
		while (removeElements != null) {
			System.out.println(removeElements.val);
			removeElements = removeElements.next;
		}
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

}