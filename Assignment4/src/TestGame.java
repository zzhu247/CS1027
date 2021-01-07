
public class TestGame {

	public static void main (String[] args) {

		Game game1 = null, game2 = null;
		boolean t1, t2, t3;
		
		// --------------- Test 1 --------------- [constructors and initializations]
		
		boolean test1Success = false;

		try {
			game1 = new Game(GameLayout(), false);
			game2 = new Game(20, 20, true, false);
			test1Success = true;
		} catch (Exception e) {
			test1Success = false;
		}

		if (test1Success) {
			System.out.println("Test 1 passed");
		} else {
			System.out.println("Test 1 failed");
		}


		// --------------- Test 2 --------------- [determine numbers]

		boolean test2Success = false;

		LinkedGrid<GUICell> cells1 = game1.getCells();

		t1 = cells1.getElement(1, 2).getNumber() == 0;
		t2 = cells1.getElement(3, 3).getNumber() == -1;
		t3 = cells1.getElement(4, 2).getNumber() == 8;
		
		test2Success = t1 && t2 && t3;

		if (test2Success) {
			System.out.println("Test 2 passed");
		} else {
			System.out.println("Test 2 failed");
		}

		// --------------- Test 3 --------------- [determine numbers]

		boolean test3Success = false;

		LinkedGrid<GUICell> cells2 = game2.getCells();
		
		t1 = cells2.getElement(12, 2).getNumber() == 3;
		t2 = cells2.getElement(18, 16).getNumber() == 1;
		t3 = cells2.getElement(3, 3).getNumber() == 0;
		
		test3Success = t1 && t2 && t3;

		if (test3Success) {
			System.out.println("Test 3 passed");
		} else {
			System.out.println("Test 3 failed");
		}


		// --------------- Test 4 --------------- [process click (recursion)]

		boolean test4Success = false;

		int numCells = game2.processClick(13, 1);
		t1 = numCells == 1;
		numCells = game2.processClick(18, 7);
		t2 = numCells == 1;
		numCells = game2.processClick(18, 7);
		t3 = numCells == 0;
		
		test4Success = t1 && t2 && t3;


		if (test4Success) {
			System.out.println("Test 4 passed");
		} else {
			System.out.println("Test 4 failed");
		}

		// --------------- Test 5 --------------- [process click (recursion)]

		boolean test5Success = false;

		numCells = game2.processClick(4, 1);
		t1 = numCells == 105;
		numCells = game2.processClick(10, 19);
		t2 = numCells == 30;
		
		test5Success = t1 && t2;

		if (test5Success) {
			System.out.println("Test 5 passed");
		} else {
			System.out.println("Test 5 failed");
		}
		
		
		// --------------- Test 6 --------------- [process click (recursion)]

		boolean test6Success = false;

		numCells = game2.processClick(17, 14);
		test6Success = numCells == -1;

		if (test6Success) {
			System.out.println("Test 6 passed");
		} else {
			System.out.println("Test 6 failed");
		}

	}
	
	

	
	public static LinkedGrid<Character> GameLayout () {
		LinkedGrid<Character> board = new LinkedGrid<Character>(7, 7);

		// Default board.
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				board.setElement(i, j, '_');
			}
		}
		// Add bombs.
		board.setElement(3, 5, 'x');
		board.setElement(3, 6, 'x');
		board.setElement(2, 5, 'x');
		board.setElement(1, 4, 'x');
		board.setElement(6, 3, 'x');
		board.setElement(6, 4, 'x');
		
		board.setElement(3, 1, 'x');
		board.setElement(4, 1, 'x');
		board.setElement(5, 1, 'x');
		board.setElement(5, 2, 'x');
		board.setElement(5, 3, 'x');
		board.setElement(4, 3, 'x');
		board.setElement(3, 3, 'x');
		board.setElement(3, 2, 'x');
		
		return board;
	}

}
