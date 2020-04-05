package com.task.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.task.server.model.Server;

@Repository
public interface ServerRepository extends MongoRepository<Server, String> {
	public Server findByName(String name);
}
