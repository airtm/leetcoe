package myTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import pojo.TreeNode;

public class Snippet {

	public static void main(String[] args) {
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
		System.err.println(maxDepth1(bt1));

	}

	public static int maxDepth1(TreeNode root) {

		int depth = 0;
		if (root == null) {
			return depth;
		}
		List<TreeNode> list = new ArrayList<>();
		list.add(root);

		int end = 0;
		for (int i = 0; i < list.size(); i++) {
			TreeNode treeNode = list.get(i);
			if (treeNode.left != null) {
				list.add(treeNode.left);
			}
			if (treeNode.right != null) {
				list.add(treeNode.right);
			}
			if (i == end) {
				depth++;
				end = list.size() - 1;
			}
		}

		return depth;
	}
}
