import java.io.*;

public class Permutations {
	private static char currentchar;
	private static String pre = "";
	private static String suff = "";
	
	public static void permutations(String prefix,String suffix) {
		if (suffix.length() == 0 ) {
			System.out.println(prefix);
			pre = "";
			suff = "";
		}

		for (int i = 0; i< suffix.length(); i++) {
			currentchar = suffix.charAt(i);
			suff = removeChar(suffix, i);
			pre = prefix+ currentchar;
			permutations(pre,suff);
		}
	}

	private static String removeChar(String s, int i) {
		return s.substring(0, i) + s.substring(i+1, s.length());
	}
	
	public static void main(String args[]) throws Exception {
		String input;
		System.out.println("Enter a string (enter enter to quit): ");
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in), 1);
        System.out.print("Enter a string: ");
        input = keyboard.readLine();
        
        permutations("", input);
	}

}
