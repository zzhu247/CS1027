import java.util.Scanner;

public class Play {
	
	private Game game;
	
	/**
	 * Constructor for the Play class to play a game of Battleship.
	 */
	public Play () {
		game = new Game(false);
		game.initializeGUI();
		beginGame();
	}
	
	/**
	 * Runs the user input system for playing a game.
	 */
	public void beginGame () {

		String target;   
		
		try {

			Scanner in = new Scanner(System.in);

			do {

				System.out.println("Enter a cell (i.e. A1) to try to hit a ship, or type \"quit\" to end the game: ");
				target = in.nextLine();

				if (!target.equals("quit")) {
					if (Config.isValidTarget(target)) {
						int result = game.shootTarget(target);
						switch (result) {
							case 0:
								System.out.println("Miss");
								break;
							case 3:
								System.out.println("You win!");
								break;
							case 2:
								System.out.println("You sunk a ship!");
								break;
							case 1:
								System.out.println("Hit!");
								break;
						}
					} else {
						System.out.println("Invalid target cell");
					}
				}

				System.out.println();
			} while (!target.equalsIgnoreCase("quit"));
			
			in.close();
			
		} catch (Exception IOException) {
			System.out.println("Input exception reported");
			IOException.printStackTrace();
		}
	}
	
	/**
	 * The entry point for the game mode.
	 * @param args
	 */
	public static void main(String[] args) {
		new Play();
	}
	

}
