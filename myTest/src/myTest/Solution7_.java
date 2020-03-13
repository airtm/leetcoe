package myTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pojo.TreeNode;

public class Solution7_ {
	    class MyNode{
	        int x, y, val;
	        MyNode(int x, int y, int val){
	            this.x = x;
	            this.y = y;
	            this.val = val;
	        }
	    }
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
			
			Solution7_ solution7_ = new Solution7_();
			List<List<Integer>> list = solution7_.verticalTraversal(treeNode1);
			System.out.println(list);

		}

	    public List<List<Integer>> verticalTraversal(TreeNode root) {
	        List<List<Integer>> list = new ArrayList<>();
	        if(root==null)  return list;
	        List<MyNode> nodes = new ArrayList<>();
	        int[] bound = new int[2];
	        preorder(root, 0, 0, nodes);
	        Collections.sort(nodes, new Comparator<MyNode>(){
	            public int compare(MyNode mn1, MyNode mn2){
	                if(mn1.x!=mn2.x)    return mn1.x-mn2.x;
	                if(mn1.y!=mn2.y)    return mn2.y-mn1.y;
	                return mn1.val-mn2.val;
	            }
	        });
	        int lastx = Integer.MIN_VALUE;
	        for(int i = 0; i < nodes.size(); ++i){
	            MyNode node = nodes.get(i);
	            if(node.x==lastx) {
	            	list.get(list.size()-1).add(node.val);
	            }else{
	                List<Integer> tlist = new ArrayList<>();
	                tlist.add(node.val);
	                list.add(tlist);
	                lastx = node.x;
	            }
	        }
	        return list;
	    }
	    
	    private void preorder(TreeNode root, int x, int y, List<MyNode> nodes){
	        if(root==null)  return;
	        nodes.add(new MyNode(x, y, root.val));
	        preorder(root.left, x-1, y-1, nodes);
	        preorder(root.right, x+1, y-1, nodes);
	    }
}
