
public class Config {
	
	public static int BOARD_LENGTH = 10;
	public static int BOARD_WIDTH = 10;
	public static char[] letters = new char[] {'A','B','C','D','E','F','G','H','I','J'};
	
	/**
	 * Check if the given target is a valid cell in the board.
	 * @param target
	 * @return
	 */
	public static boolean isValidTarget (String target) {
		if (target.length() < 2) return false;
		
		try {
		
			target = target.toUpperCase();
			
			char c1 = target.charAt(0);
			String c2 = target.substring(1);
			int i2 = Integer.parseInt(c2);
	
			
			if ((c1 >= 'A' && c1 <= 'J') && (i2 >= 1 && i2 <= 10)) {
				return true;
			} else {
				return false;
			}
		
		} catch (NumberFormatException e) {
			return false;
		}

	}
	
	/**
	 * Parse the given target string to grid coordinates.
	 * @param target
	 * @return
	 */
	public static int[] parseCell (String target) {
		target = target.toUpperCase();
		char c1 = target.charAt(0);
		String c2 = target.substring(1);
		int i2 = Integer.parseInt(c2);
		int i1 = -1;
		for (int i = 0; i < letters.length; i++) {
			if (letters[i] == c1) {
				i1 = i;
			}
		}
		i2 = i2 - 1;
		
		return new int[] {i1, i2};
		
	}
}
