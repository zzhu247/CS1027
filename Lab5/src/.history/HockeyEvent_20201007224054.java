
public class HockeyEvent {
	
	private String playerName;
	private String eventType;
	private String teamName;
	
	public HockeyEvent(String player_name, String teamName, String event_type) {
		this.playerName = player_name;
		this.teamName = teamName;
		this.eventType = event_type;
	}
	
	public String getPlayerName() {
		return this.playerName;
	}
	
	public String getEventType() {
		return this.eventType;
	}
	
	public String getTeam() {
		return this.teamName;
	}
	
	public String toString() {
		return playerName + " from " + teamName + " " + eventType; 
	}
	

}