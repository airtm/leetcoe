package myTest;

import pojo.ListNode;

//删除链表的倒数第N个节点
class Solution13 {

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
		ListNode  head = removeNthFromEnd1(l1, 6);
		print(head);

	}
	
	static int b = 1;
	//优化写法
	public static ListNode removeNthFromEnd1(ListNode head, int n) {
		if (head != null){
			head.next = removeNthFromEnd1(head.next, n);
			if(b++ == n) {
				return head.next;
			}
		}
		return head;
	}

	static int a = 0 ;
	//原始写法
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode node = head;
		if (head != null) {
			a++;
			removeNthFromEnd(head.next, n);
			if(a == 1) {
				return null;
			}
			if(a == n) {
				node = node.next;
			}
			if(b == n) {
				if(head.next == null) {
					head.next = null;
				}else {
					head.next = head.next.next;
				}
			}
			b++;
		}
		return node;
	}

	//双指针
	public ListNode removeNthFromEnd3(ListNode head, int n) {
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode first = dummy;
	    ListNode second = dummy;
	    // Advances first pointer so that the gap between first and second is n nodes apart
	    for (int i = 1; i <= n + 1; i++) {
	        first = first.next;
	    }
	    // Move first to the end, maintaining the gap
	    while (first != null) {
	        first = first.next;
	        second = second.next;
	    }
	    second.next = second.next.next;
	    return dummy.next;
	}
	

	private static void print(ListNode removeElements) {
		while (removeElements != null) {
			System.out.print(removeElements.val + ",");
			removeElements = removeElements.next;
		}
	}

}