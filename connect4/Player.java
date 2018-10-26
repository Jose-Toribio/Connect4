package connect4;

public class Player{
	
	private String playerSymbol;
	private String playerName;
	
	public Player() {
		playerSymbol = " * ";
		playerName = "PlayDoe";
	}
	
	public Player(String name, String symbol) {
		playerSymbol = name;
		playerName = symbol;
	}
	
	public String getSymbol() {
		return playerSymbol;
	}
	
	public String getName() {
		return playerName;
	}
	
	public void setSymbol(String symbol) {
		playerSymbol = symbol;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Player) {
			Player otherPlayer = (Player)o;
			if (this.playerName.equalsIgnoreCase(otherPlayer.playerName)) {
				if (this.playerSymbol.equalsIgnoreCase(otherPlayer.playerSymbol)) {
					return true;
				}
			}
		}
		return false;
	}
	
}
