/**
 *  StartSearch.java:
 *  This class implements the algorithm for Bryan to get candies with
 *  given path length and bag size.
 * @author Zihan Zhu
 */

import java.io.FileNotFoundException;
import java.io.IOException;

public class StartSearch {
	/**Attribute:
	 * neighbourhoodMap - the object representing the neighbourhood map
	 */
	private Map neighbourhoodMap;
	
    /** constructor for the class 
     *  @param filename name of the map
     *  @param maxPathLength the max length that Bryan can travel
     */	
	public StartSearch(String filename, int maxPathLength) {
		try {
			neighbourhoodMap = new Map(filename);
		}
		catch (InvalidMapException e) {
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
    /** main function to get the path for Bryan
     *  @param args input parameter, including map's name and maxPathLength
     */	
	public static void main(String[] args) {
		if (args.length == 1) {
			int numofcandies = nonargone(args[0]);
			System.out.println(numofcandies + "candies can be found!");
			return;
		}
		StartSearch path = new StartSearch(args[0], Integer.valueOf(args[1]));
		MapCell startpoint = path.neighbourhoodMap.getStart();
		ArrayStack<MapCell> BryanPath = new ArrayStack<MapCell>(); 
		
		int numofcandies = 0;
		int counter = 0;
		int maxCandyTake = path.neighbourhoodMap.bagSize();
 		int pathlength = Integer.valueOf(args[1]);
		BryanPath.push(startpoint);
		startpoint.markInStack();
		while (pathlength > counter && numofcandies < maxCandyTake && !BryanPath.isEmpty()) {
			MapCell currentpoint = BryanPath.peek();
			if (bestCell(currentpoint)!= null) {
				BryanPath.push(bestCell(currentpoint));
				bestCell(currentpoint).markInStack();
				counter ++;
				if (BryanPath.peek().isCandy()) {
					numofcandies ++;		
				}
			} else {
				try {
					BryanPath.peek().markOutStack();
					BryanPath.pop();
					counter++;
				} catch (EmptyStackException e) {
					System.out.println(numofcandies + " candies has been collected!");
					return;
				}	
			}
		}
		while (!BryanPath.isEmpty()) {
			try {
				BryanPath.peek().markOutStack();
				BryanPath.pop();
			} catch (EmptyStackException e) {
				System.out.println(numofcandies + " candies has been collected!");
			}
		}	
	}  
		
    /** get the number of candies reachable when maxpathlength is not given
     *  @param args input parameter, only the map's name
     */	
	private static int nonargone (String args) {
		StartSearch path = new StartSearch(args, 0);
		MapCell startpoint = path.neighbourhoodMap.getStart();
		ArrayStack<MapCell> BryanPath = new ArrayStack<MapCell>(); 
		int numofcandies = 0;
		BryanPath.push(startpoint);
		startpoint.markInStack();
		
		while (!BryanPath.isEmpty()) {
			MapCell currentpoint = BryanPath.peek();
			if (bestCell(currentpoint)!= null) {
				BryanPath.push(bestCell(currentpoint));
				bestCell(currentpoint).markInStack();
				if (BryanPath.peek().isCandy()) {
					numofcandies ++;
				}
			} else {
				try {
					BryanPath.peek().markOutStack();
					BryanPath.pop();
				} catch (EmptyStackException e) {
					System.out.println(numofcandies + " candies has been collected!");
				}
			}
		}
		return numofcandies;
		
	}
	
	/**
	 * compare all four neighbors of current cell to choose the best one
	 * @param cell  the current cell
	 * @return the best choice of next cell
	 */
	public static MapCell bestCell(MapCell cell) {
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
		
		int candycell = -1;
		int crosspath = -1;
		int horizontalpath = -1;
		int verticalpath = -1;
		
		for (int index = 0; index < 4; index ++) {
			MapCell currentcell = choice[index];
			if (currentcell == null || currentcell.isMarked()) {
				continue;
			}
			if (currentcell.isCandy() && canConnect(cell, currentcell, index) && candycell == -1) {
				candycell = index;
			}
			if (currentcell.isCrossPath() && canConnect(cell, currentcell, index) && crosspath == -1) {
				crosspath = index;
			}
			if (currentcell.isHorizontalPath() && canConnect(cell, currentcell, index) && horizontalpath == -1) {
				horizontalpath = index;
			}
			if (currentcell.isVerticalPath() && canConnect(cell, currentcell, index) && verticalpath == -1) {
				verticalpath = index;
			}
		}
		
		if(candycell != -1) {
			return choice[candycell];
		}
		else if (crosspath != -1) {
			return choice[crosspath];
		}
		else if (horizontalpath != -1 || verticalpath != -1) {
			if (horizontalpath != -1 && verticalpath != -1) {
				if (horizontalpath < verticalpath ) {
					return choice[horizontalpath];
				} else {
					return choice[verticalpath];
				}
			} else {
				if (horizontalpath != -1) {
					return choice[horizontalpath];
				} else {
					return choice[verticalpath];
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
	private static boolean canConnect(MapCell main, MapCell neighbour, int index) {
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

}