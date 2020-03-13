package myTest;

import java.util.ArrayList;

import pojo.TreeNode;

class Solution_10 {

	public static void main(String[] args) {
//		int[] a = { 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4 };
		TreeNode bt1 = new TreeNode(1);
		TreeNode bt2 = new TreeNode(2);
		TreeNode bt3 = new TreeNode(3);
		TreeNode bt4 = new TreeNode(4);
		TreeNode bt5 = new TreeNode(5);
		TreeNode bt6 = new TreeNode(6);
		TreeNode bt7 = new TreeNode(7);
		
		bt1.left = bt2;
		bt1.right = bt3;
		bt2.left = bt4;
		bt2.right = bt5;
		bt3.left = bt6;
		bt3.right = bt7;
		bt6.left = new TreeNode(8);
		bt7.right = new TreeNode(9);
		int balanced = isBalanced(bt1, 0, 0);
		System.err.println(balanced);
	}

	public static int isBalanced(TreeNode root, int a, int b) {

		if (root != null) {
			a++;
			b++;
//			System.err.println(root.val + "|" + a + "|" + b);
			a = isBalanced(root.left, a, b);
			b = isBalanced(root.right, a, b);
			System.out.println(root.val + "|" + a + "|" + b);
		}

		return Math.max(a, b);

	}

}