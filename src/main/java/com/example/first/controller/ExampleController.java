package com.example.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.first.models.request.NewMessage;
import com.example.first.models.response.EachPlayerMessage;
import com.example.first.models.response.Value;
import com.example.first.service.SingleService;

@CrossOrigin
@Controller
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExampleController {
	@Autowired
	private SingleService service;
	
	@GetMapping(path = "/home")
	public ResponseEntity<Value> home() {
		return ResponseEntity.ok(new Value("Hello You have Reached Home Page"));
	}
	
	@GetMapping(path = "/group/create/{groupId}/{playerName}")
	public ResponseEntity<Value> createGroup(@PathVariable String groupId,@PathVariable String playerName) {
		return service.createGroup(groupId, playerName);
	}
	
	@GetMapping(path = "/group/join/{groupId}/{playerName}")
	public ResponseEntity<Value> joinGroup(@PathVariable String groupId,@PathVariable String playerName) {
		return service.joinGroup(groupId, playerName);
	}
	
	@GetMapping(path = "/messages/{groupId}")
	public ResponseEntity<List<EachPlayerMessage>> getMessagesFromGroup(@PathVariable String groupId) {
		return service.getMessagesFromAGroup(groupId);
	}
	
	@PostMapping(path = "/messages/send")
	public ResponseEntity<List<EachPlayerMessage>> addNewMessage(@RequestBody NewMessage message){
		return service.addMessageToAGroup(message.groupId, message.playerName, message.message);
	}
}
