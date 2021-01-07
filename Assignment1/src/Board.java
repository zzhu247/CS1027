/**
 *  Board.java:
 *  This class represents the board of the game to track all the ships
 * @author Zihan Zhu
 */
public class Board {
	/**Attribute:
	 * width - The width of the board
	 * height - The height of the board
	 * shipNum - The number of ships on the board
	 * ships - The ships on the board
	 * grid - The content of the borad
	 */
	private int width;
	private int height;
	private int shipNum;
	private Ship[] ships;
	private int[][] grid;
	
    /** Creates a new instance of saving account 
     * @param width the width of the board
     * @param height the height of the board
     */	
	public Board (int width, int height) {
		this.width = width;
		this.height = height;
		this.shipNum = 0;
		this.ships = new Ship[10];
		this.grid = new int[width][height];
		for (int i=0; i<width; i++) {
			for (int t=0; t<height; t++) {
				grid[i][t] = -1;
			}
		}
	}
	
    /** Creates a new ship
     * @param newship a ship on the board
     * @param sx the x coordinate position
     * @param sy the y coordinate position
     * @return a boolean to indicate the status from the attempted ship insertion
     */
	public boolean addShip (Ship newship, int sx, int sy) {
		if (this.shipNum > 9) {
			return false;
		}
		if (sx > this.width || sy > this.height || sx < 0 || sy < 0) {
			return false;
		}
		if ((sx+newship.getLength()) > this.width || (sy + newship.getWidth()) > this.height) {
			return false;
		}
		for (int p = 0; p < newship.getLength(); p++) {
			for (int q = 0; q < newship.getWidth(); q++) {
				if (this.grid[p+sx][q+sy] != -1) {
					return false;
				}
			}
		}
		
		for (int p = 0; p < newship.getLength(); p++) {
			for (int q = 0; q < newship.getWidth(); q++) {
				this.grid[p+sx][q+sy] = newship.getID();
			}
		}
		
		this.ships[shipNum] = newship;
		this.shipNum ++;
		return true;
		
	}

    /** Accessor method for grid
     * @return the grid
     */
	public int[][] getGrid() {
		return this.grid;
	}
	
    /** Accessor method for cell
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the coordinates of the cell
     */
	public int getCell(int x, int y) {
		return this.grid[x][y];
	}
	
    /** Check if the ship is destroyed
     * @param shipID the ID of the ship
     * @return true to indicate the ship is destroyed, otherwise return false
     */
	public boolean checkDestroyedShip (int shipID) {
		int n = shipNum;
		while ( n > 0) {
			n = n-1;
			if (ships[n].getID() == shipID) {
				ships[n].takeHit();
				if (ships[n].getRemainingCells() == 0) {
					return true;
				} 
			}
		}
		return false;
	}
}