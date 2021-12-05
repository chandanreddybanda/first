package com.example.first.service;

import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.first.bean.EachMessage;
import com.example.first.bean.Groups;
import com.example.first.bean.Messages;
import com.example.first.bean.Players;
import com.example.first.models.response.EachPlayerMessage;
import com.example.first.models.response.Value;
import com.example.first.repo.IGroupsRepository;
import com.example.first.repo.IMessagesRepository;
import com.example.first.repo.IPlayersRepository;

@Service
public class SingleService {

	@Autowired
	IGroupsRepository groupsRepo;
	
	@Autowired
	IMessagesRepository messagesRepo;
	
	@Autowired
	IPlayersRepository playersRepo;
	
	public ResponseEntity<Value> createGroup(String groupId, String playerName) {
		if(groupsRepo.existsById(groupId)) {
			return ResponseEntity.status(402).body(new Value("Group already exists"));
		}
		long randomPlayerId = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		Players groupOwner = new Players(Long.toString(randomPlayerId),playerName);
		playersRepo.save(groupOwner);
		List<Players> listOfPlayers = new ArrayList<>();
		listOfPlayers.add(groupOwner);
		Groups newGroup = new Groups(groupId,groupOwner,listOfPlayers);
		if(groupsRepo.save(newGroup) != null) {
			return ResponseEntity.ok()
					.body(new Value("Group Created GroupId : " + groupId + " and Owner Name : " + playerName));
		}
		return ResponseEntity.status(403)
				.body(new Value("Group Creation Failed"));
	}
	
	public ResponseEntity<Value> joinGroup(String groupId,String playerName) {
		if(!groupsRepo.existsById(groupId)) {
			return ResponseEntity.status(412).body(new Value("Group does not exists"));
		}
		long randomPlayerId = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		Players newPlayer = new Players(Long.toString(randomPlayerId),playerName);
		playersRepo.save(newPlayer);
		
		Groups group = groupsRepo.findById(groupId).get();
		group.addNewPlayerToGroup(newPlayer);
		groupsRepo.save(group);
		return ResponseEntity.ok(new Value("Player Joined Group : " + group.getGroupId()));
	}
	
	public ResponseEntity<List<EachPlayerMessage>> getMessagesFromAGroup(String groupId) {
		Optional<Messages> optMessages = messagesRepo.findById(groupId);
		List<EachPlayerMessage> newList = new ArrayList<EachPlayerMessage>();
		if(optMessages.isEmpty()) {
			return ResponseEntity.ok(newList);
		}
		Messages allMessages = optMessages.get();
		List<EachMessage> listMessages = allMessages.getMessages();
		listMessages.sort((m1,m2) -> m1.getTimeStamp().compareTo(m2.getTimeStamp()) >0 ? -1 : 1);
		listMessages.forEach(em -> 
			newList.add(
				new EachPlayerMessage(em.getPlayer().getPlayerName(),em.getMessage(),em.getTimeStamp().toString())
			)
		);
		return ResponseEntity.ok(newList);
	}
	
	public ResponseEntity<List<EachPlayerMessage>> addMessageToAGroup(String groupId,String playerName,String message){
		Messages allMessages = new Messages(groupId,new ArrayList<EachMessage>());
		Players player = playersRepo.findById(playerName).get();
		if(messagesRepo.existsById(groupId)) {
			allMessages = messagesRepo.findById(groupId).get();
		}
		allMessages.addNewMessage(new EachMessage(message, player, LocalDateTime.now()));
		messagesRepo.save(allMessages);
		return getMessagesFromAGroup(groupId);
	}
	
}
