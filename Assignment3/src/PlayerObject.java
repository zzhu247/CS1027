
public class PlayerObject {
	
	protected ArrayStack<MapCell> movesStack = new ArrayStack<>();
	protected MapCell cell;
	protected MapCell.CellType onTopOfCellType;
	
	
	public PlayerObject(MapCell startCell) {
		
		cell = startCell;
		onTopOfCellType = MapCell.CellType.HERO;	
		
	}
	
	
	public ArrayStack<MapCell> getStack(){
		return this.movesStack;
	}
	
	public void move(MapCell newCell) {
		

		cell.setType(onTopOfCellType);
		onTopOfCellType = newCell.getType();
		this.movesStack.push(newCell);
		cell = newCell;
		cell.setType(MapCell.CellType.HERO);
	
		
	}
	
	public void popMove(MapCell poppedCell) {
		

		if(movesStack.isEmpty() == false) { 
			
			cell = movesStack.peek();
			
		}
		onTopOfCellType = cell.getType();
		cell.setType(MapCell.CellType.HERO);
		
	}
	
	

	// Make sure to use the onTopOfCell instead of the current cell when selecting a path!
	public MapCell getMove(MapCell cell) {

		MapCell neighbour;
		cell.setType(onTopOfCellType);
		
		/**
		 * First check to see if one of the candies is adjacent to us.
		 */
		for (int i = 0; i <= 3; i++) {

			try {

				neighbour = cell.getNeighbour(i);

				if (neighbour != null && !neighbour.isMarked() && neighbour.getType() != MapCell.CellType.ZOMBIE) {

					if (neighbour.isCandy()) {
						
						if (cell.isCandy()) {
							
							return neighbour;						
							
						} //end if

						if (cell.isCrossPath()) {

							return neighbour;

						} // end if

						else if (cell.isVerticalPath() && (i == 0 || i == 2)) {

							return neighbour;

						} // end else if

						else if (cell.isHorizontalPath() && (i == 1 || i == 3)) {

							return neighbour;

						} // end else if

						else if (cell.isStart() || cell.isHero()) {

							return neighbour;

						} // end else if

					} // end if

				} // end if

			} catch (InvalidNeighbourIndexException e) {

				System.out.println(e);

			} // end catch

		} // end for

		/**
		 * Next check if a cross path is adjacent to us.
		 */
		for (int i = 0; i <= 3; i++) {

			try {

				neighbour = cell.getNeighbour(i);

				if (neighbour != null && !neighbour.isMarked() && neighbour.getType() != MapCell.CellType.ZOMBIE) {

					if (neighbour.isCrossPath()) {
						
						if (cell.isCandy()) {
							
							return neighbour;						
							
						} //end if

						if (cell.isCrossPath()) {

							return neighbour;

						} // end if

						else if (cell.isVerticalPath() && (i == 0 || i == 2)) {

							return neighbour;

						} // end else if

						else if (cell.isHorizontalPath() && (i == 1 || i == 3)) {

							return neighbour;

						} // end else if

						else if (cell.isStart() || cell.isHero()) {

							return neighbour;

						} // end else if

					} // end if

				} // end if

			} catch (InvalidNeighbourIndexException e) {

				System.out.println(e);

			} // end catch

		} // end for

		/**
		 * Finally check if there is a horizontal or vertical path adjacent to us.
		 */
		for (int i = 0; i <= 3; i++) {

			try {

				neighbour = cell.getNeighbour(i);

				if (neighbour != null && !neighbour.isMarked() && neighbour.getType() != MapCell.CellType.ZOMBIE) {

					if ((i == 0 || i == 2) && neighbour.isVerticalPath()) {

						if (cell.isCandy() || cell.isCrossPath() || cell.isVerticalPath() || cell.isStart()) {

							return neighbour;

						} // end if

					} // end if

					else if ((i == 1 || i == 3) && neighbour.isHorizontalPath() && neighbour.getType() != MapCell.CellType.ZOMBIE) {

						if (cell.isCandy() || cell.isCrossPath() || cell.isHorizontalPath() || cell.isStart()) {

							return neighbour;

						} // end if

					} // end else if

				} // end if

			} catch (InvalidNeighbourIndexException e) {

				System.out.println(e);

			} // end catch

		} // end for
		
		return null;

	} // end bestCell

	
	
	
}
