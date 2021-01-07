
public class TestGame {

	public static void main(String[] args) {
		
		Game game = new Game(true);

		// --------------- Test 1 ---------------

		boolean test1Success = false;

		Ship ship1 = new Ship(93, 5, 1);
		boolean res1 = game.addShip(ship1, 4, 7);
		
		//game.initializeGUI();

		if (res1) {
			test1Success = true;
		}

		if (test1Success) {
			System.out.println("Test 1 passed");
		} else {
			System.out.println("Test 1 failed");
		}


		// --------------- Test 2 ---------------

		boolean test2Success = false;

		Ship ship2 = new Ship(56, 1, 4);
		boolean res2 = game.addShip(ship2, 3, 2);
		
		//game.initializeGUI();

		if (res2) {
			test2Success = true;
		}

		if (test2Success) {
			System.out.println("Test 2 passed");
		} else {
			System.out.println("Test 2 failed");
		}

		// --------------- Test 3 ---------------

		boolean test3Success = false;

		Ship ship3 = new Ship(12, 4, 1);
		boolean res3 = game.addShip(ship3, 8, 3);
		
		//game.initializeGUI();

		if (!res3) {
			test3Success = true;
		}

		if (test3Success) {
			System.out.println("Test 3 passed");
		} else {
			System.out.println("Test 3 failed");
		}


		// --------------- Test 4 ---------------

		boolean test4Success = false;

		Ship ship4 = new Ship(49, 5, 1);
		boolean res4 = game.addShip(ship4, 0, 3);
		
		//game.initializeGUI();

		if (!res4) {
			test4Success = true;
		}

		if (test4Success) {
			System.out.println("Test 4 passed");
		} else {
			System.out.println("Test 4 failed");
		}

		// --------------- Test 5 ---------------

		boolean test5Success = false;

		Ship ship5 = new Ship(75, 2, 5);
		boolean res5 = game.addShip(ship5, 0, 4);
		
		//game.initializeGUI();

		if (res5) {
			test5Success = true;
		}

		if (test5Success) {
			System.out.println("Test 5 passed");
		} else {
			System.out.println("Test 5 failed");
		}
		
		
		// --------------- Test 6 ---------------

		boolean test6Success = false;

		int res6 = game.shootTarget("C7");

		if (res6 == 0) {
			test6Success = true;
		}

		if (test6Success) {
			System.out.println("Test 6 passed");
		} else {
			System.out.println("Test 6 failed");
		}


		// --------------- Test 7 ---------------

		boolean test7Success = false;

		int res7 = game.shootTarget("F12");

		if (res7 == -1) {
			test7Success = true;
		}

		if (test7Success) {
			System.out.println("Test 7 passed");
		} else {
			System.out.println("Test 7 failed");
		}

		// --------------- Test 8 ---------------

		boolean test8Success = false;


		int res8 = game.shootTarget("F4");

		if (res8 == 1) {
			test8Success = true;
		}

		if (test8Success) {
			System.out.println("Test 8 passed");
		} else {
			System.out.println("Test 8 failed");
		}


		// --------------- Test 9 ---------------

		boolean test9Success = false;

		game.shootTarget("E4");
		game.shootTarget("D4");
		int res9 = game.shootTarget("C4");
		if (res9 == 2) {
			test9Success = true;
		}

		if (test9Success) {
			System.out.println("Test 9 passed");
		} else {
			System.out.println("Test 9 failed");
		}

		// --------------- Test 10 ---------------

		boolean test10Success = false;

		game.shootTarget("E1");
		game.shootTarget("F1");
		game.shootTarget("G1");
		game.shootTarget("H1");
		game.shootTarget("I1");
		game.shootTarget("E2");
		game.shootTarget("F2");
		game.shootTarget("G2");
		game.shootTarget("H2");
		game.shootTarget("I2");
		
		game.shootTarget("H5");
		game.shootTarget("H6");
		game.shootTarget("H7");
		game.shootTarget("H8");
		int res10 = game.shootTarget("H9");

		if (res10 == 3) {
			test10Success = true;
		}

		if (test10Success) {
			System.out.println("Test 10 passed");
		} else {
			System.out.println("Test 10 failed");
		}


	}

}
