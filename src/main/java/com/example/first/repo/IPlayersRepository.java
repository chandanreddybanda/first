package com.example.first.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.first.bean.Players;

@Repository
public interface IPlayersRepository extends MongoRepository<Players, String> {
	
}
