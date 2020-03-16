package myTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javafx.util.Pair;
import pojo.TreeNode;

class Solution_7最大深度 {
	
	public static void main(String[] args) {
		
		TreeNode treeNode1 = new TreeNode(7);
		TreeNode treeNode2 = new TreeNode(15);
		TreeNode treeNode3 = new TreeNode(20);
		TreeNode treeNode4 = new TreeNode(9);
		TreeNode treeNode5 = new TreeNode(3);

		treeNode5.left = treeNode4;
		treeNode5.right = treeNode3;
		treeNode4.left = treeNode2;
		treeNode4.right = treeNode1;

		TreeNode.show(treeNode5);

		maxDepth_(treeNode5);
		
//		System.out.println(maxDepth(treeNode5));
	}
	
    public static int maxDepth(TreeNode root) {
    	ArrayList<Integer> arrayList = new ArrayList<>();
    	
    	maxDepth1(root,0,arrayList);
    	
    	if(arrayList.size()==0) {
    		return 0;
    	}
    	int a = 0;
    	for (Integer integer : arrayList) {
    		if(integer > a) {a = integer;}
    	}
		return a;
    	
        
    }

	public static int maxDepth2(TreeNode root) {

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

	private static void maxDepth1(TreeNode root, int i, ArrayList<Integer> arrayList) {
		
		i++;
		if(root!=null) {
			arrayList.add(i);
    		maxDepth1(root.left,i,arrayList);
    		maxDepth1(root.right,i,arrayList);
    	}
		
	}


//	时间复杂度：我们每个结点只访问一次，因此时间复杂度为 O(N)，
//	其中 NN 是结点的数量。
//	空间复杂度：在最糟糕的情况下，树是完全不平衡的，例如每个结点只剩下左子结点，递归将会被调用 NN 次（树的高度），因此保持调用栈的存储将是 O(N)。
//	但在最好的情况下（树是完全平衡的），树的高度将是 \log(N)。因此，在这种情况下的空间复杂度将是 O(\log(N))。
	public static int maxDepth_(TreeNode root) {//递归遍历 每次取mac 巧妙
			if (root == null) {
				return 0;
			} else {
				int left_height = maxDepth_(root.left);
				int right_height = maxDepth_(root.right);
				System.out.println(root.val);
				return java.lang.Math.max(left_height, right_height) + 1;
			}
		}


//	时间空间复杂度为 O(N) O(N)
//	class Solution_官方题解 {迭代记录深度
//		public int maxDepth(TreeNode root) {
//			Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
//			if (root != null) {
//				stack.add(new Pair(root, 1));
//			}
//
//			int depth = 0;
//			while (!stack.isEmpty()) {
//				Pair<TreeNode, Integer> current = stack.poll();
//				root = current.getKey();
//				int current_depth = current.getValue();
//				if (root != null) {
//					depth = Math.max(depth, current_depth);
//					stack.add(new Pair(root.left, current_depth + 1));
//					stack.add(new Pair(root.right, current_depth + 1));
//				}
//			}
//			return depth;
//		}
//	};



//	作者：LeetCode
//	链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode/
//	来源：力扣（LeetCode）
//	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}