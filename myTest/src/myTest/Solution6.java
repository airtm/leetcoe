package myTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import pojo.Foo;
import pojo.TreeNode;

class Solution6 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

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

		// treeNode6.left = new TreeNode(8);
		// treeNode6.right = new TreeNode(9);
		// treeNode5.left = new TreeNode(9);
		// treeNode5.right = new TreeNode(8);
		// sum(treeNode1);\
//		Foo foo = new Foo(1);
//		FileOutputStream fs = new FileOutputStream("foo.ser");
//		ObjectOutputStream os = new ObjectOutputStream(fs);
//		os.writeObject(foo);
//		System.err.println(os);

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("foo.ser"));

		Foo box = (Foo) (in.readObject());

		System.out.println(box.toString());

	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		return null;

	}

	public static int sum(TreeNode root) {
		if (root != null) {
			int a = sum(root.left);
			int b = sum(root.right);
			System.err.println(root.val + "|" + root.val + a);

			return root.val;
		}
		return 0;

		// return root.val;

	}

}