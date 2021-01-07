import java.util.Random;

public class ShipRandomizer {
	
	private static Random rnd = new Random();
	private static int[][] shipSizes = new int[][] {{5,1}, {4,1}, {3,1}, {3,1}, {2,1}};

	/**
	 * Randomly places each of the ships on the board.
	 * @param board
	 */

	public static void placeShips (Game game) {
		
		int dir, x, y, length, width;
		int[] shipDim;
		boolean[] success = new boolean[shipSizes.length];
		
		for (int i = 0; i < shipSizes.length; i++) {
			success[i] = false;
		}
		
		for (int i = 0; i < shipSizes.length; i++) {
			
			// If an attempted ship location is invalid (off-screen or overlapping another ship) then success[i] will be false so it tries again.
			while (success[i] == false) {
				dir = rnd.nextInt(2);
				x = rnd.nextInt(Config.BOARD_LENGTH);
				y = rnd.nextInt(Config.BOARD_WIDTH);
				shipDim = shipSizes[i];
				if (dir == 0) {
					// Across.
					length = shipDim[0];
					width = shipDim[1];
				} else {
					// Down.
					length = shipDim[1];
					width = shipDim[0];
				}

				Ship ship = new Ship(i*10+5,length,width); // IDs will be 5, 15, 25, etc.
				success[i] = game.addShip(ship, x, y);

			}
		}
		
	}

}
