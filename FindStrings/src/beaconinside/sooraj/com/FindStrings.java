package beaconinside.sooraj.com;

import java.util.*;

public class FindStrings {

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		// there should be only one argument
		if (args.length != 1) {
			System.out.println("Please provide an input number");
			System.exit(1);
		}
		
		String s = args[0];
		// check input string for correctness
		if (!s.matches("^[1-9]+$")) {
			System.out.println("Please provide a valid input number, numbers in the range [1-9]");
			System.exit(2);
		}
		FindStrings fs = new FindStrings();
		List<Integer> sub = new ArrayList<Integer>();
		fs.findSubString(s, sub, 0);
	}
	
	/**
	 * A recursive method to print all valid strings.
	 * Either a single character or pair of characters
	 * are considered before each call. The substrings are 
	 * checked for their ascii values before making further calls 
	 * 
	 * @param s original string
	 * @param sub integer list containing parsed character/a pair
	 * @param i current index to lookup
	 */
	public void findSubString(String s, List<Integer> sub, int i) {
		// if the string is parsed till end for a particular combination
		// then print it
		if (i >= s.length()) {
			for (int j=0; j<sub.size(); j++) {
				System.out.print(String.valueOf((char)(sub.get(j)+64)));
			}
			System.out.println();
			return;
		//take a single character first then a pair for the recursive call 	
		} else {
			List<Integer> sub1 = new ArrayList<Integer>(sub);
			List<Integer> sub2 = new ArrayList<Integer>(sub);
			sub1.add(Integer.parseInt(s.substring(i, i+1)));
			findSubString(s, sub1, i+1);
			if (i < s.length()-1) {
				int offset =  Integer.parseInt(s.substring(i, i+2));
				if (offset < 1 || offset > 26) {
	                return;
	        	}
				sub2.add(offset);
				findSubString(s, sub2, i+2);
			}
		}
	}
}
