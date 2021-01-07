/**
 *  Game.java:
 *  This class initialize the game
 * @author Zihan Zhu
 */
import java.awt.Color;

public class Game {
	/**Attribute:
	 * borad - The board of the game
	 * gui - The gui of the game
	 * cells - the infomation of the cell
	 * width - The width of the board ( number of columns)
	 * height - The height of the board ( number of rows)
	 */
	private LinkedGrid<Character> board;
	private LinkedGrid<GUICell> cells;
	public static int width;
	public static int height;
	private GUI gui;
	
    /** Creates a new game 
     * @param inputwidth the width of the board
     * @param inputheight the height of the board
     * @param fixedRandom a boolean value to set bomb randomly
     * @param showGUI start gui
     */
	public Game(int inputwidth, int inputheight, boolean fixedRandom, boolean showGUI) {
		width = inputwidth;
		height = inputheight;
		board = new LinkedGrid<Character>(width, height);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				board.setElement(i, j, '_');
			}
		}
		cells = new LinkedGrid<GUICell>(width, height);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				GUICell element = new GUICell(board.getElement(i, j), i, j);
				cells.setElement(i, j, element);
			}
		}
		BombRandomizer.placeBombs(board, fixedRandom);
		determineNumbers();
		
		if (showGUI) {
			gui = new GUI(this, cells);
		}
		
	}
	
    /** Creates a new game 
     * @param thisboard an existing borad
     * @param showGUI start gui
     */
	public Game (LinkedGrid<Character> thisboard, boolean showGUI) {
		board = thisboard;
		width = board.getWidth();
		height = board.getHeight();
		cells = new LinkedGrid<GUICell>(width, height);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				GUICell element = new GUICell(board.getElement(i, j), i, j);
				cells.setElement(i, j, element);
			}
		}
		determineNumbers();
		if (showGUI) {
			gui = new GUI(this, cells);
		}
		
	}
	
    /** Accessor method for width
     * @return the width
     */
	public int getWidth() {
		return width;
	}
	
    /** Accessor method for height
     * @return the height
     */
	public int getHeight() {
		return height;
	}
	
    /** Accessor method for cell
     * @return the cell
     */
	public LinkedGrid<GUICell> getCells() {
		return cells;
	}
	
    /** go through every single node in the board and calculate how many
     * bombs are in surrounding cells, and insert that number into the corresponding node in
     * the cells grid.
     */
	public void determineNumbers() {
		for (int i=0; i< width; i++) {
			for (int j=0; j<height; j++) {
				cells.getElement(i, j).setNumber(cellBombNum(i,j));
			}
		}
	}
	
    /** count the number of bombs around the cell
     * @param col - The width of the board ( number of columns)
	 * @param row - The height of the board ( number of rows)
     * @return an integer to represent the number of bombs around a particular cell
     */
	private int cellBombNum(int col, int row) {
		if (board.getElement(col, row) == 'x') {
			return -1;
		} else {
			int result = 0;
			
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if ( (col+i) < 0 || (col+i) >= width || (row+j) < 0 || (row+j) >= height) {
						continue;
					} 
					else if(i==0 && j==0) {
						continue;
					} else {
					
						if (board.getElement((col+i), (row+j)) == 'x') {
							result += 1;
						}
					}
				}
			}
		return result;
		}
	}
	
    /** a cell being clicked OR a simulated click and
     * returns an int value representing how many cells are being revealed or -1 if a bomb is
     * revealed
     * @param col - The width of the board ( number of columns)
	 * @param row - The height of the board ( number of rows)
     * @return an integer to represent the status
     */
	public int processClick(int col, int row) {
		if (cells.getElement(col, row).getNumber() == -1) {
			cells.getElement(col, row).setBackground(Color.red);
			cells.getElement(col, row).reveal();
			return -1;
		}
		else if (cells.getElement(col, row).getNumber()== 0) {
			return recClear(col, row);
		}
		else if (cells.getElement(col, row).getNumber() > 0 && cells.getElement(col, row).getNumber() <= 8) {
			if (cells.getElement(col, row).isRevealed()) {
				return 0;
			} else {
				cells.getElement(col, row).reveal();
				cells.getElement(col, row).setBackground(Color.white);
				return 1;
			}
		} else {
			return -2;
		}
	}
	
    /** the recursive helper method invoked from the processClick method
     * @param col - The width of the board ( number of columns)
	 * @param row - The height of the board ( number of rows)
     * @return an int representing the number of cells being revealed from the method call
     */
	private int recClear(int col, int row) {
		if (col < 0 || col >= width || row < 0 || row >= height) {
			return 0;
		}
		else if (cells.getElement(col, row).isRevealed()) {
			return 0;
		}
		else if (cells.getElement(col, row).getNumber() == -1) {
			return 0;
		}
		else if (cells.getElement(col, row).getNumber() > 0) {
			cells.getElement(col, row).reveal();
			if (gui != null) {
				cells.getElement(col, row).setBackground(Color.white);
			}
			return 1;
		} else {
			cells.getElement(col, row).reveal();
			if (gui != null) {
				cells.getElement(col, row).setBackground(Color.white);
			}
			int result = 1;
			result += recClear(col-1, row-1);
			result += recClear(col-1, row);
			result += recClear(col-1, row+1);
			result += recClear(col, row-1);
			result += recClear(col, row+1);
			result += recClear(col+1, row-1);
			result += recClear(col+1, row);
			result += recClear(col+1, row+1);
			return result;
		}
	}
	
	
}