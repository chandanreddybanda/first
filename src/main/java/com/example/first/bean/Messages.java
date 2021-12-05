package com.example.first.bean;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Messages {
	@Id
	private String groupId;
	private List<EachMessage> messages;
	
	public Messages() {
		// TODO Auto-generated constructor stub
	}

	public Messages(String groupId, List<EachMessage> messages) {
		super();
		this.groupId = groupId;
		this.messages = messages;
	}
	
	public void addNewMessage(EachMessage newMessage) {
		this.messages.add(newMessage);
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public List<EachMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<EachMessage> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "Messages [groupId=" + groupId + ", messages=" + messages + "]";
	}
	
	
}
