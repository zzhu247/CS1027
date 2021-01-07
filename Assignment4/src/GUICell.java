import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GUICell extends JButton {
	
	private int row, col;
	private int number; 
	private String label;
	private ImageIcon icon;
	private boolean revealed;
	private boolean flagged;
	
	/**
	 * GUICell constructor
	 * @param element
	 * @param row
	 * @param col
	 */
	public GUICell (char element, int row, int col) {
		super();

		this.label = "";
		this.icon = null;
		this.row = row;
		this.col = col;
		this.revealed = false;
		this.flagged = false;
	}
	
	/**
	 * Getter for row
	 * @return row
	 */
	public int getRow () {
		return row;
	}
	
	/**
	 * Getter for column
	 * @return col
	 */
	public int getCol () {
		return col;
	}
	
	/**
	 * Getter for number (indicator of surrounding bomb cells)
	 * @return number
	 */
	public int getNumber () {
		return number;
	}

	/**
	 * Setter for number (indicator of surrounding bomb cells)
	 * @param number
	 */
	public void setNumber (int number) {

		if (number == -1) {
			//this.icon = new ImageIcon("bomb_40.png");
			this.icon = makeTile("bomb_40.png");
			this.label = "";
		} else {
			this.label = String.valueOf(number);
		}
		this.number = number;
	}
	
	/**
	 * Reveal the cell from a click or region clearing.
	 */
	public void reveal () {
		// Reveal bomb.
		if (number == -1) {
			super.setIcon(icon);
		}
		
		// Reveal cells with numbers.
		if (!label.equals("0") && !flagged) {
			super.setText(label);
		}
		revealed = true;
	}
	/**
	 * Check whether the cell is revealed already.
	 * @return
	 */
	public boolean isRevealed () {
		return revealed;
	}
	
	/**
	 * Toggle the cell between flagged or un-flagged.
	 */
	public void rightClick () {
		flagged = !flagged;
		if (flagged) {
			this.icon = makeTile("flag_40.png");
			super.setIcon(icon);
			super.setText("");
		} else {
			super.setIcon(null);
			super.setText(label);
		}
	}

	/**
	 * Load the icon and scale it based on the board size.
	 * @param imageFile
	 * @return
	 */
	private static ImageIcon makeTile (String imageFile) {
		ImageIcon icon = new ImageIcon(imageFile);
		Image img = icon.getImage();
		Image scaledImage = img.getScaledInstance(500/Game.width, 500/Game.height, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(scaledImage);
		return icon;
	}

	/**
	 * Return a formatted string of the cell's label.
	 * @return formatted string
	 */
	public String toString () {
		return String.format("%3s", label);
	}

}
