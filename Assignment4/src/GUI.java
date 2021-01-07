import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;
	private LinkedGrid<GUICell> cells;
	private Game game;
	
	public GUI (Game game, LinkedGrid<GUICell> cells) {
		super("Minesweeper Game");
		
		this.game = game;
		this.cells = cells;
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(game.getHeight(), game.getWidth()));

		setSize(700, 700);
		
		int ID = 0;
		GUICell lbl;
		for (int j = 0; j < game.getHeight(); j++) {
			for (int i = 0; i < game.getWidth(); i++) {
				lbl = cells.getElement(i, j);
				lbl.setName(String.valueOf(ID));
				lbl.setBackground(Color.gray);
				lbl.setBorder(BorderFactory.createLineBorder(Color.black));
				lbl.setOpaque(true);
				lbl.addMouseListener(this);
				panel.add(lbl);
				ID++;
			}
		}
		
		this.add(panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	
	public GUICell getCell (int c, int r) {
		return cells.getElement(c, r);
	}

	public String getCellColour (int c, int r) {
		GUICell lbl = getCell(c, r);
		if (lbl.getBackground().equals(Color.white)) {
			return "white";
		} else if (lbl.getBackground().equals(Color.black)) {
			return "black";
		} else {
			return "red";
		}
	}
	
	public void changeCellColour (int c, int r, Color colour) {
		getCell(c, r).setBackground(colour);
	}
	
	public void clickCell (GUICell btn) {
		game.processClick(btn.getCol(), btn.getRow());
	}
	
	public void rightClickCell (GUICell btn) {
		btn.rightClick();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Not necessary.
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Not necessary.
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Not necessary.
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Not necessary.
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		GUICell btn = null;
		
		if (e.getSource() instanceof GUICell) {
			btn = (GUICell)e.getSource();
		}
		
		
		if (e.getButton() == MouseEvent.BUTTON1) {
			// Left click.
			clickCell(btn);
			
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			rightClickCell(btn);
		}
	}

}
