import java.util.HashMap;

public class StringCounter {
	
	static String[] data = {"one", "two", "three", "one", "ololo", "one", "two", "another", "one", "four"}; // ok, 'one' - 4
//	static String[] data = {}; // not ok, exception
//	static String[] data = {"one", "two", "three"}; // not ok, exception
//	static String[] data = {"two", "three", "one", "ololo", "two", "another", "one", "four"}; // not ok, exception
//	static String[] data = {"two", "three", "one", "ololo", "two", "another", "one", "four", "one"}; // ok, 'one' - 3
//	static String[] data = {"one"}; // ok, 'one' - 1

	public static void main(String[] args) throws Exception {
		HashMap<String, Integer> originalMap = new HashMap<String, Integer>();
		
		for (int i = 0; i < data.length; i++) {
			if (originalMap.containsKey((data[i]))) {
				originalMap.put(data[i], originalMap.get(data[i]) + 1);
			}
			else {
				originalMap.put(data[i], 1);
			}
		}
		System.out.println("Original map:");
		System.out.println(originalMap);
		
		int max = 0;
		String maxString = null;
		boolean doubleMax = true;
		
		for (String str: originalMap.keySet()) {
			int value = originalMap.get(str);
			if (value > max) {
				max = value;
				maxString = str;
				doubleMax = false;
			}
			else if (value == max) {
				doubleMax = true;
			}
		}
		if (doubleMax) {
			throw new Exception("No best candidate");
		}
		
		System.out.println("Most popular line:");
		System.out.println(maxString);
		System.out.println("Number of entries:");
		System.out.println(max);
	}

}
