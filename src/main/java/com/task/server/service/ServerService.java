package com.task.server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.task.server.model.Server;
import com.task.server.repository.ServerRepository;

@Service
public class ServerService {
	
	@Autowired
	private ServerRepository serverRepository;
	
	//Create Operation
	public Server create(Server server) {
		return serverRepository.save(server);
	}
	
	//Retrieve Operations
	public List<Server> getAll() {
		return serverRepository.findAll();
	}
	
	public Server getServerByName(String name) {
		return serverRepository.findByName(name);
	}
	
	public Optional<Server> getServerById(String id) {
			return serverRepository.findById(id);
	}
	
	//Delete Operation
	public void delete(String id) {
		Optional<Server> s  = serverRepository.findById(id);
		Server snew  = s.get();
		serverRepository.delete(snew);
	}
}
