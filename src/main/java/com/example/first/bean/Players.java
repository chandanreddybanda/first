package com.example.first.bean;

import org.springframework.data.annotation.Id;

public class Players {
	
	@Id
	private String playerName;
	private String playerId;
	
	public Players() {
		// TODO Auto-generated constructor stub
	}
	
	public Players(String playerId, String playerName) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
	}
	
	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	@Override
	public String toString() {
		return "Players [playerId=" + playerId + ", playerName=" + playerName + "]";
	}
}
