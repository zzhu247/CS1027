
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.WindowConstants;
import javax.swing.text.StyleConstants;

public class GameGUI extends JFrame {
	
	private static Container contentPane;
	private int cellSize = 40;
	private JLabel[][] labels;
	private int[][] board;
	
	/**
	 * Constructor for GUI to set up the whole interface.
	 * @param gameBoard
	 * @param testing
	 */
	public GameGUI (int[][] gameBoard, boolean testing) {
		super("Battleship Game");
		
		board = gameBoard;
		int numRows = Config.BOARD_LENGTH, numCols = Config.BOARD_WIDTH;
		
		contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);

		setSize(numCols*cellSize + 47 + 40, numRows*cellSize + 65 + 40);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		ImageIcon icon;
		labels = new JLabel[numRows][numCols];

		JLabel numLbl;
		// Add numbers and letters along grid axes.
		for (int j = 0; j < numCols; j++) {
			numLbl = new JLabel(String.valueOf(j+1));
			numLbl.setSize(cellSize, cellSize);
			numLbl.setLocation(j*cellSize + 45, 0);
			numLbl.setHorizontalAlignment(JLabel.CENTER);
			contentPane.add(numLbl);
		}
		for (int i = 0; i < numRows; i++) {
			numLbl = new JLabel(String.valueOf(Config.letters[i]));
			numLbl.setSize(cellSize, cellSize);
			numLbl.setLocation(0, i*cellSize + 50);
			numLbl.setHorizontalAlignment(JLabel.CENTER);
			contentPane.add(numLbl);
		}

		JLabel cell;
		for (int j = 0; j < numCols; j++) {
			for (int i = 0; i < numRows; i++) {
				cell = new JLabel();
				cell.setSize(cellSize, cellSize);
				cell.setLocation(j*cellSize + 45, i*cellSize + 50);
				
				if (testing) {
					if (gameBoard[i][j] == -1) {
						cell.setBackground(Color.blue);
					} else {
						cell.setBackground(Color.gray);
					}
				} else {
					cell.setBackground(Color.blue);
				}

				cell.setOpaque(true);
				cell.setBorder(BorderFactory.createLineBorder(Color.black));
				labels[i][j] = cell;
				contentPane.add(cell);
			}
		}

		addWindowListener(new WindowAdapter( ) {
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}                
		}); 
		contentPane.setFocusable(true);
		contentPane.requestFocusInWindow();
		revalidate();
		repaint();
	}
	
	/**
	 * Checks if the chosen cell contains a ship or just water and indicates the result with a colour.
	 * @param r
	 * @param c
	 */
	public void updateCell (int r, int c) {
		if (board[r][c] == -1) {
			labels[r][c].setBackground(Color.red);
		} else {
			labels[r][c].setBackground(Color.green);
		}
		revalidate();
		repaint();
	}


}
