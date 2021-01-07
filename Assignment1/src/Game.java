
/**
 *  Game.java:
 *  This class initialize the game
 * @author Zihan Zhu
 */
public class Game {
	/**Attribute:
	 * borad - The board of the game
	 * gui - The gui of the game
	 * isTesting - Indicates whether the game is to be run or not
	 * activeShipCount - The number of active cells taken up by the ships on this board
	 */
	private Board board;
	private GameGUI gui;
	private boolean isTesting;
	private int activeShipCount;
	
    /** Creates a new game 
     * @param gamemode Tells if the game is in play mode or not
     */
	public Game (boolean gamemode) {
		this.board = new Board(10, 10);
		this.activeShipCount = 0;
		if (gamemode) {
			// testing mode
			this.isTesting = true;
			
		} else {
			// play mode
			this.isTesting = false;
			ShipRandomizer.placeShips(this);
		}
	}
	
	//Instantiate the gui 	
	public void initializeGUI() {
		this.gui = new GameGUI(this.board.getGrid(), this.isTesting); 
	}
	
    /** Create a new ship 
     * @param oneship a ship on the board
     * @param sx the x coordinate position
     * @param sy the y coordinate position
     * @return true if the ship is added successfully, otherwise return false
     */
	boolean addShip (Ship oneship, int sx, int sy) {
		if (this.board.addShip(oneship, sx, sy)) {
			this.activeShipCount += 1;
			return true;
		} else {
			return false;
		}
	}
	
    /** Take a hit to the target
     * @param target user input for the cell guesses made in the game
     * 	Determine if the target is valid
     * @return an integer to represent the status of the attempted shot
     */
	public int shootTarget(String target) {
		if (Config.isValidTarget(target)) {
			int [] coordinates = Config.parseCell(target);
			int shipID = this.board.getCell(coordinates[1], coordinates[0]);
			if ((this.board.getCell(coordinates[1], coordinates[0])) == -1) {
				return 0;
			}
			if (this.board.checkDestroyedShip(shipID)) {
				this.activeShipCount --;
				if (this.activeShipCount == 0) {
					return 3;
				} else if (this.activeShipCount != 0){
					return 2;
				} 
			} else {
				return 1;
			}
		}
		return -1;
	}
}