/**
 * NPCObject.java:
 * This class represent the NPC(Zombie) behavior
 * @author Zihan Zhu
 */
public class NPCObject {
	/**Attribute:
	 * npcMoveQueue - queue of NPC using CircularArrayQueue
	 * cell - The current MapCell
	 * onTopOfCellType - The previous Cell type before NPC moves
	 * heroCollision - boolean indicate if the PC is hit
	 */
	private CircularArrayQueue<MapCell> npcMoveQueue;
	private MapCell cell;
	private MapCell.CellType onTopOfCellType;
	private boolean heroCollision;
	/**
	 * Construct of the class to create a new NPC and set startcell with cellType being "ZOMBIE"
	 * @param startcell;
	 */
	public NPCObject (MapCell startCell) {
		cell = startCell;
		onTopOfCellType = cell.getType();
		cell.setType(MapCell.CellType.ZOMBIE);
		npcMoveQueue = new CircularArrayQueue<MapCell>();
	}

	/**
	 * Finds the next cell that is the best path for the NPC to take.
	 * @param cell - the current cell where NPC locates
	 * @return the next best MapCell for NPC
	 */
	private MapCell singleMove(MapCell cell) {
		heroCollision = false;
		MapCell neighbour0 = cell.getNeighbour(0);
		MapCell neighbour1 = cell.getNeighbour(1);
		MapCell neighbour2 = cell.getNeighbour(2);
		MapCell neighbour3 = cell.getNeighbour(3);
		MapCell output = null;
		
		MapCell[] choice = new MapCell[4];
		choice[0] = neighbour0;
		choice[1] = neighbour1;
		choice[2] = neighbour2;
		choice[3] = neighbour3;
		
		int isHero = -1;
		int iscandy = -1;
		int iscrosspath = -1;
		int ishorizonpath = -1;
		int isverticalpath = -1;
		
		for (int index = 0; index < 4; index++) {
			MapCell currentcell = choice[index];
			if (currentcell == null) {
				continue;
			}
			if (currentcell.isHero() && isHero == -1) {
				isHero = index;
			}
			if (currentcell.isCandy() && canConnect(cell, currentcell, index) && iscandy == -1) {
				iscandy = index;
			}
			if (currentcell.isCrossPath() && canConnect(cell, currentcell, index) && iscrosspath == -1) {
				iscrosspath = index;
			}
			if (currentcell.isHorizontalPath() && canConnect(cell, currentcell, index) && ishorizonpath == -1) {
				ishorizonpath = index;
			}
			if (currentcell.isVerticalPath() && canConnect(cell, currentcell, index) && isverticalpath == -1) {
				isverticalpath = index;
			}
		}
		
		if (isHero != -1) {
			heroCollision = true;
			return choice[isHero];
		}
		else if (iscandy != -1) {
			return choice[iscandy];
		}
		else if (iscrosspath != -1) {
			return choice[iscrosspath];
		}
		else if (ishorizonpath != -1 || isverticalpath != -1) {
			if (ishorizonpath != -1 && isverticalpath != -1) {
				if (ishorizonpath < isverticalpath) {
					return choice[ishorizonpath];
				} else {
					return choice[isverticalpath];
				}
			}else {
					if (ishorizonpath != -1) {
						return choice[ishorizonpath];
					} else {
						return choice[isverticalpath];
					}
				}	
		} else {
			return output;
		}
	}
	/**
	 * Determine if the current cell can connect to the next cell
	 * @param main current cell
	 * @param neighbour the next available cell
	 * @param index the position of the next available cell
	 * @return a boolean whether the connection is reachable
	 */
	private boolean canConnect(MapCell main, MapCell neighbour, int index) {
		if (main.isCrossPath() || main.isStart() || main.isCandy()) {
			if (neighbour.isCrossPath()) {
				return true;
			}
			else if (neighbour.isHorizontalPath() && index == 1) {
				return true;
			}
			else if (neighbour.isHorizontalPath() && index == 3) {
				return true;
			}
			else if (neighbour.isVerticalPath() && index == 0) {
				return true;
			}
			else if (neighbour.isVerticalPath() && index == 2) {
				return true;
			} 
			else if (neighbour.isCandy()) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (main.isHorizontalPath()) {
			if (index == 0 || index == 2) {
				return false;
			}
			else if (neighbour.isCrossPath() || neighbour.isHorizontalPath() || neighbour.isCandy()) {
				return true;
			} else {
				return false;
			}
				
		}
		else if (main.isVerticalPath()) {
			if (index == 1 || index == 3) {
				return false;
			}
			else if (neighbour.isCrossPath() || neighbour.isVerticalPath() || neighbour.isCandy()) {
				return true;
			} else {
				return false;
			}
		} 
		else {
			return false;
		}
	}

	/**
	 * plan NPC moves 3 steps in advance
	 */
	public void queueMovePlan() {
		if (npcMoveQueue.isEmpty()) {
			MapCell current = this.cell;
			MapCell next;
			for (int i=0; i<3; i++) {
				next = singleMove(current);
				if(next!=null) {
					npcMoveQueue.enqueue(next);
					current = next;
				}
			}
		}
	}

	/**
	 * This represents the zombie moving
	 */
	public void move() {
		if(!npcMoveQueue.isEmpty()) {
			MapCell nextcell = npcMoveQueue.dequeue();
			cell.setType(onTopOfCellType);
			onTopOfCellType = nextcell.getType();
			//if (onTopOfCellType == MapCell.CellType.HERO) {
			//	heroCollision = true;
			//}
			cell = nextcell;
			cell.setType(MapCell.CellType.ZOMBIE);
		}
	}

	/**
	 * Check if NPC hits Hero
	 * @return a boolean showing heroCollision
	 */
	public boolean checkHeroCollision() {
		return heroCollision;
	}

	/**
	 * Gets the current Cell where NPC locates
	 * @return the MapCell
	 */
	public MapCell getCell() {
		return cell;
	}

	/**
	 * Gets the previous celltype before NPC locates
	 * @return the MapCell type
	 */
	public MapCell.CellType getCellType() {
		return onTopOfCellType;
	}
	
}
