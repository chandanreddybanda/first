package com.example.first.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.first.bean.Groups;

@Repository
public interface IGroupsRepository extends MongoRepository<Groups, String> {
	
}
