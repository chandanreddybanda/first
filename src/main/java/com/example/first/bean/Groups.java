package com.example.first.bean;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Groups {
	@Id
	private String groupId;
	private Players groupOwner;
	private List<Players> playersInGroup;
	
	public Groups() {
		// TODO Auto-generated constructor stub
	}

	public Groups(String groupId, Players groupOwner, List<Players> playersInGroup) {
		super();
		this.groupId = groupId;
		this.groupOwner = groupOwner;
		this.playersInGroup = playersInGroup;
	}
	
	public void addNewPlayerToGroup(Players newPlayer) {
		this.playersInGroup.add(newPlayer);
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Players getGroupOwner() {
		return groupOwner;
	}

	public void setGroupOwner(Players groupOwner) {
		this.groupOwner = groupOwner;
	}

	public List<Players> getPlayersInGroup() {
		return playersInGroup;
	}

	public void setPlayersInGroup(List<Players> playersInGroup) {
		this.playersInGroup = playersInGroup;
	}

	@Override
	public String toString() {
		return "Groups [groupId=" + groupId + ", groupOwner=" + groupOwner + ", playersInGroup=" + playersInGroup + "]";
	}
	
}
