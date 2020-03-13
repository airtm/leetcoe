package myTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import pojo.TreeNode;

class Solution_7最优解 {

	public static void main(String[] args) {

		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(2);
		TreeNode treeNode4 = new TreeNode(3);
		TreeNode treeNode5 = new TreeNode(3);
		TreeNode treeNode6 = new TreeNode(4);
		TreeNode treeNode7 = new TreeNode(4);

		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		treeNode2.left = treeNode4;
		treeNode2.right = treeNode6;
		treeNode3.left = treeNode7;
		treeNode3.right = treeNode5;

		treeNode6.left = new TreeNode(8);
		treeNode6.right = new TreeNode(9);
		treeNode5.left = new TreeNode(9);
		treeNode5.right = new TreeNode(8);

		System.out.println(maxDepth(treeNode1));
	}

	public static List<Integer> maxDepth(TreeNode root) {
		List<Integer> arrayList2 = new ArrayList<>();
		int end = 0;
		ArrayList<TreeNode> arrayList = new ArrayList<>();
		arrayList.add(root);
		for (int i = 0; i < arrayList.size(); i++) {
			TreeNode node = arrayList.get(i);
			if (node != null) {
				if (node.left != null) {
					arrayList.add(node.left);
				}
				if (node.right != null) {
					arrayList.add(node.right);
				}
			}
			if (i == end) {
				TreeNode treeNode = arrayList.get(end);
				arrayList2.add(treeNode.val);
				end = arrayList.size() - 1;
			}
		}
		return arrayList2;

	}

}