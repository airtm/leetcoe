package myTest;


import java.util.HashMap;
import java.util.Map;

public class main {

	public static void main(String[] args) {
		Map<String,Integer> result = new HashMap<>(1);
		aa(result);
		System.err.println(result);
	}

	public static void aa(Map<String,Integer> result){
		result.put("2",1);
		result.put("3",3);
	}
	
}
