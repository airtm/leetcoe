package myTest;

import pojo.ListNode;

//两数相加
class Solution12 {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		ListNode oo = rotateRight(l5, 2);
		print(oo);

	}

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		ListNode ll = head;
		int a = 0;
		while (head != null) {
			a++;
			head = head.next;
		}
		
		ListNode tem = null;
		ListNode hh = ll;
		int b = k % a;
		if(a==1 || b == 0) {
			return ll;
		}
		b = a - b;
		while (ll != null) {
			b--;
			if (b == 0) {
				tem = ll.next;
				ll.next = null;
				break;
			}
			ll = ll.next;
		}

		ListNode rr = tem;
		while (tem != null) {
			if (tem.next == null) {
				tem.next = hh;
				break;
			}
			tem = tem.next;
		}
		return rr;
	}

	private static void print(ListNode removeElements) {
		while (removeElements != null) {
			System.out.print(removeElements.val + ",");
			removeElements = removeElements.next;
		}
	}

}