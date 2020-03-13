package myTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import pojo.TreeNode;

class Solution_7 {

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
	
	public static boolean maxDepth(TreeNode root) {
		if (root == null) {
			return true;
		}
		int end = 0;
		ArrayList<TreeNode> arrayList = new ArrayList<>();
		arrayList.add(root);
		int ll = 0;
		for (int i = 0; i < arrayList.size(); i++) {
			TreeNode node = arrayList.get(i);
			if (node != null) {
				if (node.left != null) {
					arrayList.add(node.left);
				} else {
					arrayList.add(null);
				}
				if (node.right != null) {
					arrayList.add(node.right);
				} else {
					arrayList.add(null);
				}
			}
			if (i == end) {
				int b = 0;
				int a = ll;
				ll = end;
				if (i != 0) {
					for (int j = a; j < ll; j++) {
						if ((ll - a) % 2 != 0) {
							return false;
						}
						if (j - a + 1 > ((ll - a) / 2)) {
							break;
						}
						if (arrayList.get(j + 1) == null && arrayList.get(ll - (j - a)) == null) {
							b++;
							if( b >= (ll - a) / 2 ) {
								return true;
							}
							continue;
						} else if (arrayList.get(j + 1) != null && arrayList.get(ll - (j - a)) != null) {
							Integer v = arrayList.get(j + 1).val;
							Integer vv = arrayList.get(ll - (j - a)).val;
							if (v != vv) {
								return false;
							}
						} else {
							return false;
						}
					}
				}
				end = arrayList.size() - 1;
			}
		}
		return true;

	}

}