package myTest;

import java.util.*;

import pojo.TreeNode;
//二叉树的垂序遍历
class Solution_19二叉树的垂序遍历 {

	public static void main(String[] args) {

		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(5);
		TreeNode treeNode6 = new TreeNode(6);
		TreeNode treeNode7 = new TreeNode(7);

		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		treeNode2.left = treeNode4;
		treeNode2.right = treeNode5;
		treeNode3.left = treeNode6;
		treeNode3.right = treeNode7;

		treeNode6.left = new TreeNode(8);
		treeNode6.right = new TreeNode(9);
		treeNode5.left = new TreeNode(9);
		
		List<List<Integer>> list = verticalTraversal(treeNode1);
		System.out.println(list);

	}

	private static List<List<Integer>> verticalTraversal(TreeNode root) {
		
		List<List<Integer>> verticalTraversal = ssss(root);
		Iterator<List<Integer>> iterator = verticalTraversal.iterator();
		while (iterator.hasNext()) {
			List<Integer> next = iterator.next();
			if (next == null || next.isEmpty()) {
				iterator.remove();
			}
		}
		return verticalTraversal;
	}

	public static List<List<Integer>> ssss(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		List<Integer> root_1 = new ArrayList<>();
		root_1.add(root.val);
		list.add(root_1);
		Queue<List<TreeNode>> queue = new LinkedList<>();
		List<TreeNode> rootList = new ArrayList<>();
		rootList.add(root);
		queue.offer(rootList);
		while (!queue.isEmpty()) {
			boolean bb = true;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				List<TreeNode> cur_list = queue.poll();
				List<TreeNode> rootListLift_ = new ArrayList<>();
				List<TreeNode> rootListright_ = new ArrayList<>();
				for (TreeNode treeNode : cur_list) {
					if (treeNode.left != null) {
						rootListLift_.add(treeNode.left);
						bb = false;
					}
					if (treeNode.right != null) {
						rootListright_.add(treeNode.right);
						bb = false;
					}
				}
				if (i == 0) {
					queue.offer(rootListLift_);
					queue.offer(rootListright_);
				}
				if (i > 0) {
					Iterator<List<TreeNode>> iterator = queue.iterator();
					while (iterator.hasNext()) {
						List<TreeNode> next = iterator.next();
						if (!iterator.hasNext()) {
							next.addAll(rootListLift_);
						}
					}
					queue.offer(rootListright_);
				}
				if (i == size - 1) {
					if (bb) {
						return list;
					}
					Iterator<List<TreeNode>> iterator = queue.iterator();
					int j = 0;
					while (iterator.hasNext()) {
						List<TreeNode> next = iterator.next();
						List<Integer> next_i = new ArrayList<>();
						// 排序
						sort(next, next_i);
						if (j == 0 || j == list.size()) {
							list.add(j, next_i);
						} else {
							List<Integer> list2 = list.get(j);
							list2.addAll(next_i);
						}
						j += 2;
					}
				}
			}
		}
		return list;
	}

	private static void sort(List<TreeNode> next, List<Integer> next_i) {
		for (int a = 0; a < next.size(); a++) {
			int index = a;
			for (int b = a + 1; b < next.size(); b++) {
				if (next.get(b).val < next.get(index).val) {
					index = b;
				}
			}
			if (index != a) {
				TreeNode temp;
				temp = next.get(index);
				next.set(index, next.get(a));
				next.set(a, temp);
			}
				next_i.add(next.get(a).val);
		}
	}

//	class Solution_官方题解 {记录坐标 排序输出
//		List<Location> locations;
//		public List<List<Integer>> verticalTraversal(TreeNode root) {
//			// Each location is a node's x position, y position, and value
//			locations = new ArrayList();
//			dfs(root, 0, 0);
//			Collections.sort(locations);
//
//			List<List<Integer>> ans = new ArrayList();
//			ans.add(new ArrayList<Integer>());
//
//			int prev = locations.get(0).x;
//
//			for (Location loc: locations) {
//				// If the x value changed, it's part of a new report.
//				if (loc.x != prev) {
//					prev = loc.x;
//					ans.add(new ArrayList<Integer>());
//				}
//
//				// We always add the node's value to the latest report.
//				ans.get(ans.size() - 1).add(loc.val);
//			}
//
//			return ans;
//		}
//
//		public void dfs(TreeNode node, int x, int y) {
//			if (node != null) {
//				locations.add(new Location(x, y, node.val));
//				dfs(node.left, x-1, y+1);
//				dfs(node.right, x+1, y+1);
//			}
//		}
//	}
//
//	class Location implements Comparable<Location>{
//		int x, y, val;
//		Location(int x, int y, int val) {
//			this.x = x;
//			this.y = y;
//			this.val = val;
//		}
//
//		@Override
//		public int compareTo(Location that) {
//			if (this.x != that.x)
//				return Integer.compare(this.x, that.x);
//			else if (this.y != that.y)
//				return Integer.compare(this.y, that.y);
//			else
//				return Integer.compare(this.val, that.val);
//		}
//	}
//
//	作者：LeetCode
//	链接：https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/solution/er-cha-shu-de-chui-xu-bian-li-by-leetcode-2/
//	来源：力扣（LeetCode）
//	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}