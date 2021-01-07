
public class TestStack {

	public static void main(String[] args) {
		
		ArrayStack<String> S = new ArrayStack<String>(4);
				
		if (S.isEmpty()) {
			System.out.println("Test 1 passed - isEmpty()");
		} else {
			System.out.println("Test 1 failed - isEmpty()");
		}
		
		S.push("one");
		S.push("two");
		S.push("three");
		S.push("four");
		S.push("five");
		S.push("six");
		S.push("seven");
		S.push("eight");
		S.push("nine");
		
		if (S.size() == 9) {
			System.out.println("Test 2 passed - size()");
		} else {
			System.out.println("Test 2 failed - size()");
		}
		
		
		String firstElem = S.peek();
		if (firstElem.equals("nine")) {
			System.out.println("Test 3 passed - first()");
		} else {
			System.out.println("Test 3 failed - first()");
		}
		
		// Pop several elements.
		for (int i = 0; i < 5; i++) {
			S.pop();
		}

		firstElem = S.peek();
		if (firstElem.equals("four")) {
			System.out.println("Test 4 passed - first()");
		} else {
			System.out.println("Test 4 failed - first()");
		}
		
		String toStr = S.toString();
		//System.out.println(S);
		
		if (toStr.equals("Stack: four, three, two, one.")) {
			System.out.println("Test 5 passed - toString()");
		} else {
			System.out.println("Test 5 failed - toString()");
		}
		
		// Pop the remaining elements.
		for (int i = 0; i < 4; i++) {
			S.pop();
		}

		toStr = S.toString();
		//System.out.println(S);

		if (toStr.equals("The stack is empty.")) {
			System.out.println("Test 6 passed - toString()");
		} else {
			System.out.println("Test 6 failed - toString()");
		}
		
	}

}