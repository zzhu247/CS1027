
public class HockeyGame {
	
	private HockeyTeam toronto;
	private HockeyTeam montreal;
	private String[] torontoPlayers = new String[] { "Tavares", "Matthews", "Marner", "Rielly", "Ceci" };
	private String[] montrealPlayers = new String[] { "Tatar", "Danault", "Lehkonen", "Chiarot", "Weber" };
	private int goalsToWin = 3;
	private ArrayStack<HockeyEvent> eventLog;
	
	
	public HockeyGame () {
		
		eventLog = new ArrayStack<HockeyEvent>();
		
	}
	
	public void emptyEventLog() {
		
		while (eventLog.isEmpty() == false) {
			
			System.out.println(eventLog.pop().toString());
			
		}
		
	}
	
	public void simulate () {
		
		toronto = new HockeyTeam(torontoPlayers,"Toronto");
		montreal = new HockeyTeam(montrealPlayers,"Montreal");
		
		boolean torontoPossession = true;
		boolean intercept = false, pass = false;
		
		//Simulation code goes inside
		while (toronto.getGoals() < this.goalsToWin && montreal.getGoals() < this.goalsToWin) {
			
			//If we have an intercept, we will want to set possession manually.
			//Otherwise, simulate randomly which team gets the puck.
			if (!intercept & !pass) {
				
				if(HockeyGame.rollDice() >= 50) { 
					
					torontoPossession = true; 
					eventLog.push(new HockeyEvent(torontoPlayers[HockeyGame.randomPlayerNumber()],"Toronto", "retrieved the puck"));
					
				}
				else { 
					
					torontoPossession = false; 
					eventLog.push(new HockeyEvent(montrealPlayers[HockeyGame.randomPlayerNumber()],"Montreal", "retrieved the puck"));
					
				}
				
			}
			else if (intercept) {
				intercept = false;
				torontoPossession = !torontoPossession;
			}
			
			//Any previous pass flags are reset as we move into the simulation behaviour.
			pass = false;
				
			// This is the code block for the Toronto team's events.
			if(torontoPossession) {
					
					int randomEvent = HockeyGame.rollDice();
					//System.out.println(randomEvent);
					if (randomEvent <= 10) {
						eventLog.push(new HockeyEvent(torontoPlayers[HockeyGame.randomPlayerNumber()],"Toronto", "lost the puck! It's loose now!"));
						this.emptyEventLog();
						//System.out.println("Toronto lose puck, return to stage 1");
						continue;
					}
					else if (randomEvent <= 20){
						eventLog.push(new HockeyEvent(torontoPlayers[HockeyGame.randomPlayerNumber()],"Toronto", "Toronto puck is intercepted!"));
						intercept = true;
						this.emptyEventLog();
						//System.out.println("Toronto puck is intercepted!");
						continue;
					}
					else if (randomEvent <= 80) {
						eventLog.push(new HockeyEvent(torontoPlayers[HockeyGame.randomPlayerNumber()],"Toronto", "Toronto pass the puck!"));
						pass = true;
						toronto.addPass();
						//System.out.println("Toronto pass the puck!");
						continue;
					}
					else if (randomEvent <= 90) {
						eventLog.push(new HockeyEvent(torontoPlayers[HockeyGame.randomPlayerNumber()],"Toronto", "Toronto shoot but miss the score!"));
						toronto.addShot();
						//System.out.println("Toronto shoot but miss the score!");
						continue;
					}
					else {
						eventLog.push(new HockeyEvent(torontoPlayers[HockeyGame.randomPlayerNumber()],"Toronto", "Toronto shoot and score!"));
						toronto.addGoal();
						toronto.addShot();
						this.emptyEventLog();
						//System.out.println("Toronto shoot and score!");
						continue;
					}
				
				
				
				
			} // End Toronto Possession.
			//This is the code block for Montreal team events
			else {
				
				int randomEvent = HockeyGame.rollDice();
				//System.out.println(randomEvent);
				if (randomEvent <= 10) {
					eventLog.push(new HockeyEvent(montrealPlayers[HockeyGame.randomPlayerNumber()],"Montreal", "lost the puck! It's loose now!"));
					this.emptyEventLog();
					//System.out.println("Montreal lose puck, return to stage 1");
					continue;
				}
				else if (randomEvent <= 20){
					eventLog.push(new HockeyEvent(montrealPlayers[HockeyGame.randomPlayerNumber()],"Montreal", "Montreal puck is intercepted!"));
					intercept = true;
					this.emptyEventLog();
					//System.out.println("Montreal puck is intercepted!");
					continue;
					
				}
				else if (randomEvent <= 80) {
					eventLog.push(new HockeyEvent(montrealPlayers[HockeyGame.randomPlayerNumber()],"Montreal", "Montreal pass the puck!"));
					pass = true;
					montreal.addPass();
					//System.out.println("Montreal pass the puck!");
					continue;
				}
				else if (randomEvent <= 90) {
					eventLog.push(new HockeyEvent(montrealPlayers[HockeyGame.randomPlayerNumber()],"Montreal", "Montreal shoot but miss the score!"));
					montreal.addShot();
					//System.out.println("Montreal shoot but miss the score!");
					continue;
					
				}
				else {
					eventLog.push(new HockeyEvent(montrealPlayers[HockeyGame.randomPlayerNumber()],"Montreal", "Montreal shoot and score!"));
					montreal.addGoal();
					montreal.addShot();
					this.emptyEventLog();
					//System.out.println("Montreal shoot and score!");
					continue;
					
					
				}
				
				
				
				
				
			} // End Montreal simulation code.
			
			
		} // End while loop
		
		//Put final score output here.
		System.out.println("FINAL SCORE\n");
		System.out.println("TORONTO with " + toronto.getGoals() + " goals and " + toronto.getShots() + " shots and " + toronto.getPasses() + " passes\n");
		System.out.println("VS\n");
		System.out.println("MONTREAL with " + montreal.getGoals() + " goals and " + montreal.getShots() + " shots and " + montreal.getPasses() + " passes\n");
		
	}
	
	public static int rollDice() {
		
		return ((int)(Math.random()*100)+1);
		
	}
	
	public static int randomPlayerNumber() {
		return (int)(Math.random()*5);
	}
	

	public static void main(String[] args) {
		
		HockeyGame simulateGame = new HockeyGame();
		simulateGame.simulate();
		
		
	}

}