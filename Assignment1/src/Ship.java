/**
 *  Ship.java:
 *  This class creates a ship in the game
 * @author Zihan Zhu
 */
public class Ship {
	/**Attribute:
	 * ID - The ID of the ship
	 * length - The number of horizontal cells the ship takes up
	 * width - The number of vertical cells the ship takes up
	 * remainingCells - The number of remaining cells taken up by the ship
	 */
	private int ID;
	private int length;
	private int width;
	private int remainingCells;
	
    /** Creates a new ship 
     * @param ID The ID of the ship
     * @param length The length of the ship
     * @param width The width of the ship
     */
	public Ship (int ID, int length, int width) {
		this.ID = ID;
		this.length = length;
		this.width = width;
		this.remainingCells = length * width;
	}
	
	/**
	 * Accessor method to get the ID of the ship
	 * @return the ID of the ship
	 */
	public int getID() {
		return this.ID;
	}
	
	/**
	 * Accessor method to get the length of the ship
	 * @return the length of the ship
	 */
	public int getLength() {
		return this.length;
	}
	
	/**
	 * Accessor method to get the width of the ship
	 * @return the width of the ship
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * Accessor method to get the remaining cells of the ship
	 * @return the remaining cells of the ship
	 */
	public int getRemainingCells() {
		return this.remainingCells;
	}
	
    /** Decrease the remaining cells by 1
     * 	every time it takes a hit
     */	
	public void takeHit() {
		this.remainingCells -= 1;
	}
	
}