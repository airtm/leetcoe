package myTest;

import pojo.ListNode;

//两数相加
class Solution_27 {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(1);
//		ListNode l2 = new ListNode(9);
//		ListNode l3 = new ListNode(9);

		ListNode l4 = new ListNode(9);
		ListNode l5 = new ListNode(9);
//		ListNode l6 = new ListNode(5);

//		l3.next = l2;
//		l2.next = l1;

//		l6.next = l5;
		l5.next = l4;
		// print(l3);
		System.err.println("---");
		// print(l6);
		System.err.println("---");
		ListNode oo = addTwoNumbers22(l1, l5);
		print(oo);

	}

	private static ListNode addTwoNumbers22(ListNode l1, ListNode l2) {
		ListNode lll= l1;
		addTwoNumbers(l1, l2);
		return lll;
	}

	public static void addTwoNumbers(ListNode l1, ListNode l2) {
		if(l2 == null) {
			return;
		}
		if(l1 == null && l2!=null) {
			l1 = new ListNode(l2.val);
		}
		int a = l1.val + l2.val;
		if( a >= 10 ) {
			l1.val = a - 10;
			if(l1.next == null) {
				l1.next = new ListNode(0);
			}
			l1.next.val = l1.next.val + 1;
		}
		addTwoNumbers(l1.next,l2.next);
	}

	private static void print(ListNode removeElements) {
		while (removeElements != null) {
			System.out.print(removeElements.val +",");
			removeElements = removeElements.next;
		}
	}
	  public ListNode addTwoNumbers11(ListNode l1, ListNode l2) {
			
			if(l1 == null) {
				return l2;
			}
			if(l2 == null) {
				return l1;
			}
			ListNode l3 = l1;
			ListNode l4 = l2;
			while (l1 != null & l2 != null) {
				int a = l1.val + l2.val;
	            if(a >= 10 && l1.next == null && l2.next == null) {
	                l1.val = a - 10;
					l2.val = a - 10;
					l1.next = new ListNode(1);
					l2.next = new ListNode(1);
					return l3;
				}
				if (a >= 10) {
					l1.val = a - 10;
					l2.val = a - 10;
					if(l1.next !=null) {
						l1.next.val = l1.next.val + 1;
					}else if(l2.next !=null) {
						l2.next.val = l2.next.val + 1;
					}
				} else {
					l1.val = a;
					l2.val = a;
				}
				l1 = l1.next;
				l2 = l2.next;
				if(l1 == null) {
					return l4;
				}
				if(l2 == null) {
					return l3;
				}
			}
			return null;
		
	    }

}