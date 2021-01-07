/**
 * AdvancedPlayerObject.java:
 * This class must inherit from Player object
 * @author Zihan Zhu
 */
public class AdvancedPlayerObject extends PlayerObject{
	/**Attribute
	 * collision - a boolean showing whether NPC can be smite by PC
	 */
	private boolean collision;

	/**
	 * Constructor of the class
	 * @param startCell - the cell 
	 */
	public AdvancedPlayerObject(MapCell startCell) {
		super(startCell);
		onTopOfCellType = MapCell.CellType.SUPERHERO;
	}

	/**
	 * check all neighbours to see if they are NPC objects
	 * @return the MapCell where there is a NPC nearby
	 */
	public MapCell getMove(MapCell newCell) {
		MapCell neighbour;
		MapCell neighbourOfneighbour;
		for (int i=0; i<3; i++) {
			try {
				neighbour = newCell.getNeighbour(i);
				if (neighbour == null) {
					continue;
				}
				if (neighbour.isZombie()) {
					collision = true;
					return neighbour;
				} else {
					continue;
				}
					
			} catch (InvalidNeighbourIndexException e) {
				System.out.println(e);
			}
		}
		neighbour = null;
		for (int i=0; i<=3; i++) {
			for (int t = 0; t<=3; t++) {
				if (newCell.getNeighbour(i) != null) {
					neighbourOfneighbour = newCell.getNeighbour(i).getNeighbour(t);
					if(neighbourOfneighbour == null) {
						continue;
					}
					if (neighbourOfneighbour.isZombie()) {
						collision = true;
						return neighbourOfneighbour;
					} else {
						continue;
					}
				} else {
					continue;
				}

			}
		}
		return neighbour;
	}

	/**
	 * This method is used to imitate ‘attacking’ one of the NPCs 
	 * once the Hero token has moved onto a candy tile
	 * @param zombieCell the Zombie Cell that is smite by the PC
	 * @param zombieArray the Zombie array
	 */
	public void smiteZombie(MapCell zombieCell, NPCObject[] zombieArray) {
		int arraylength = zombieArray.length;
		for (int i=0; i<arraylength; i++) {
			if (zombieArray[i] != null) {
				if (zombieCell == zombieArray[i].getCell()) {
					System.out.println("A Zombie is smote! ID is " + String.valueOf(zombieCell.getIdentifier()));
					zombieCell.setType(zombieArray[i].getCellType());
					zombieArray[i] = null;
					collision = false;
				}
			}
		}
	}

	/**
	 * Get the collision boolean
	 * @return the collision
	 */
	public boolean getCollision() {
		return this.collision;
	}
	
	/**
	 * End the SuperHero mode of the PC
	 */
	public void endSuperMode() {
		cell.setType(onTopOfCellType);
	}
}