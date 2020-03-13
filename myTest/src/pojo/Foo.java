package pojo;

import java.io.Serializable;

public class Foo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7489772824284948614L;
	public int val;
	public int val1;
	public int val2;
	public TreeNode left;
	
	public Foo(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "Foo [val=" + val + ", val1=" + val1 + ", val2=" + val2 + ", left=" + left + "]";
	}

}
