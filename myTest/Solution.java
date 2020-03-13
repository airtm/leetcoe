package myTest;

import java.util.ArrayList;
import java.util.List;

import pojo.TreeNode;

class Solution {
	
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
		
		List<TreeNode> arrayList = new ArrayList<>();
		arrayList.add(treeNode5);
		for (TreeNode treeNode : arrayList) {
			System.err.println(treeNode);
		}
		
		
		
		System.out.println(maxDepth(treeNode5));
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

	private static void maxDepth1(TreeNode root,int i, ArrayList<Integer> arrayList) {
		
		i++;
		if(root!=null) {
			arrayList.add(i);
    		maxDepth1(root.left,i,arrayList);
    		maxDepth1(root.right,i,arrayList);
    	}
		
	}
}