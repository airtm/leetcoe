package myTest;

import java.util.*;

import pojo.TreeNode;

//二叉树的右视图
class Solution_14二叉树的右视图 {

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

		TreeNode.show(treeNode1);
		System.out.println(rightSideView(treeNode1));
	}

	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> resul = new ArrayList<>();
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
				resul.add(treeNode.val);
				end = arrayList.size() - 1;
			}
		}
		return resul;

	}


//	class Solution_ {深度优先  栈
//		public List<Integer> rightSideView(TreeNode root) {
//			Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
//			int max_depth = -1;
//
//			/* These two stacks are always synchronized, providing an implicit
//			 * association values with the same offset on each stack. */
//			Stack<TreeNode> nodeStack = new Stack<TreeNode>();
//			Stack<Integer> depthStack = new Stack<Integer>();
//			nodeStack.push(root);
//			depthStack.push(0);
//
//			while (!nodeStack.isEmpty()) {
//				TreeNode node = nodeStack.pop();
//				int depth = depthStack.pop();
//
//				if (node != null) {
//					max_depth = Math.max(max_depth, depth);
//
//					/* The first node that we encounter at a particular depth contains
//					 * the correct value. */
//					if (!rightmostValueAtDepth.containsKey(depth)) {
//						rightmostValueAtDepth.put(depth, node.val);
//					}
//
//					nodeStack.push(node.left);
//					nodeStack.push(node.right);
//					depthStack.push(depth+1);
//					depthStack.push(depth+1);
//				}
//			}
//
//			/* Construct the solution based on the values that we end up with at the
//			 * end. */
//			List<Integer> rightView = new ArrayList<Integer>();
//			for (int depth = 0; depth <= max_depth; depth++) {
//				rightView.add(rightmostValueAtDepth.get(depth));
//			}
//
//			return rightView;
//		}
//	}
//
//	作者：LeetCode
//	链接：https://leetcode-cn.com/problems/binary-tree-right-side-view/solution/er-cha-shu-de-you-shi-tu-by-leetcode/
//	来源：力扣（LeetCode）
//	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//	class Solution_ {广度优先 双向队列
//		public List<Integer> rightSideView(TreeNode root) {
//			Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
//			int max_depth = -1;
//
//			/* These two Queues are always synchronized, providing an implicit
//			 * association values with the same offset on each Queue. */
//			Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
//			Queue<Integer> depthQueue = new LinkedList<Integer>();
//			nodeQueue.add(root);
//			depthQueue.add(0);
//
//			while (!nodeQueue.isEmpty()) {
//				TreeNode node = nodeQueue.remove();
//				int depth = depthQueue.remove();
//
//				if (node != null) {
//					max_depth = Math.max(max_depth, depth);
//
//					/* The last node that we encounter at a particular depth contains
//					 * the correct value, so the correct value is never overwritten. */
//					rightmostValueAtDepth.put(depth, node.val);
//
//					nodeQueue.add(node.left);
//					nodeQueue.add(node.right);
//					depthQueue.add(depth+1);
//					depthQueue.add(depth+1);
//				}
//			}
//
//			/* Construct the solution based on the values that we end up with at the
//			 * end. */
//			List<Integer> rightView = new ArrayList<Integer>();
//			for (int depth = 0; depth <= max_depth; depth++) {
//				rightView.add(rightmostValueAtDepth.get(depth));
//			}
//
//			return rightView;
//		}
//	}
//
//	作者：LeetCode
//	链接：https://leetcode-cn.com/problems/binary-tree-right-side-view/solution/er-cha-shu-de-you-shi-tu-by-leetcode/
//	来源：力扣（LeetCode）
//	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}