/**
 *  LinkedGrid.java:
 *  This class represents a 2D grid that is created as an array of singly linked lists
 * @author Zihan Zhu
 */
public class LinkedGrid<T> {
	/**Attribute:
	 * width - The width of the board ( number of columns)
	 * height - The height of the board ( number of rows)
	 * grid - A 2D matrix
	 */
	private int width;
	private int height;
	private LinearNode<T>[] grid;
	
    /** Creates a 2D grid that is created as an array of singly linked lists
     * @param newwidth the width of the board
     * @param newheight the height of the board
     */	
	public LinkedGrid(int newwidth, int newheight) {
		width = newwidth;
		height = newheight;
		grid = new LinearNode[width];
		for (int i =0; i<width; i++) {
			LinearNode<T> newnode = new LinearNode();
			grid[i] = newnode;
			for (int j = 0; j < height; j++) {
				LinearNode<T> toAdd = new LinearNode();
				newnode.setNext(toAdd);
				newnode=newnode.getNext();
			}

		}
	}
	
    /** Adds dataItem to the top of the stack.
     *  @param col the number of columns
     *  @param row the number of rows
     *  @param data generic type of data
     *  @throws LinkedListException
	 *  			When the input of the row or column is invalid.
     */	
	public void setElement(int col, int row, T data) throws LinkedListException{
		if (col<0 || col >= width || row < 0 || row >= height) {
			throw new LinkedListException("Invalid row or col input");
		} 

		LinearNode<T> originalnode = grid[col];
		for (int i = 0; i < row; i++) {
			originalnode = originalnode.getNext();
		}
		originalnode.setElement(data);
	} 
	
    /** Adds dataItem to the top of the stack.
     *  @param col the number of columns
     *  @param row the number of rows
     *  @throws LinkedListException
	 *  			When the input of the row or column is invalid.
	 *  @return the element of the particular cell
     */	
	public T getElement(int col, int row) throws LinkedListException {
		if (col<0 || col >= width || row < 0 || row >= height) {
			throw new LinkedListException("Invalid row or col input");
		} 
		else if (grid[col] == null) {
			return null;
		} else {
			LinearNode<T> gridToUpdate = new LinearNode<T>();
			gridToUpdate = grid[col];
			while (row != 0) {
				gridToUpdate = gridToUpdate.getNext();
				row--;
			}
			if (gridToUpdate != null) {
				return gridToUpdate.getElement();
			} else {
				return null;
			}
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
	
	/**
	 * Returns a string representation of this grid.
	 * 
	 * @return String representation of this grid
	 */
	public String toString() {
		if (grid == null) {
			return "Empty grid";
		} else {
			LinearNode<T>[] copy = grid;
			String output = "";
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					if (grid[j].getElement() != null) {
						output += grid[j].getElement().toString() + "  ";
						grid[j] = grid[j].getNext();
					} else {
						output += "null  ";
					}
				}
				output += "\n";
			}
			grid = copy;
			return output;
		}
	}
	
}
