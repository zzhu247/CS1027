import java.io.FileNotFoundException;
import java.io.IOException;

public class StartSearch {

	private Map townMap;
	public static String sequence;
	

	public StartSearch (String filename) {

		try {

			townMap = new Map(filename);

		} catch (InvalidMapException e) {

			System.out.println(e);

		} catch (FileNotFoundException e) {

			System.out.println(e);

		} catch (IOException e) {

			System.out.println(e);

		} //end try/catch

	} // end StartSearch

	

	public Map getTownMap() {

		return townMap;

	} // end getTownMap

	public static void main(String[] args) {

		int playerPathLength=Integer.MAX_VALUE;
		int numZombies = 0;
		boolean zombiesMove = true;
		boolean superHero = false;
		boolean eaten = false;
		
		
		if(args.length > 1 ) {
			
			playerPathLength = Integer.parseInt(args[1]);
			numZombies = Integer.parseInt(args[2]);
			
		}
		
		StartSearch search = new StartSearch(args[0]);
		PlayerObject player = new PlayerObject(search.getTownMap().getStart());
		NPCObject[] zombies = new NPCObject[numZombies];
		MapCell[] zombieCells = search.getTownMap().getZombieCells(numZombies);
		
		for (int x = 0; x < numZombies; x++) {
			
			zombies[x] = new NPCObject(zombieCells[x]);
			
		}
		
		//int playerPathLength;
		
		
		
		int currentPathLength = 0;
		int foundCandies = 0;
		
		
		MapCell start = search.getTownMap().getStart();
		
		start.markHero();
		sequence = "PCPUSH"+start.getIdentifier();
		player.move(start);
		start.setType(MapCell.CellType.INITIAL);

		/**
		 * Keep looping while there are more paths to check and we still can hold more candies.
		 */
		while (!player.getStack().isEmpty() && foundCandies < search.getTownMap().bagSize() && currentPathLength < playerPathLength && !eaten) {

			// This updates the map to reflect where the PC token and NPC tokens have moved.
			start.setType(MapCell.CellType.INITIAL);
			search.getTownMap().repaint();
			
			if(!superHero) {	
				MapCell playerCurrent = player.getStack().peek();
				MapCell playerNext;
				
				//System.out.println("Candies: " + foundCandies);
				
				playerNext = player.getMove(playerCurrent);
	
				if (playerNext != null) {
					
					/**
					 * We found a candy.
					 */
					if (playerNext.isCandy()) {
						
						System.out.println("Found a candy and put it in Bryan's bag! Superhero mode activated");
						foundCandies++;
						superHero = true;
	
					} // end if
	
					
					playerNext.markInStack();
					if (playerNext.getIdentifier() == 45) {
						System.out.println();
					}
					sequence += "PCPUSH"+playerNext.getIdentifier();
					player.move(playerNext);
					currentPathLength++;
	
				} // end if
	
				else {
	
					MapCell temp = player.getStack().pop();
					temp.markOutStack();
					sequence += "PCPOP"+temp.getIdentifier();
					player.popMove(temp);
					currentPathLength++;
	
				} // end else
			}
			
			// THIS IS WHERE THE NORMAL PLAYER BEHAVIOUR ENDS
			// Superhero behaviour starts here.
			else {
				
				// FILL IN HERE WITH THE ADVANCEDPLAYEROBJECT BEHAVIOUR
				
				AdvancedPlayerObject superHeroToken = new AdvancedPlayerObject(player.getStack().peek());
				MapCell superHeroCell;
				for (int x = 0; x < 2; x++) {
					
					superHeroCell = superHeroToken.getMove(superHeroToken.cell);
					//if (superHeroCell != null) { superHeroToken.move(superHeroCell); }
					if (superHeroCell != null && superHeroToken.getCollision()) {
						
						superHeroToken.smiteZombie(superHeroCell, zombies);
						sequence += "PCSMITE"+superHeroCell.getIdentifier();
					}
					
					
				}
				superHero = false;
				superHeroToken.endSuperMode();
				
				
			}
			// End Superhero behaviour.
				
				// Update the zombie moves
					for (int x = 0; x < numZombies && zombiesMove; x++) {
						
						if(zombies[x] != null) {
							zombies[x].queueMovePlan();
							zombies[x].move();
							if (zombies[x].checkHeroCollision()) {
								//currentPathLength = Integer.MAX_VALUE;
								System.out.println("Zombie ate the hero!");
								sequence += "PCEATEN";
								eaten = true;
								zombiesMove = false;
							}
						}
						
					} // End Zombie Move.
					
			
		
				
	} // end while for not finished path.
			
			while (!player.getStack().isEmpty() && !eaten) {
				
				//player.getStack().pop().markOutStack();
				search.getTownMap().repaint();
				MapCell temp = player.getStack().pop();
				temp.markOutStack();
				sequence += "PCPOP"+temp.getIdentifier();
				player.popMove(temp);
				currentPathLength++;
				
				for (int x = 0; x < numZombies && zombiesMove; x++) {
					
					if(zombies[x] != null) {
						zombies[x].queueMovePlan();
						zombies[x].move();
						if (zombies[x].checkHeroCollision()) {
							//currentPathLength = Integer.MAX_VALUE;
							System.out.println("Zombie ate the hero!");
							sequence += "PCEATEN";
							eaten = true;
							zombiesMove = false;
						}
					}
					
				}
				
				
			} //end while for finished path
	
		
		if (foundCandies == 1) {
			System.out.println("Search completed. Found " + foundCandies + " piece of candy.");
		} else {
			System.out.println("Search completed. Found " + foundCandies + " candies.");
		}

	} // end main

} // end StartSearch