
public class TestQueue {

	public static void main (String[] args) {

		// --------------- Test 1 --------------- [isEmpty and toString]

		CircularArrayQueue<String> Q = new CircularArrayQueue<String>();

		boolean test1Success = false;
		
		if (Q.isEmpty() && Q.toString().equals("The queue is empty")) {
			test1Success = true;
		}

		if (test1Success) {
			System.out.println("Test 1 passed");
		} else {
			System.out.println("Test 1 failed");
		}

		// --------------- Test 2 --------------- [enqueue and size]

		boolean test2Success = false;
		
		//System.out.println(queue);
		
		Q.enqueue("one");
		Q.enqueue("two");
		Q.enqueue("three");
		Q.enqueue("four");
		Q.enqueue("five");
		System.out.println(Q.toString());
		if (Q.size() == 5 && Q.toString().equals("QUEUE: one, two, three, four, five.")) {
			test2Success = true;
		}

		if (test2Success) {
			System.out.println("Test 2 passed");
		} else {
			System.out.println("Test 2 failed");
		}

		// --------------- Test 3 --------------- [expandCapacity and size]

		boolean test3Success = false;
		
		String[] letters = new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

		for (int i = 0; i < letters.length; i++) {
			Q.enqueue(letters[i]);
		}
		for (int i = 0; i < letters.length; i++) {
			Q.enqueue(letters[i].toLowerCase());
		}
		
		if (Q.getLength() == 60 && Q.size() == 57) {
			test3Success = true;
		}

		if (test3Success) {
			System.out.println("Test 3 passed");
		} else {
			System.out.println("Test 3 failed");
		}

		// --------------- Test 4 --------------- [dequeue]

		boolean test4Success = false;
		boolean t0 = false, t1 = false, t2 = false;
		String str = null;
		
		for (int i = 0; i < 5; i++) {
			str = Q.dequeue();
		}
		if (str.equals("five")) {
			t0 = true;
		}
		
		for (int i = 0; i < 26; i++) {
			str = Q.dequeue();
		}
		if (str.equals("Z") && Q.getFront() == 32 && Q.getRear() == 57) {
			t1 = true;
		}

		for (int i = 0; i < 13; i++) {
			Q.enqueue(Q.dequeue());
		}
		if (Q.getFront() == 45 && Q.getRear() == 10) {
			t2 = true;
		}

		if (t0 && t1 && t2) {
			test4Success = true;
		}

		if (test4Success) {
			System.out.println("Test 4 passed");
		} else {
			System.out.println("Test 4 failed");
		}

		// --------------- Test 5 --------------- [first]

		boolean test5Success = false;
		t0 = t1 = t2 = false;
		
		
		if (Q.first().equals("n")) {
			t0 = true;
		}
		
		for (int i = 0; i < 15; i++) {
			Q.dequeue();
		}

		if (Q.first().equals("c")) {
			t1 = true;
		}
		
		for (int i = 0; i < 11; i++) {
			Q.dequeue();
		}
		
		try {
			str = Q.first();
		} catch (EmptyCollectionException e) {
			t2 = true;
		}

		if (t0 && t1 && t2) {
			test5Success = true;
		}

		if (test5Success) {
			System.out.println("Test 5 passed");
		} else {
			System.out.println("Test 5 failed");
		}

	}


}
