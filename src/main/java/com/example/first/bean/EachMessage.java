package com.example.first.bean;

import java.time.LocalDateTime;

public class EachMessage {
	private String message;
	private Players player;
	private LocalDateTime timeStamp;
	
	public EachMessage() {
		// TODO Auto-generated constructor stub
	}

	public EachMessage(String message, Players player, LocalDateTime timeStamp) {
		super();
		this.message = message;
		this.player = player;
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Players getPlayer() {
		return player;
	}

	public void setPlayer(Players player) {
		this.player = player;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "EachMessage [message=" + message + ", player=" + player + ", timeStamp=" + timeStamp + "]";
	}
	
}
