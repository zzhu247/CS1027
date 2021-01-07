
public class HockeyTeam {
	
	private String[] players;
	private String team;
	private int shots;
	private int goals;
	private int passes;
	
	public HockeyTeam (String[] players, String team) {
		this.players = players;
		this.team = team;
		shots = 0;
		goals = 0;
	}
	
	public String getPlayer (int index) {
		return players[index];
	}
	
	public String getTeam () {
		return team;
	}
	
	public void addShot() {
		this.shots++;
	}
	
	public void addGoal() {
		this.goals++;
	}
	
	public void addPass() {
		this.passes++;
	}
	
	public int getPasses() {
		return this.passes;
	}
	
	public int getShots() {
		return this.shots;
	}
	
	public int getGoals() {
		return this.goals;
	}

}