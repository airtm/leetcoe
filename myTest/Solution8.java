package myTest;

import java.util.LinkedList;
import java.util.Queue;

import pojo.TreeNode;

//删除二叉搜索树中的节点
class Solution8 {

	public static void main(String[] args) {

		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(5);
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode8 = new TreeNode(8);
		TreeNode treeNode9 = new TreeNode(9);

		treeNode5.left = treeNode4;
		treeNode4.left = treeNode2;
		treeNode2.left = treeNode1;
		treeNode2.right = treeNode3;
		// treeNode7.right = treeNode8;
		TreeNode root = deleteNode(treeNode5, 4);
		print(root);

	}

	private static TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return root;
		if (root.right != null && root.right.left == null && root.right.right == null && root.right.val == key) {
			root.right = null;
			return root;
		}
		if (root.left != null && root.left.left == null && root.left.right == null && root.left.val == key) {
			root.left = null;
			return root;
		}
		if (root.right != null && root.right.left != null && root.right.right == null && root.right.val == key) {
			root.right = root.right.left;
		}
		if (root.left != null && root.left.left != null && root.left.right == null && root.left.val == key) {
			root.left = root.left.left;
		}
		if (root.val == key) {
			if (root.left == null && root.right == null) {
				return null;
			}
			if (root.right != null) {
				root.val = root.right.val;
				TreeNode right_left = root.right.left;
				root.right = root.right.right;
				if (right_left != null) {
					if (root.left == null) {
						root.left = right_left;
					} else {
						preorder1(root.left, right_left);
					}

				}
			} else if (root.left != null) {
				root.val = root.left.val;
				root.left = root.left.left;
			}
		}
		deleteNode(root.left, key);
		deleteNode(root.right, key);
		return root;
	}

	private static void preorder1(TreeNode root, TreeNode right_left) {
		if (root.right == null) {
			root.right = right_left;
			return;
		}
		preorder1(root.right, right_left);

	}

	private static void print(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur != null) {
				System.err.print(cur.val);
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			} else {
				System.err.print("null");
			}
		}

	};

}