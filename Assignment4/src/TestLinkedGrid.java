
public class TestLinkedGrid {

	public static void main (String[] args) {


		// --------------- Test 1 --------------- [constructor and getters]
		
		boolean test1Success = false;
		
		LinkedGrid<Integer> intGrid = new LinkedGrid<Integer>(5, 3);

		if (intGrid.getWidth() == 5 && intGrid.getHeight() == 3) {
			test1Success = true;
		}

		if (test1Success) {
			System.out.println("Test 1 passed");
		} else {
			System.out.println("Test 1 failed");
		}


		// --------------- Test 2 --------------- [setElement]

		boolean test2Success = false;

		try {
			intGrid.setElement(0, 0, 21);
			intGrid.setElement(1, 0, 34);
			intGrid.setElement(2, 0, 68);
			intGrid.setElement(3, 0, 37);
			intGrid.setElement(4, 0, 17);
			intGrid.setElement(0, 1, 56);
			intGrid.setElement(1, 1, 88);
			intGrid.setElement(2, 1, 30);
			intGrid.setElement(3, 1, 12);
			intGrid.setElement(4, 1, 72);
			intGrid.setElement(0, 2, 19);
			intGrid.setElement(1, 2, 33);
			intGrid.setElement(2, 2, 16);
			intGrid.setElement(3, 2, 92);
			intGrid.setElement(4, 2, 24);

			test2Success = true;
		} catch (LinkedListException e) {
			test2Success = false;
		}

		if (test2Success) {
			System.out.println("Test 2 passed");
		} else {
			System.out.println("Test 2 failed");
		}

		// --------------- Test 3 --------------- [setElement out of bounds]

		boolean t1 = false, t2 = false, t3 = false, t4 = false;
		
		try {
			intGrid.setElement(-1, 2, 15);
			t1 = false;
		} catch (LinkedListException e) { t1 = true; }
		catch (Exception e) { t1 = false; }
		
		try {
			intGrid.setElement(5, 2, 25);
			t2 = false;
		} catch (LinkedListException e) { t2 = true; }
		catch (Exception e) { t2 = false; }
		
		try {
			intGrid.setElement(2, -3, 35);
			t3 = false;
		} catch (LinkedListException e) { t3 = true; }
		catch (Exception e) { t3 = false; }
		
		try {
			intGrid.setElement(2, 4, 45);
			t4 = false;
		} catch (LinkedListException e) { t4 = true; }
		catch (Exception e) { t4 = false; }
		

		if (t1 && t2 && t3 && t4) {
			System.out.println("Test 3 passed");
		} else {
			System.out.println("Test 3 failed");
		}


		// --------------- Test 4 --------------- [getElement]

		boolean test4Success = false;
		
		try {
			int x = intGrid.getElement(0, 0);
			int y = intGrid.getElement(2, 1);
			int z = intGrid.getElement(4, 2);

			if (x == 21 && y == 30 && z == 24) {
				test4Success = true;
			} else {
				test4Success = false;
			}

		} catch (LinkedListException e) {
			test4Success = false;
		}
		
		if (test4Success) {
			System.out.println("Test 4 passed");
		} else {
			System.out.println("Test 4 failed");
		}

		// --------------- Test 5 --------------- [getElement out of bounds]

		t1 = t2 = t3 = t4 = false;
		
		try {
			intGrid.getElement(-1, 2);
			t1 = false;
		} catch (LinkedListException e) { t1 = true; }
		catch (Exception e) { t1 = false; }
		
		try {
			intGrid.getElement(5, 2);
			t2 = false;
		} catch (LinkedListException e) { t2 = true; }
		catch (Exception e) { t2 = false; }
		
		try {
			intGrid.getElement(2, -3);
			t3 = false;
		} catch (LinkedListException e) { t3 = true; }
		catch (Exception e) { t3 = false; }
		
		try {
			intGrid.getElement(2, 4);
			t4 = false;
		} catch (LinkedListException e) { t4 = true; }
		catch (Exception e) { t4 = false; }
		

		if (t1 && t2 && t3 && t4) {
			System.out.println("Test 5 passed");
		} else {
			System.out.println("Test 5 failed");
		}
		
		// --------------- Test 6 --------------- [toString]
		
		boolean test6Success = false;
		
		LinkedGrid<String> strGrid = new LinkedGrid<String>(1, 4);
		String str = strGrid.toString();

		test6Success = str.equals("null  \nnull  \nnull  \nnull  \n");
					
		if (test6Success) {
			System.out.println("Test 6 passed");
		} else {
			System.out.println("Test 6 failed");
		}
		
		// --------------- Test 7 --------------- [toString]
		
		boolean test7Success = false;
		
		str = intGrid.toString();

		test7Success = str.equals("21  34  68  37  17  \n56  88  30  12  72  \n19  33  16  92  24  \n");
			
		if (test7Success) {
			System.out.println("Test 7 passed");
		} else {
			System.out.println("Test 7 failed");
		}

	}
	
}
