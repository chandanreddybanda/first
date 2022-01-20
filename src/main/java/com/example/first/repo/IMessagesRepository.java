package com.example.first.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.first.bean.Messages;

@Repository
public interface IMessagesRepository extends MongoRepository<Messages, String> {
	
}
